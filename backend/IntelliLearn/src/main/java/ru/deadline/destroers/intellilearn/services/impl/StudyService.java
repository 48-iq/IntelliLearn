package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Task;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.repositories.TaskRepository;
import ru.deadline.destroers.intellilearn.services.interfaces.Studable;

@Service
@RequiredArgsConstructor
public class StudyService implements Studable {
    private final TaskRepository taskRepository;

    public void addTaskToStudent(User student, Task task) {
        if (student!= null) {
            student.getTaskList().add(task);
        }
    }

    public void updateTaskStatus(User student, Long taskId) {
        if (student!= null) {
            for (Task task : student.getTaskList()) {
                if (task.getId().equals(taskId)) {
                    task.setReady(true);
                    break;
                }
            }
        }
    }

    public double calculateProgress(User student) {
        if (student == null) return 0;

        int completedTasks = 0;
        for (Task task : student.getTaskList()) {
            if (task.getReady()) {
                completedTasks++;
            }
        }

        return (double) completedTasks / student.getTaskList().size() * 100;
    }
}
