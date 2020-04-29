package pl.bd.aquapark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bd.aquapark.dao.Visit;
import pl.bd.aquapark.repository.VisitRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    VisitRepository visitRepository;

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
}
