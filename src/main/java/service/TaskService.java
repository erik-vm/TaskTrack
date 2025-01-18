package service;

import model.Task;

import java.util.List;

public interface TaskService {

    public Task saveTask(Task task);

    public Task getTaskById(Long id);

    public Task updateTaskById(Long id, Task task);

    public List<Task> getAllTasks();

}
