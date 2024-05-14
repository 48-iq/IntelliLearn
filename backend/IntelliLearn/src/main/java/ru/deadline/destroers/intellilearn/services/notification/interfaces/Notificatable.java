package ru.deadline.destroers.intellilearn.services.notification.interfaces;

public interface Notificatable {
    void sendNotificationToGroup(Long groupId, String message);

    void sendNotificationToStudent(Long studentId, String message);
}
