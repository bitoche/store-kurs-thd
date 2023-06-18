package com.example.thdkurs.services;

import com.example.thdkurs.models.product;
import com.example.thdkurs.models.store;
import com.example.thdkurs.repository.ProductRep;
import com.example.thdkurs.repository.StoreRep;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StoreServ {
    StoreRep repository;
    public StoreServ(StoreRep Repository){
        repository = Repository;
    }
    public List<store> findAll(){
        return (List<store>) repository.findAll();
    }
    public Optional<store> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(store object){
        repository.save(object);
    }
}
