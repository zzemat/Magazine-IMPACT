package magazin.server.service.serviceImpl;

import magazin.server.entity.Notification;
import magazin.server.repository.NotificationRepository;
import magazin.server.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    @Override
    public Notification update(Long id, Notification notification) {
        Notification existingNotification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
        //use mappers here!!!!!!!! author: idir.
        existingNotification.setProfileId(notification.getProfileId());
        existingNotification.setType(notification.getType());
        existingNotification.setReferenceId(notification.getReferenceId());
        existingNotification.setIsRead(notification.getIsRead());
        existingNotification.setCreatedAt(notification.getCreatedAt());

        return notificationRepository.save(existingNotification);
    }

    

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public boolean deleteById(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Notification> findByProfileId(Long profileId) {
        return notificationRepository.findByProfileId(profileId);
    }

    @Override
    public void markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);
        notificationRepository.save(notification);
    }
}