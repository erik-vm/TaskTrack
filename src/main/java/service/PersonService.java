package service;

import model.Person;

public interface PersonService {
    Person savePerson(Person person);
    Person getPersonById(Long id);

}
