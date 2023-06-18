package com.example.thdkurs.repository;

import com.example.thdkurs.models.stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRep extends CrudRepository<stock, Integer> {
}
