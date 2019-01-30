package margo.services;

import margo.models.Notification;
import margo.models.Person;
import margo.repository.PersonRepo;
import margo.services.dao.NotificationDAO;
import margo.services.util.NotificationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class NotificationDAOImpl implements NotificationDAO {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private NotificationRowMapper notificationRowMapper;

    @Autowired
    private PersonRepo personRepo;

    @Override
    public List<Notification> getAll() {
        return template.query("SELECT * FROM public.notification", notificationRowMapper);
    }

    @Override
    public Notification saveNewNotification(Notification notification) {
        String insertSQL = "INSERT INTO public.notification(notification_sender, notification_date, " +
                "notification_message, notification_is_deleted, notification_is_read) " +
                "values(:notification_sender, :notification_date, :notification_message, :notification_is_deleted, :notification_is_read);";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personRepo.findByLogin(userDetails.getUsername());

        parameterSource.addValue("notification_sender", person.getId());
        parameterSource.addValue("notification_date", new Date());
        parameterSource.addValue("notification_message", notification.getNotification_message());
        parameterSource.addValue("notification_is_deleted", false);
        parameterSource.addValue("notification_is_read", false);

        int id = template.update(insertSQL, parameterSource);
        notification.setNotification_id(id);
        return notification;
    }
}
