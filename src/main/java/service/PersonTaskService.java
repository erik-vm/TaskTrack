package service;

import model.PersonTask;

import java.util.List;

public interface PersonTaskService {

    PersonTask savePersonTask(PersonTask personTask);

    PersonTask updatePersonTask(PersonTask personTask);

    PersonTask findPersonTaskById(Long id);

    List<PersonTask> getAllPersonTasks();

}
