package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.*;
import pl.bd.aquapark.dto.AnonymousVisitDto;
import pl.bd.aquapark.dto.EndVisitDto;
import pl.bd.aquapark.dto.VisitDto;
import pl.bd.aquapark.repository.*;
import pl.bd.aquapark.service.DateService;
import pl.bd.aquapark.service.GetAllService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    VisitRepository visitRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    IdentificatorRepository identificatorRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Visit> getVisit(@PathVariable Long id, HttpServletRequest request) {
        Optional<Visit> visitOptional = visitRepository.findById(id);
        if (!visitOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if (request.isUserInRole(Roles.SUPER_USER.toString()) || visitOptional.get().getClient().getUser().getUserName().equals(request.getUserPrincipal().getName())) {
            return ResponseEntity.ok(visitOptional.get());
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/start_anonymous_visit")
    public ResponseEntity startAnonymousVisit(@RequestBody AnonymousVisitDto anonVisit, HttpServletRequest request) {
        if (!request.isUserInRole(Roles.CASHIER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = new User();
        user.setBirthDate(anonVisit.getBirthDate());
        user.setFirstName(anonVisit.getFirstName());
        user.setLastName(anonVisit.getLastName());
        if (anonVisit.getSexId() != null) {
            user.setGender(genderRepository.findById(anonVisit.getSexId()).get());
        }
        user = userRepository.save(user);

        Client client = new Client();
        client.setOwnsAccount(false);
        client.setUser(user);
        client = clientRepository.save(client);

        ClientIdentificator clientIdentificator = identificatorRepository.findById(anonVisit.getIdentificatorId()).get();
        clientIdentificator.setIsInUse(true);
        clientIdentificator = identificatorRepository.save(clientIdentificator);

        Visit visit = new Visit();
        visit.setDate(DateService.getCurrentDay());
        visit.setClientIdentificator(clientIdentificator);
        visit.setClient(client);
        visit.setValue(new BigDecimal(0));
        visit.setStartTime(DateService.getCurrentTime());

        visit = visitRepository.save(visit);

        return ResponseEntity.status(HttpStatus.OK).body("Started visit with id: " + visit.getVisitId());
    }

    @PostMapping(value = "/start_visit")
    public ResponseEntity startVisit(@RequestBody VisitDto visitDto, HttpServletRequest request) {
        if (!request.isUserInRole(Roles.CASHIER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<User> optionalUser = userRepository.findById(visitDto.getUserId());
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user with that id");
        }

        Optional<ClientIdentificator> optionalIdentificator = identificatorRepository.findById(visitDto.getIdentificatorId());
        if (!optionalIdentificator.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No identificator with that id");
        }

        User user = optionalUser.get();
        ClientIdentificator identificator = optionalIdentificator.get();

        if (identificator.getIsInUse()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Identificator already in use");
        }

        Client client = user.getClient();
        if (client == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not a client");
        }

        //todo check if client is already in some visit

        identificator.setIsInUse(true);
        identificator = identificatorRepository.save(identificator);

        Visit visit = new Visit();
        visit.setDate(DateService.getCurrentDay());
        visit.setClientIdentificator(identificator);
        visit.setClient(client);
        visit.setValue(new BigDecimal(0));
        visit.setStartTime(DateService.getCurrentTime());

        visit = visitRepository.save(visit);
        return ResponseEntity.status(HttpStatus.OK).body("Started visit with id: " + visit.getVisitId());
    }

    @GetMapping(value = "/id_available")
    public ResponseEntity getAvailableIdentifiers(HttpServletRequest request) {
        if (!request.isUserInRole(Roles.CASHIER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<ClientIdentificator> clientIdentificators = GetAllService.getAll(identificatorRepository);
        List<Long> available = new ArrayList<>();
        for (ClientIdentificator clientIdentificator : clientIdentificators) {
            if (!clientIdentificator.getIsInUse()) {
                available.add(clientIdentificator.getIdentificatorId());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(available);
    }

    @PostMapping(value = "/end_visit")
    public ResponseEntity endVisit(@RequestBody EndVisitDto endVisitDto, HttpServletRequest request) {
        if (!request.isUserInRole(Roles.CASHIER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<ClientIdentificator> optionalClientIdentificator = identificatorRepository.findById(endVisitDto.getIdentificatorId());
        if (!optionalClientIdentificator.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such identificator");
        }
        ClientIdentificator identificator = optionalClientIdentificator.get();
        if (!identificator.getIsInUse()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Identificator was not in use");
        }

        //todo check if all Usages ended

        Visit visit = identificator.getActiveVisit();
        identificator.setIsInUse(false);
        visit.setEndTime(DateService.getCurrentTime());

        List<AquaparkAttractionUsage> usages = visit.getAquaparkAttractionUsages();

        BigDecimal cost = new BigDecimal(0);
        for(AquaparkAttractionUsage usage : usages) {
            long time = usage.getTimeSpendInMinutes();
            BigDecimal partialCost = usage.getPriceListItem().getValue().multiply(new BigDecimal(time));
            cost = cost.add(partialCost);
        }

        visit.setValue(cost);
        visitRepository.save(visit);
        identificatorRepository.save(identificator);

        return ResponseEntity.status(HttpStatus.OK).body(visit);
    }
}
