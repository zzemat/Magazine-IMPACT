package magazin.server.service;

import magazin.server.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    List<Notification> findAll();
    Optional<Notification> findById(Long id);
    Notification save(Notification notification);
    boolean deleteById(Long id);
    List<Notification> findByProfileId(Long profileId);
    void markAsRead(Long id);
    Notification update(Long id, Notification notification);
    
}