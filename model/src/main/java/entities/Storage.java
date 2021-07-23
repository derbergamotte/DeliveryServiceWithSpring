package entities;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Storage extends BaseEntity {

    private Store store;
    private Product product;
    private Integer quantity;
    private Integer price;
    private Collection<Order> orders;
}
