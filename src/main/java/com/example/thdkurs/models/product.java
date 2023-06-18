package com.example.thdkurs.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class product {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name")
    String name;
    @Column(name="Unit")
    String unit;
    @Column(name="Price")
    Integer price;
    @Column(name="Description")
    String description;
    @Column(name="Previous_price")
    Integer previous_price;
}
