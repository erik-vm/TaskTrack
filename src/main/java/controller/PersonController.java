package controller;

import model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Person savePerson(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable(name = "id") Long id) {
        return service.getPersonById(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return service.getAllPersons();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deletePersonById(@PathVariable(name = "id") Long id) {
        service.deletePersonById(id);
    }
}
