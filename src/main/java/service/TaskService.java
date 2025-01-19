package service;

import model.Task;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);

    Task getTaskById(Long id);

    Task updateTaskById(Long id, Task task);

    List<Task> getAllTasks();

}
