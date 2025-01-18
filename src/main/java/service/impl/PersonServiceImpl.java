package service.impl;

import dao.PersonDao;
import model.Person;
import org.springframework.stereotype.Service;
import service.PersonService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person savePerson(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        return dao.savePerson(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return dao.getPersonById(id);
    }

    @Override
    public Person updatePersonById(Long id, Person person) {
        Person personToUpdate = dao.getPersonById(id);
        if (personToUpdate != null) {
            personToUpdate.setFirstName(person.getFirstName());
            personToUpdate.setLastName(person.getLastName());
            personToUpdate.setEmail(person.getEmail());
            personToUpdate.setPhoneNumber(person.getPhoneNumber());
            personToUpdate.setUpdatedAt(LocalDateTime.now());
            return dao.savePerson(personToUpdate);
        }
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        return dao.getAllPersons();
    }

    @Override
    public int deletePersonById(Long id) {
        return dao.deletePersonById(id) == 1 ? 1 : 0;
    }
}
