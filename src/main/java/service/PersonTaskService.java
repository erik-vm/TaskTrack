package service;

import model.PersonTask;

import java.util.List;

public interface PersonTaskService {

    PersonTask startPersonTask(PersonTask personTask);

    PersonTask finishPersonTaskById(Long id, PersonTask personTask);

    PersonTask findPersonTaskById(Long id);

    List<PersonTask> getAllPersonTasks();

}
