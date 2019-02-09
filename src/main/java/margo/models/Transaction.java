package margo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "transaction_product")
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

    @OneToMany(mappedBy = "tp_pk.pk_transaction")
    @Valid
    private List<TransactionProduct> transaction_product = new ArrayList<>();

    @Column(nullable = false)
    private boolean transaction_is_deleted;

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<TransactionProduct> orderProducts = getTransaction_product();
        for (TransactionProduct op : orderProducts) {
            sum += op.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.transaction_product.size();
    }
}
