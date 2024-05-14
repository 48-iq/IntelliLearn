package ru.deadline.destroers.intellilearn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deadline.destroers.intellilearn.services.impl.NotificationServiceImpl;
import ru.deadline.destroers.intellilearn.services.interfaces.NotificationService;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

//    private final NotificationService notificationService;
//    private final GroupService groupService;
//
//    @PostMapping()
//    public void notifyGroup(Long groupId, String message) { // @...Mapping("/...r") public RequestEntity<?> notifyGroup(@ResponseBody SomeDto)
//        notificationService.sendNotification(, message);
//    }
//
//    @PostMapping
//    public void notifyStudent(Long studentId, String message) {
//        notificationService.sendNotificationToStudent(studentId, message);
//    }
}
