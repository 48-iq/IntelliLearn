package ru.deadline.destroers.intellilearn.controllers.notification.interfaces;

public interface NotificationControllerOperations {
    void notifyGroup(String groupId, String message);
    void notifyStudent(String studentId, String message);
}
