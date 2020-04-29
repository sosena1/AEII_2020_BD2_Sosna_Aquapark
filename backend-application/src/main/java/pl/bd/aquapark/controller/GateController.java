package pl.bd.aquapark.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
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
import pl.bd.aquapark.service.DateService;
import pl.bd.aquapark.service.PricingService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Optional;

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

        PriceListItem priceListItem = PricingService.priceListItemForSettings(priceListRepository, identificator.getActiveVisit().getClient().getUser(), gate.getAquaparkAttraction(), DateService.getCurrentDay());

        if (priceListItem == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no pricing for this attraction was found");
        }

        Visit activeVisit = identificator.getActiveVisit();

        AquaparkAttractionGateEvent event = new AquaparkAttractionGateEvent();
        event.setEntering(true);
        event.setDate(DateService.getCurrentDay());
        event.setAquaparkAttractionGate(gate);
        event.setClientIdentificator(identificator);
        AquaparkAttractionGateEvent savedEvent = eventRepository.save(event);

        AquaparkAttractionUsage usage = new AquaparkAttractionUsage();
        usage.setEnteringEvent(savedEvent);
        usage.setAquaparkAttraction(gate.getAquaparkAttraction());
        usage.setVisit(activeVisit);
        usage.setPriceListItem(priceListItem);
        usageRepository.save(usage);

        return ResponseEntity.ok("succesfully entered");
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
