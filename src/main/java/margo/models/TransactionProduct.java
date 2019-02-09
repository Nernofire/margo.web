package margo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class TransactionProduct {

    @EmbeddedId
    @JsonIgnore
    private TransactionProductPK tp_pk;

    @Column(nullable = false)
    private Double quantity;

    public TransactionProduct() {
        super();
    }

    public TransactionProduct(Transaction transaction, Product product, Double quantity) {
        tp_pk = new TransactionProductPK();
        tp_pk.setPk_transaction(transaction);
        tp_pk.setPk_product(product);
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct() {
        return this.tp_pk.getPk_product();
    }

    @Transient
    public Double getTotalPrice() {
        return new Double(new BigDecimal(getProduct().getProduct_price_for_one())
                .multiply(new BigDecimal(getQuantity())).toString());
    }
}

@Data
@Getter
@Setter
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pk_transaction")
class TransactionProductPK implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "transaction_id")
    private Transaction pk_transaction;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product pk_product;
}