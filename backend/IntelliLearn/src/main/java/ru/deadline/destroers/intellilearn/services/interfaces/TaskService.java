package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Result;
import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.entities.User;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    void pinTaskToUser(Long userId, Long taskId);

    void unpinTaskFromUser(Long userId, Long taskId);

    void deleteTask(Long taskId);

    List<Result> getResults(Long taskId);

    Task updateTask(Task task);
}
