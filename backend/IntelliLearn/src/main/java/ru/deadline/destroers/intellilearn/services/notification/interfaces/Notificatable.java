package ru.deadline.destroers.intellilearn.services.notification.interfaces;

public interface Notificatable {
    void sendNotificationToGroup(String groupId, String message);

    void sendNotificationToStudent(String studentId, String message);
}
