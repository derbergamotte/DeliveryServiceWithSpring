package com.ak.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
