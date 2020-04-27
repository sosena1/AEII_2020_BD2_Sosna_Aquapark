package pl.bd.aquapark.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.dao.Gender;
import pl.bd.aquapark.dao.Role;
import pl.bd.aquapark.repository.GenderRepository;
import pl.bd.aquapark.repository.RoleRepository;
import pl.bd.aquapark.service.GetAllService;

import java.util.List;

@RestController
@RequestMapping("/aquapark")
public class AquaparkController {
    @Autowired
    GenderRepository genderRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value = "/genders")
    public ResponseEntity<List<Gender>> getVisit() {
        return ResponseEntity.ok(GetAllService.getAll(genderRepository));
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(GetAllService.getAll(roleRepository));
    }
}
