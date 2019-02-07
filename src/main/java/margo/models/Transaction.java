package margo.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", nullable = false, name = "transaction_id")
    private Integer transaction_id;
    private Date transaction_date;
    @ManyToOne
    @JoinColumn(name = "orderer_id")
    private Person transaction_orderer;
    private Date transaction_accepted_date;
    @ManyToOne
    @JoinColumn(name = "acceptor_id")
    private Person transaction_acceptor;
    @OneToMany
    private Set<ProductList> transaction_pl;
    @Column(nullable = false)
    private boolean transaction_is_deleted;

}
