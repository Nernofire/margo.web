package margo.services.dao;

import margo.models.Notification;

import java.util.List;

public interface NotificationDAO {
    List<Notification> getAll();

    Notification saveNewNotification(Notification notification);
}
