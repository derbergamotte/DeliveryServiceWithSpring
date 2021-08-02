package com.ak.entities;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Product> products;
}
