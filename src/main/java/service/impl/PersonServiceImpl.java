package service.impl;

import dao.PersonDao;
import model.Person;
import org.springframework.stereotype.Service;
import service.PersonService;

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
}
