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
@Table(name = "store")
public class store {
    @Id
    @Column(name="id")
    int id;
    @Column(name="address")
    String address;
    @Column(name="contact_details")
    String contact_details;
}
