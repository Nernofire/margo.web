package margo.repository;

import margo.models.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepo extends CrudRepository<Notification, Long> {

}
