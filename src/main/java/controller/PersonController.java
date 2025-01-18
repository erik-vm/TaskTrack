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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable(name = "id") Long id) {
        Person personToFind = service.getPersonById(id);
        if (personToFind == null) {
            return new ResponseEntity<>("Person not found!", BAD_REQUEST);
        }
        return new ResponseEntity<>(personToFind, OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllPersons() {
        List<Person> personList = service.getAllPersons();
        System.out.println(personList);
        if (personList == null) {
            return new ResponseEntity<>("No persons found in a list!", BAD_REQUEST);
        }
        return new ResponseEntity<>(personList, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonById(@PathVariable(name = "id") Long id) {
        int result = service.deletePersonById(id);
        System.out.println(result);
        if (result == 0) {
            return new ResponseEntity<>("Deleting failed!", BAD_REQUEST);
        }
        return new ResponseEntity<>("Delete successful!", OK);
    }
}
