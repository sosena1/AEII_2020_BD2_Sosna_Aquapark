package pl.bd.aquapark.controller.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.repository.UserRepository;
import pl.bd.aquapark.service.FilteringService;
import pl.bd.aquapark.service.GetAllService;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id, HttpServletRequest request) {
        boolean authorized = false;
        if (request.isUserInRole(Roles.SELLER.getAuthority())) {
            authorized = true;
        }
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent() && Objects.equals(user.get().getUserName(), request.getUserPrincipal().getName())) {
            authorized = true;
        }
        if (!authorized) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String pesel,
            HttpServletRequest request) {
        if (!request.isUserInRole(Roles.SELLER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<User> users = GetAllService.getAll(userRepository);
        users = new FilteringService<>(users)
                .contains(firstName, User::getFirstName)
                .contains(lastName, User::getLastName)
                .contains(pesel, User::getPesel).getFiltered();
        return ResponseEntity.ok(users);
    }
}
