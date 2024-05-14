package ru.deadline.destroers.intellilearn.services.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.entities.Notification;
import ru.deadline.destroers.intellilearn.entities.User;
import ru.deadline.destroers.intellilearn.services.notification.interfaces.Notificatable;

import java.util.List;

@Service
public class NotificationService implements Notificatable {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendNotification(List<User> users, Notification message) {
        //messagingTemplate.convertAndSend("/topic/" + groupId, message);
    }
}

