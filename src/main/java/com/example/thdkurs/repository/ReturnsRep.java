package com.example.thdkurs.repository;

import com.example.thdkurs.models.returns;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface ReturnsRep extends CrudRepository<returns, Integer> {
}
