package ru.deadline.destroers.intellilearn.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Result;
import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.ResultRepository;
import ru.deadline.destroers.intellilearn.repositories.TaskRepository;
import ru.deadline.destroers.intellilearn.repositories.UserRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void pinTaskToUser(Long userId, Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow();
        User user = userRepository.findById(userId)
                                    .orElseThrow();
        if (task.getStudentsList() == null) {
            task.setStudentsList(new ArrayList<>());
        }
        if (task.getStudentsList().stream()
                .noneMatch((student)-> student.getId().equals(user.getId()))) {
            task.getStudentsList().add(user);
        }
        taskRepository.save(task);
    }

    @Override
    public void unpinTaskFromUser(Long userId, Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow();

        if(task.getStudentsList() == null){
            return;
        }

        task.getStudentsList().removeIf((student) -> student.getId().equals(userId));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<Result> getResults(Long taskId) {
        return resultRepository.findAllByTaskId(taskId);
    }

    @Override
    public Task updateTask(Task task) {
        if (taskRepository.existsById(task.getId())) {
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task does not exist.");
        }
    }
}
