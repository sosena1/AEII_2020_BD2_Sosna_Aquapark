package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.dto.GateInformationDto;
import pl.bd.aquapark.repository.*;
import pl.bd.aquapark.util.DateUtil;
import pl.bd.aquapark.util.GetAllUtil;
import pl.bd.aquapark.util.PricingUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gate")
public class GateController {

    @Autowired
    AquaparkAttractionGateRepository aquaparkAttractionGateRepository;

    @Autowired
    IdentificatorRepository identificatorRepository;

    @Autowired
    AquaparkGateEventRepository eventRepository;

    @Autowired
    AquaparkAttractionUsageRepository usageRepository;

    @Autowired
    PriceListRepository priceListRepository;

    @PostMapping(value = "enter")
    public ResponseEntity<String> enterEvent(HttpServletRequest servletRequest, @RequestBody GateInformationDto gateInfo) {
        SharedCheckerResponse response = check(servletRequest, gateInfo);
        if (response.getResponse() != null) {
            return response.getResponse();
        }
        AquaparkAttractionGate gate = response.getGate();
        ClientIdentificator identificator = response.getIdentificator();

        if (!identificator.getIsInUse()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("identificator is not in use!");
        }

        PriceListItem priceListItem = PricingUtil.priceListItemForSettings(priceListRepository, identificator.getActiveVisit().getClient().getUser(), gate.getAquaparkAttraction(), DateUtil.getCurrentDay());

        if (priceListItem == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no pricing for this attraction was found");
        }


        Visit activeVisit = identificator.getActiveVisit();

        List<AquaparkAttractionUsage> aquaparkAttractionUsages = activeVisit.getAquaparkAttractionUsages();
        aquaparkAttractionUsages = aquaparkAttractionUsages.stream()
                .filter(aquaparkAttractionUsage -> aquaparkAttractionUsage.getLeavingEvent() == null)
                .collect(Collectors.toList());
        if (aquaparkAttractionUsages.size() != 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already on " + aquaparkAttractionUsages.size() + " attraction(s)");
        }


        AquaparkAttractionGateEvent event = new AquaparkAttractionGateEvent();
        event.setEntering(true);
        event.setDate(DateUtil.getCurrentDay());
        event.setAquaparkAttractionGate(gate);
        event.setClientIdentificator(identificator);
        event.setTime(DateUtil.getCurrentTime());
        AquaparkAttractionGateEvent savedEvent = eventRepository.save(event);

        AquaparkAttractionUsage usage = new AquaparkAttractionUsage();
        usage.setEnteringEvent(savedEvent);
        usage.setAquaparkAttraction(gate.getAquaparkAttraction());
        usage.setVisit(activeVisit);
        usage.setPriceListItem(priceListItem);

        usageRepository.save(usage);

        return ResponseEntity.ok("succesfully entered");
    }

    @PostMapping(value = "exit")
    public ResponseEntity<String> exitEvent(HttpServletRequest servletRequest, @RequestBody GateInformationDto gateInfo) {
        SharedCheckerResponse response = check(servletRequest, gateInfo);
        if (response.getResponse() != null) {
            return response.getResponse();
        }
        AquaparkAttractionGate gate = response.getGate();
        ClientIdentificator identificator = response.getIdentificator();

        if (!identificator.getIsInUse()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("identificator is not in use!");
        }

        Visit activeVisit = identificator.getActiveVisit();

        AquaparkAttractionGateEvent event = new AquaparkAttractionGateEvent();
        event.setEntering(false);
        event.setDate(DateUtil.getCurrentDay());
        event.setAquaparkAttractionGate(gate);
        event.setTime(DateUtil.getCurrentTime());
        event.setClientIdentificator(identificator);
        AquaparkAttractionGateEvent savedEvent = eventRepository.save(event);

        //znalezienie aktualnego usage
        List<AquaparkAttractionUsage> usages = GetAllUtil.getAll(usageRepository);
        List<AquaparkAttractionUsage> usagesForThisAttractionAndVisitAndNotEnded = usages.stream()
                .filter((AquaparkAttractionUsage us) -> us.getVisit().equals(activeVisit))
                .filter((AquaparkAttractionUsage us) -> us.getAquaparkAttraction().equals(gate.getAquaparkAttraction()))
                .filter((AquaparkAttractionUsage us) -> us.getLeavingEvent() == null).collect(Collectors.toList());

        int size = usagesForThisAttractionAndVisitAndNotEnded.size();
        if (size != 1) {
            if (size == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no usages active! Did you really enter any attraction?");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("too many usages active! Did you enter too many attractions without leaving? Size: " + size + ".");
            }
        }


        AquaparkAttractionUsage usage = usagesForThisAttractionAndVisitAndNotEnded.get(0);
        usage.setLeavingEvent(savedEvent);
        usageRepository.save(usage);

        return ResponseEntity.ok("succesfully exited");
    }

