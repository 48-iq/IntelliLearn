package ru.deadline.destroers.intellilearn.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Notification;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.services.interfaces.NotificationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendNotification(Notification notification, List<User> users) {

    }

    @Override
    public Notification getNotification(Long notificationId) {
        return null;
    }

    @Override
    public Notification createNotification(Notification notification) {
        return null;
    }

    @Override
    public Notification updateNotification(Notification notification) {
        return null;
    }

    @Override
    public void deleteNotification(Long notificationId) {

    }

    @Override
    public List<Notification> getNotificationByUser(Long userId) {
        return null;
    }
}

