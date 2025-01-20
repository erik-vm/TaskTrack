package service.impl;

import dao.PersonTaskDao;
import model.PersonTask;
import org.springframework.stereotype.Service;
import service.PersonTaskService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonTaskServiceImpl implements PersonTaskService {

    private final PersonTaskDao dao;

    public PersonTaskServiceImpl(PersonTaskDao dao) {
        this.dao = dao;
    }

    @Override
    public PersonTask startPersonTask(PersonTask personTask) {
        personTask.setStartedAt(LocalDateTime.now());
        return dao.savePersonTask(personTask);
    }

    @Override
    public PersonTask finishPersonTaskById(Long id, PersonTask personTask) {
        PersonTask personTaskToFinish = dao.getPersonTaskById(id);
        if (personTaskToFinish != null) {
            personTaskToFinish.setFinishedAt(LocalDateTime.now());
            dao.savePersonTask(personTaskToFinish);
        }
        return personTaskToFinish;
    }

    @Override
    public PersonTask findPersonTaskById(Long id) {
        return dao.getPersonTaskById(id);
    }

    @Override
    public List<PersonTask> getAllPersonTasks() {
        return dao.getAllPersonTasks();
    }
}
