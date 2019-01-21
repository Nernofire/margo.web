package margo.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Integer transaction_id;
    private Date transaction_date;
    @Column(nullable = false)
    private String transaction_orderer;
    private Date transaction_accepted_date;
    private String transaction_acceptor;
    @Column(length = 2048)
    private String transaction_product_list;
    @Column(nullable = false)
    private boolean transaction_is_deleted;

}
