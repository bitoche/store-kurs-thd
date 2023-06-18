package com.example.thdkurs.services;

import com.example.thdkurs.models.product;
import com.example.thdkurs.models.revaluation_act;
import com.example.thdkurs.repository.ProductRep;
import com.example.thdkurs.repository.Revaluation_actRep;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class Revaluation_actServ {
    Revaluation_actRep repository;
    public Revaluation_actServ(Revaluation_actRep Repository){
        repository = Repository;
    }
    public List<revaluation_act> findAll(){
        return (List<revaluation_act>) repository.findAll();
    }
    public Optional<revaluation_act> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(revaluation_act object){
        repository.save(object);
    }
}
