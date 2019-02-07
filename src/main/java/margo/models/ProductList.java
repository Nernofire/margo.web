package margo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product_List")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {
    @Id
    private Integer pl_id;
    @ManyToOne
    private Product pl_product;
    private Double pl_quantity;
    private Double pl_price_unit;
}
