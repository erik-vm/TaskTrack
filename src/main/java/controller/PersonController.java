package controller;

import jakarta.validation.Valid;
import model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Validated
@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Person savePerson(@RequestBody @Valid Person person) {
        return service.savePerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable(name = "id") Long id, @RequestBody @Valid Person person) {
        Person personToUpdate = service.updatePersonById(id, person);
        if (personToUpdate == null) {
            return new ResponseEntity<>("Person update failed! Check id!", BAD_REQUEST);
        }
        return new ResponseEntity<>(personToUpdate, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable(name = "id") Long id) {
        Person personToFind = service.getPersonById(id);
        if (personToFind == null) {
            return new ResponseEntity<>("Person not found! Check id!", BAD_REQUEST);
        }
        return new ResponseEntity<>(personToFind, OK);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return service.getAllPersons();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonById(@PathVariable(name = "id") Long id) {
        int result = service.deletePersonById(id);
        if (result == 0) {
            return new ResponseEntity<>("Deleting failed! Check id", BAD_REQUEST);
        }
        return new ResponseEntity<>("Delete successful!", OK);
    }
}
