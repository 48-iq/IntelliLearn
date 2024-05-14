package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Task;

public interface TaskService {
    Task createTask(Task task);

    void pinTaskToUser(String userId, String taskId);

    void unpinTaskFromUser();

    void deleteTask(String taskId);

    Results getResults(String taskId, String userId);

    Task updateTask(Task task);
}
