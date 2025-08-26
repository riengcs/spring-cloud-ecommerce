package com.aa.notification_service.service;

import com.aa.notification_service.entity.Notification;
import com.aa.notification_service.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void sendNotification(String to, String message) {
        repository.save(new Notification(to, message));

        System.out.println("🔔 Notification sent: " + message);
    }

    public List<Notification> getAll() {
        return repository.findAll();
    }
}

