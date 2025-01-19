package controller;

import jakarta.validation.Valid;
import model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.TaskService;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Validated
@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(OK)
    public Task saveTask(@Validated @RequestBody Task task) {
        return service.saveTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable(name = "id") Long id, @RequestBody @Valid Task task) {
        Task taskToUpdate = service.updateTaskById(id, task);
        if (taskToUpdate == null) {
            return new ResponseEntity<>("Task update failed! Check id!", BAD_REQUEST);
        }
        return new ResponseEntity<>(taskToUpdate, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable(name = "id") Long id) {
        Task taskToFind = service.getTaskById(id);
        if (taskToFind == null) {
            return new ResponseEntity<>("Task not found! Check id!", BAD_REQUEST);
        }
        return new ResponseEntity<>(taskToFind, OK);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

}
