package ru.deadline.destroers.intellilearn.controllers.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deadline.destroers.intellilearn.controllers.notification.interfaces.NotificationControllerOperations;
import ru.deadline.destroers.intellilearn.services.notification.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController implements NotificationControllerOperations {

    @Autowired
    private NotificationService notificationService;

    @Override
    public void notifyGroup(Long groupId, String message) {
        notificationService.sendNotificationToGroup(groupId, message);
    }

    @Override
    public void notifyStudent(Long studentId, String message) {
        notificationService.sendNotificationToStudent(studentId, message);
    }
}
