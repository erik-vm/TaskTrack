package dao;

import model.Person;

public interface PersonDao {

    Person savePerson(Person person);

    Person getPersonById(Long id);
}
