package com.example.thdkurs.services;

import com.example.thdkurs.models.product;
import com.example.thdkurs.models.returns;
import com.example.thdkurs.repository.ProductRep;
import com.example.thdkurs.repository.ReturnsRep;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ReturnsServ {
    ReturnsRep repository;
    public ReturnsServ(ReturnsRep Repository){
        repository = Repository;
    }
    public List<returns> findAll(){
        return (List<returns>) repository.findAll();
    }
    public Optional<returns> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(returns object){
        repository.save(object);
    }
}
