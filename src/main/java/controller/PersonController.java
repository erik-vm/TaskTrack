package controller;

import model.Person;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person){
        return service.savePerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable(name = "id") Long id){
        return service.getPersonById(id);
    }
}
