package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deadline.destroers.intellilearn.dto.TaskDto;
import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.repositories.TaskRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
//    private final TaskRepository taskRepository;
//    @GetMapping
//    public List<TaskDto> getAllTasks() {
////        return taskRepository.findAll()
////                .stream().map(task -> TaskDto.builder()
////                        .Id(task.getId())
////                        .nameTask(task.getName())
////                        .period(List.of(task.getStartDate(), task.getEndDate()))
////                        .questions(
////                                task ->
////                        )
////                        .build());
//    }
}
