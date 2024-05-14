package ru.deadline.destroers.intellilearn.services.interfaces;

import ru.deadline.destroers.intellilearn.entities.Notification;
import ru.deadline.destroers.intellilearn.entities.User;

import java.util.List;

public interface NotificationService {
    void sendNotification(List<User> users, Notification message);

}
