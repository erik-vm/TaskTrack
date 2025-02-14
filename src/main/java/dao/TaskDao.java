package dao;

import model.Task;

import java.util.List;

public interface TaskDao {

    public Task saveTask(Task task);

    public Task getTaskById(Long id);

    public List<Task> getAllTasks();
}
