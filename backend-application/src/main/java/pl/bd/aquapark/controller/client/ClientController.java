package pl.bd.aquapark.controller.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/test")
public class ClientController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/client/{id}")
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
}
