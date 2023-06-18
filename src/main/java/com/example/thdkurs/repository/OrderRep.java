package com.example.thdkurs.repository;

import com.example.thdkurs.models.order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRep extends CrudRepository<order, Integer> {
}
