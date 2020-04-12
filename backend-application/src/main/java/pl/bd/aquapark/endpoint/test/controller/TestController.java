package pl.bd.aquapark.endpoint.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> getVisits() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("{ \"text\": \"Hello world!\"}");
    }
}

