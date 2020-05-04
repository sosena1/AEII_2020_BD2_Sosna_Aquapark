package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.Client;
import pl.bd.aquapark.dao.ClientIdentificator;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.dao.Visit;
import pl.bd.aquapark.dto.AnonymousVisitDto;
import pl.bd.aquapark.repository.*;
import pl.bd.aquapark.service.DateService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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

        if (visitOptional.get().getClient().getUser().getUserName().equals(request.getUserPrincipal().getName())) {
            return ResponseEntity.ok(visitOptional.get());
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/start_anonymous_visit")
    public ResponseEntity startAnonymousVisit(@RequestBody AnonymousVisitDto anonVisit, HttpServletRequest request) {
        if (!request.isUserInRole(Roles.SELLER.toString())) {
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

        ClientIdentificator clientIdentificator = identificatorRepository.findById(anonVisit.getClientIdentificator()).get();
        clientIdentificator.setIsInUse(true);
        clientIdentificator = identificatorRepository.save(clientIdentificator);

        Visit visit = new Visit();
        visit.setDate(DateService.getCurrentDay());
        visit.setClientIdentificator(clientIdentificator);
        visit.setClient(client);
        visit.setValue(new BigDecimal(0));
        visit.setStartTime(DateService.getCurrentTime());

        visitRepository.save(visit);

        return ResponseEntity.ok().build();
    }
}
