package margo.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Product")
public @Data
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;
    @Column(nullable = false)
    private String product_name;
    private String product_comment;
    @ManyToMany(mappedBy = "products")
    private Set<Transaction> transactions;
    private boolean product_is_deleted;
    private Integer product_type;
    private BigDecimal product_count;
    private String product_measurement;
    private BigDecimal product_price_for_one;
    private BigDecimal product_price_total;
    private Long product_updater_id;
    private Date product_last_updated;

}
