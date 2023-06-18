package com.example.thdkurs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class stock {
    @Id
    @Column(name="id")
    int id;
    @Column(name="address")
    String address;
    @Column(name="name")
    String name;
    @Column(name="id_product")
    int id_product;
    @Column(name="count")
    int count;
}
