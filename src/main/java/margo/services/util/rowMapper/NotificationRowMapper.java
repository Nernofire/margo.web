package margo.services.util.rowMapper;

import margo.models.Notification;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class NotificationRowMapper implements RowMapper<Notification> {
    @Override
    public Notification mapRow(ResultSet resultSet, int i) throws SQLException {
        Notification notification = new Notification();
        notification.setNotification_id(resultSet.getInt("notification_id"));
        notification.setNotification_date(resultSet.getDate("notification_date"));
        notification.setNotification_sender(resultSet.getInt("notification_sender"));
        notification.setNotification_message(resultSet.getString("notification_message"));
        notification.setNotification_is_deleted(resultSet.getBoolean("notification_is_deleted"));
        notification.setNotification_is_read(resultSet.getBoolean("notification_is_read"));
        return notification;
    }
}
