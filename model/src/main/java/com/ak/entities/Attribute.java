package com.ak.entities;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "attribute")
public class Attribute extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "attributes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Product> products;
}
