package com.example.thdkurs.services;

import com.example.thdkurs.models.acceptance;
import com.example.thdkurs.repository.AcceptanceRep;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AcceptanceServ {
    AcceptanceRep repository;
    public AcceptanceServ(AcceptanceRep Repository){
        repository = Repository;
    }
    public List<acceptance> findAll(){
        return (List<acceptance>) repository.findAll();
    }
    public Optional<acceptance> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(acceptance object){
        repository.save(object);
    }
}
