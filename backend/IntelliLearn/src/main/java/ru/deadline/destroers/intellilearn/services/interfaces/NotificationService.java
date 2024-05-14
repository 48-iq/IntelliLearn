package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Notification;
import ru.deadline.destroers.intellilearn.entities.User;

import java.util.List;

public interface NotificationService {

    void sendNotification(Notification notification, List<User> users);

    Notification getNotification(Long notificationId);

    Notification createNotification(Notification notification);

    Notification updateNotification(Notification notification);

    void deleteNotification(Long notificationId);

    List<Notification> getNotificationByUser(Long userId);
}
