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
    public void sendNotification(List<User> users, Notification message) {
        //messagingTemplate.convertAndSend("/topic/" + groupId, message);
    }
}

