package ru.deadline.destroers.intellilearn.services.study.interfaces;

import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.entities.User;

public interface Studable {
    void addTaskToStudent(User student, Task task);
    void updateTaskStatus(User student, Long taskId);
    double calculateProgress(User student);
}
