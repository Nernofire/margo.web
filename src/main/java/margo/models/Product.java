package margo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer product_id;
    @Column(nullable = false)
    private String product_name;
    @Column(length = 1024)
    private String product_comment;
    @Column(nullable = false)
    private boolean product_is_deleted;
    private Integer product_type;
    private Double product_count;
    private String product_measurement;
    private Double product_price_for_one;
    private Double product_price_total;
    private Integer product_updater_id;
    private Date product_last_updated;

}