    private SharedCheckerResponse check(HttpServletRequest servletRequest, GateInformationDto gateInfo) {

        if (!servletRequest.isUserInRole(Roles.GATE.toString())) {
            return new SharedCheckerResponse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        }
        if (gateInfo.getGateId() == null || gateInfo.getIdentificatorId() == null) {
            return new SharedCheckerResponse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("gateId or identificatorId is null"));
        }
        long gateId = gateInfo.getGateId();
        long identificatorId = gateInfo.getIdentificatorId();
        Optional<AquaparkAttractionGate> gateOptional = aquaparkAttractionGateRepository.findById(gateId);
        Optional<ClientIdentificator> clientIdentificatorOptional = identificatorRepository.findById(identificatorId);
        if (!gateOptional.isPresent()) {
            return new SharedCheckerResponse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("gate does not exist"));
        }
        if (!clientIdentificatorOptional.isPresent()) {
            return new SharedCheckerResponse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("identificator does not exist"));
        }
        AquaparkAttractionGate gate = gateOptional.get();
        ClientIdentificator clientIdentificator = clientIdentificatorOptional.get();
        return new SharedCheckerResponse(gate, clientIdentificator, null);
    }

    private static class SharedCheckerResponse {
        private AquaparkAttractionGate gate;
        private ClientIdentificator identificator;
        private ResponseEntity<String> response;

        public SharedCheckerResponse(ResponseEntity<String> response) {
            this.response = response;
        }

        public SharedCheckerResponse(AquaparkAttractionGate gate, ClientIdentificator identificator, ResponseEntity<String> response) {
            this.gate = gate;
            this.identificator = identificator;
            this.response = response;
        }

        public AquaparkAttractionGate getGate() {
            return this.gate;
        }

        public ClientIdentificator getIdentificator() {
            return this.identificator;
        }

        public ResponseEntity<String> getResponse() {
            return this.response;
        }

        public void setGate(AquaparkAttractionGate gate) {
            this.gate = gate;
        }

        public void setIdentificator(ClientIdentificator identificator) {
            this.identificator = identificator;
        }

        public void setResponse(ResponseEntity<String> response) {
            this.response = response;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof SharedCheckerResponse)) return false;
            final SharedCheckerResponse other = (SharedCheckerResponse) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$gate = this.getGate();
            final Object other$gate = other.getGate();
            if (this$gate == null ? other$gate != null : !this$gate.equals(other$gate)) return false;
            final Object this$identificator = this.getIdentificator();
            final Object other$identificator = other.getIdentificator();
            if (this$identificator == null ? other$identificator != null : !this$identificator.equals(other$identificator))
                return false;
            final Object this$response = this.getResponse();
            final Object other$response = other.getResponse();
            if (this$response == null ? other$response != null : !this$response.equals(other$response)) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof SharedCheckerResponse;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $gate = this.getGate();
            result = result * PRIME + ($gate == null ? 43 : $gate.hashCode());
            final Object $identificator = this.getIdentificator();
            result = result * PRIME + ($identificator == null ? 43 : $identificator.hashCode());
            final Object $response = this.getResponse();
            result = result * PRIME + ($response == null ? 43 : $response.hashCode());
            return result;
        }

        public String toString() {
            return "GateController.SharedCheckerResponse(gate=" + this.getGate() + ", identificator=" + this.getIdentificator() + ", response=" + this.getResponse() + ")";
        }
    }
}
