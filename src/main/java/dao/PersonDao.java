package dao;

import model.Person;

import java.util.List;

public interface PersonDao {

    Person savePerson(Person person);

    Person getPersonById(Long id);

    List<Person> getAllPersons();

    int deletePersonById(Long id);

}
