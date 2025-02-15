package magazin.server.service;

import magazin.server.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification createNotification(Notification notification);
    Notification getNotificationById(Long id);
    List<Notification> getAllNotifications();
    Notification updateNotification(Long id, Notification notification);
    void deleteNotification(Long id);
}