package margo.controllers.api;

import margo.models.Notification;
import margo.services.NotificationDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    NotificationDAOImpl notificationDAO;

    @GetMapping("/getAll")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return new ResponseEntity<>(notificationDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping("/postNotification")
    public ResponseEntity<List<Notification>> postNotification(@Valid @RequestBody Notification notification) {
        notificationDAO.saveNewNotification(notification);
        return new ResponseEntity(notificationDAO.getAll(), HttpStatus.OK);
    }
}
