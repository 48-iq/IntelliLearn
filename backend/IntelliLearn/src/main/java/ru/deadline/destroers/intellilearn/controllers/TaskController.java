package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deadline.destroers.intellilearn.dto.TaskDto;
import ru.deadline.destroers.intellilearn.entities.Result;
import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.services.interfaces.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {

        Task createdTask = taskService.createTask(modelMapper.map(taskDto, Task.class));
        return ResponseEntity.ok(modelMapper.map(createdTask, TaskDto.class));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        Task updatedTask = taskService.updateTask(modelMapper.map(taskDto, Task.class));
        return ResponseEntity.ok(modelMapper.map(updatedTask, TaskDto.class));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{taskId}/users/{userId}")
    public ResponseEntity<Void> pinTaskToUser(@PathVariable Long taskId, @PathVariable Long userId) {
        taskService.pinTaskToUser(userId, taskId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{taskId}/users/{userId}")
    public ResponseEntity<Void> unpinTaskFromUser(@PathVariable Long taskId, @PathVariable Long userId) {
        taskService.unpinTaskFromUser(userId, taskId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{taskId}/results")
    public ResponseEntity<List<Result>> getResults(@PathVariable Long taskId) {
        List<Result> results = taskService.getResults(taskId);
        return ResponseEntity.ok(results);
    }
}
