package margo.controllers.api;

import margo.models.Person;
import margo.services.PersonDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonDAOImpl personDAO;

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllUsers() {
        return new ResponseEntity<>(personDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/postPerson")
    public ResponseEntity<List<Person>> createPerson(@Valid @RequestBody Person person) {
        personDAO.savePerson(person);
        return new ResponseEntity(personDAO.getAll(), HttpStatus.OK);
    }
}
