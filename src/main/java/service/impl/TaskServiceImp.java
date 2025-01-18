package service.impl;

import dao.TaskDao;
import model.Task;
import org.springframework.stereotype.Service;
import service.TaskService;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskDao dao;

    public TaskServiceImp(TaskDao dao) {
        this.dao = dao;
    }

    @Override
    public Task saveTask(Task task) {
        return dao.saveTask(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return dao.getTaskById(id);
    }

    @Override
    public Task updateTaskById(Long id, Task task) {
        Task taskToUpdate = dao.getTaskById(id);
        if (taskToUpdate != null) {
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setStatus(task.getStatus());
            return dao.saveTask(taskToUpdate);
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return dao.getAllTasks();
    }
}
