package margo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transaction_id;

    private Date transaction_date;
    private String transaction_client;
    private Date transaction_accepted_date;
    private String transaction_recipient;
    private boolean transaction_is_deleted;
}
