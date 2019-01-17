package margo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;

    private String product_name;
    private String product_comment;
    private boolean product_is_deleted;
    private Integer product_type;
    private BigDecimal product_count;
    private String product_measurement;
    private BigDecimal product_price_for_one;
    private BigDecimal product_price_total;
    private Long product_updater_id;
    private Date product_last_updated;
}
