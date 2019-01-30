package margo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer notification_id;
    @Column(nullable = false)
    private Integer notification_sender;
    @Column(nullable = false)
    private String notification_message;
    private Date notification_date;
    private boolean notification_is_read;
    private boolean notification_is_deleted;

    public Notification(String notification_message, Date notification_date) {
        this.notification_message = notification_message;
        this.notification_date = notification_date;
    }
}
