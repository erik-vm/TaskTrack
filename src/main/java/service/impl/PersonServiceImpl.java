package service.impl;

import dao.PersonDao;
import model.Person;
import org.springframework.stereotype.Service;
import service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person savePerson(Person person) {
        return dao.savePerson(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return dao.getPersonById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> people = dao.getAllPersons();
        if (people.isEmpty()) {
            return null;
        }
        return people;
    }

    @Override
    public int deletePersonById(Long id) {
        return dao.deletePersonById(id) == 1 ? 1 : 0;
    }
}
