package com.example.thdkurs.services;

import com.example.thdkurs.models.buyer;
import com.example.thdkurs.models.order;
import com.example.thdkurs.repository.BuyerRep;
import com.example.thdkurs.repository.OrderRep;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderServ {
    OrderRep repository;
    public OrderServ(OrderRep Repository){
        repository = Repository;
    }
    public List<order> findAll(){
        return (List<order>) repository.findAll();
    }
    public Optional<order> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(order object){
        repository.save(object);
    }
}
