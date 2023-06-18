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
@Table(name = "buyer")
public class buyer {
    @Id
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="telephone_number")
    String telephone_number;
}
