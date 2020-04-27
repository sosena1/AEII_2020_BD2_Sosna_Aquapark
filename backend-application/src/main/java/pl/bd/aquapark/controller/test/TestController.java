package pl.bd.aquapark.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class TestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> test() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("{ \"text\": \"Hello world!\"}");
    }

    @PostMapping(value = "/adduser/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}

