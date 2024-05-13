package ru.deadline.destroers.intellilearn.services.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.deadline.destroers.intellilearn.services.notification.interfaces.Notificatable;

@Service
public class NotificationService implements Notificatable {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendNotificationToGroup(String groupId, String message) {
        messagingTemplate.convertAndSend("/topic/group/" + groupId, message);
    }

    @Override
    public void sendNotificationToStudent(String studentId, String message) {
        messagingTemplate.convertAndSend("/topic/student/" + studentId, message);
    }
}

