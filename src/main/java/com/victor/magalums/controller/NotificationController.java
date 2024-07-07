package com.victor.magalums.controller;

import com.victor.magalums.domain.Notification;
import com.victor.magalums.dto.SheduleNotificationDTO;
import com.victor.magalums.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody SheduleNotificationDTO dto) {
        notificationService.sheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        var notification = notificationService.findById(id);

        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long id) {
        notificationService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }
}
