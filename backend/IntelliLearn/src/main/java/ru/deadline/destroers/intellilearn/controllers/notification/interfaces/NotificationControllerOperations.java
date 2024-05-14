package ru.deadline.destroers.intellilearn.controllers.notification.interfaces;

public interface NotificationControllerOperations {
    void notifyGroup(Long groupId, String message);
    void notifyStudent(Long studentId, String message);
}
