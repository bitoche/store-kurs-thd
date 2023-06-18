package com.example.thdkurs.services;

import com.example.thdkurs.models.acceptance;
import com.example.thdkurs.models.buyer;
import com.example.thdkurs.repository.AcceptanceRep;
import com.example.thdkurs.repository.BuyerRep;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BuyerServ {
    BuyerRep repository;
    public BuyerServ(BuyerRep Repository){
        repository = Repository;
    }
    public List<buyer> findAll(){
        return (List<buyer>) repository.findAll();
    }
    public Optional<buyer> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(buyer object){
        repository.save(object);
    }
}
