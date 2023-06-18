package com.example.thdkurs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "acceptance")
public class acceptance {
    @Id
    @Column(name="id")
    int id;
    @Column(name="id_store")
    int id_store;
    @Column(name="id_stock")
    int id_stock;
    @Column(name="wholesale_price")
    int wholesale_price;
    @Column(name="date")
    Date date;
    public String getStringDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
}
