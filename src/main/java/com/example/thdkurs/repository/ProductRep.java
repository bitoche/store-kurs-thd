package com.example.thdkurs.repository;

import com.example.thdkurs.models.product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep extends CrudRepository<product, Integer> {
}
