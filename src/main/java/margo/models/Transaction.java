package margo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Transaction")
public @Data
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transaction_id;
    private Date transaction_date;
    private String transaction_orderer;
    private Date transaction_accepted_date;
    private String transaction_acceptor;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "transaction_product",
            joinColumns = {@JoinColumn(name = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "orderId")})
    private Set<Product> products;
    private boolean transaction_is_deleted;
}
