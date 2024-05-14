package ru.deadline.destroers.intellilearn.controllers.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.deadline.destroers.intellilearn.services.notification.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

//    @PostMapping("/group/{groupId}")
//    public ResponseEntity<?> notifyGroup(@PathVariable Long groupId, @RequestBody String message) {
//        notificationService.sendNotification(groupId, message);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/student/{studentId}")
//    public ResponseEntity<?> notifyStudent(@PathVariable String studentId, @RequestBody String message) {
//        notificationService.sendNotificationToStudent(studentId, message);
//        return ResponseEntity.ok().build();
//    }
}
