package pl.bd.aquapark.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.dto.GateInformationDto;
import pl.bd.aquapark.repository.*;
import pl.bd.aquapark.service.DateService;
import pl.bd.aquapark.service.GetAllService;
import pl.bd.aquapark.service.PricingService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Comparator;
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
    @Transactional
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

        PriceListItem priceListItem = PricingService.priceListItemForSettings(priceListRepository, identificator.getActiveVisit().getClient().getUser(), gate.getAquaparkAttraction(), DateService.getCurrentDay());

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
        event.setDate(DateService.getCurrentDay());
        event.setAquaparkAttractionGate(gate);
        event.setClientIdentificator(identificator);
        event.setTime(DateService.getCurrentTime());
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
    @Transactional
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
        event.setDate(DateService.getCurrentDay());
        event.setAquaparkAttractionGate(gate);
        event.setTime(DateService.getCurrentTime());
        event.setClientIdentificator(identificator);
        AquaparkAttractionGateEvent savedEvent = eventRepository.save(event);

        //znalezienie aktualnego usage
        List<AquaparkAttractionUsage> usages = GetAllService.getAll(usageRepository);
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

    private @Data @AllArgsConstructor static class SharedCheckerResponse {
        private AquaparkAttractionGate gate;
        private ClientIdentificator identificator;
        private ResponseEntity<String> response;

        public SharedCheckerResponse(ResponseEntity<String> response) {
            this.response = response;
        }
    }
}
