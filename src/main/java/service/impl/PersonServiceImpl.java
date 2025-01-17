package service.impl;

import dao.PersonDao;
import model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.PersonService;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person savePerson(Person person) {
        Person savedPerson = dao.savePerson(person);
        if (savedPerson == null) {
            throw new RuntimeException("Saving person failed!");
        }
        return savedPerson;
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = dao.getPersonById(id);
        if (optionalPerson.isEmpty()) {
            throw new RuntimeException(String.format("Person with id= %s was not found!", id));
        }
        return optionalPerson.get();
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> people = dao.getAllPersons();
        if (people.isEmpty()) {
            throw new RuntimeException("No people found!");
        }
        return people;
    }

    @Override
    public void deletePersonById(Long id) {
        int result = dao.deletePersonById(id);
        if (result == 0) {
            throw new RuntimeException(String.format("Failed to delete person with id= %s!", id));
        }
    }
}
