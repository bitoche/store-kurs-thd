package com.example.thdkurs.services;

import com.example.thdkurs.models.order;
import com.example.thdkurs.models.product;
import com.example.thdkurs.repository.OrderRep;
import com.example.thdkurs.repository.ProductRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServ {
    ProductRep repository;
    public ProductServ(ProductRep Repository){
        repository = Repository;
    }
    public List<product> findAll(){
        return (List<product>) repository.findAll();
    }
    public Optional<product> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(product object){
        repository.save(object);
    }
    public List<product> findByContainsInName(String name){
        var nFilteredList = repository.findAll();
        var filteredList = new ArrayList<product>();
        for (product pr : nFilteredList){
            if(pr.getName().contains(name)){
                filteredList.add(pr);
            }
        }
        return filteredList;
    }
    public boolean isProduct(int id){
        for(var prod : repository.findAll()){
            if(id == prod.getId()) return true;
        }
        return false;
    }
}
