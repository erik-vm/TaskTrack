package dao;

import model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

    Person savePerson(Person person);

    Optional <Person> getPersonById(Long id);

    List<Person> getAllPersons();

    int deletePersonById(Long id);

}
