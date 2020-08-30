package pl.bd.aquapark.controller;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.Client;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.dto.UserCreateDto;
import pl.bd.aquapark.repository.ClientRepository;
import pl.bd.aquapark.repository.GenderRepository;
import pl.bd.aquapark.repository.UserRepository;
import pl.bd.aquapark.service.FilteringService;
import pl.bd.aquapark.service.GetAllService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity getClient(@PathVariable Long id, HttpServletRequest request) {
        boolean authorized = false;
        if (request.isUserInRole(Roles.CASHIER.toString())) {
            authorized = true;
        }
        Optional<Client> user = clientRepository.findById(id);
        if (user.isPresent() && Objects.equals(user.get().getUser().getUserName(), request.getUserPrincipal().getName())) {
            authorized = true;
        }
        if (!authorized) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You need to be client with this ID or needs to be in role CASHIER to view this information");
        }
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such client");
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String pesel,
            HttpServletRequest request) {
        if (!request.isUserInRole(Roles.CASHIER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Client> clients = GetAllService.getAll(clientRepository);
        clients = new FilteringService<>(clients)
                .contains(firstName, (Client client) -> client.getUser().getFirstName())
                .contains(lastName, (Client client) -> client.getUser().getLastName())
                .contains(pesel, (Client client) -> client.getUser().getPesel()).getFiltered();
        return ResponseEntity.ok(clients);
    }

    @PostMapping(value = "/create")
    public ResponseEntity createClient(@RequestBody UserCreateDto userCreateDto) {
        //todo check edge cases

        if (userRepository.findUserByUserName(userCreateDto.getUserName()).size() != 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this username exists");
        }
        if (userRepository.findUserByPesel(userCreateDto.getPesel()).size() != 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this pesel exists");
        }



        User user = new User();
        user.setGender(genderRepository.findById(userCreateDto.getGenderId()).get());
        user.setFirstName(userCreateDto.getName());
        user.setLastName(userCreateDto.getSurname());
        user.setBirthDate(userCreateDto.getBirthDate());
        user.setAddress(userCreateDto.getAddress());
        user.setOtherInformation(userCreateDto.getOtherInformation());
        user.setContactNumber(userCreateDto.getContactNumber());
        user.setPesel(userCreateDto.getPesel());

        user.setUserName(userCreateDto.getUserName());
        user.setPassword(userCreateDto.getPassword());

        user = userRepository.saveAndFlush(user);

        Client client = new Client();
        client.setUser(user);
        client.setOwnsAccount(true);
        client = clientRepository.saveAndFlush(client);
        user.setClient(client);
        user = userRepository.saveAndFlush(user);


        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findById(client.getClientId()).get());
    }
}
