package com.ak.entities;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Collection<Category> categories;
    @ManyToMany
    @JoinTable(name = "product_attribute",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id", referencedColumnName = "id"))
    private Collection<Attribute> attributes;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<Storage> storages;
    @Column(name = "information")
    private String information;
}
