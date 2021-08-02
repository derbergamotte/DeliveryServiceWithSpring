package com.ak.entities;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "storage")
public class Storage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;
    @OneToMany(mappedBy = "storage", fetch = FetchType.LAZY)
    private Collection<Order> orders;
}
