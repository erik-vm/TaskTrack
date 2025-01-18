package service;

import model.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);

    Person getPersonById(Long id);

    List<Person> getAllPersons();

    int deletePersonById(Long id);
}
