package pl.bd.aquapark.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.repository.ClientRepository;
import pl.bd.aquapark.repository.GenderRepository;
import pl.bd.aquapark.repository.UserRepository;
import pl.bd.aquapark.util.FilteringUtil;
import pl.bd.aquapark.util.GetAllUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable Long id, HttpServletRequest request) {
        boolean authorized = false;
        if (request.isUserInRole(Roles.OWNER.toString())) {
            authorized = true;
        }
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent() && Objects.equals(user.get().getUserName(), request.getUserPrincipal().getName())) {
            authorized = true;
        }
        if (!authorized) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You need to be user with this ID or needs to be in role OWNER to view this information");
        }
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such user");
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String pesel,
            HttpServletRequest request) {
        if (!request.isUserInRole(Roles.CASHIER.toString())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<User> users = GetAllUtil.getAll(userRepository);
        users = new FilteringUtil<>(users)
                .contains(firstName, User::getFirstName)
                .contains(lastName, User::getLastName)
                .contains(pesel, User::getPesel).getFiltered();
        return ResponseEntity.ok(users);
    }
}
