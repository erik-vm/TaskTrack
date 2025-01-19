package dao;

import model.PersonTask;

import java.util.List;

public interface PersonTaskDao {

    PersonTask savePersonTask(PersonTask personTask);

    PersonTask getPersonTaskById(Long id);

    List<PersonTask> getAllPersonTasks();
}
