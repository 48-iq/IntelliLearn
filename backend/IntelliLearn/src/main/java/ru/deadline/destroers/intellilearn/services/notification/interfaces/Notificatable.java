package ru.deadline.destroers.intellilearn.services.notification.interfaces;

import ru.deadline.destroers.intellilearn.entities.Notification;
import ru.deadline.destroers.intellilearn.entities.User;

import java.util.List;

public interface Notificatable {
    void sendNotification(List<User> users, Notification message);

}
