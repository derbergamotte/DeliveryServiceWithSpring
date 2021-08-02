package com.ak.entities;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "store")
public class Store extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private Collection<Storage> storages;
}
