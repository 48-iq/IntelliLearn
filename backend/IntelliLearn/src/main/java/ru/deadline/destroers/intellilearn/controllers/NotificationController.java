package ru.deadline.destroers.intellilearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deadline.destroers.intellilearn.controllers.notification.interfaces.NotificationControllerOperations;
import ru.deadline.destroers.intellilearn.services.notification.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    public void notifyGroup(String groupId, String message) { // @...Mapping("/...r") public RequestEntity<?> notifyGroup(@ResponseBody SomeDto)
        notificationService.sendNotificationToGroup(groupId, message);
    }


    public void notifyStudent(String studentId, String message) {
        notificationService.sendNotificationToStudent(studentId, message);
    }
}
