package com.example.thdkurs.services;

import com.example.thdkurs.models.product;
import com.example.thdkurs.models.stock;
import com.example.thdkurs.repository.ProductRep;
import com.example.thdkurs.repository.StockRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StockServ {
    StockRep repository;
    ProductServ productServ;
    public StockServ(StockRep Repository, ProductServ productServ){
        repository = Repository;
        this.productServ =productServ;
    }
    public List<stock> findAll(){
        return (List<stock>) repository.findAll();
    }
    public Optional<stock> findById(int id){
        return repository.findById(id);
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
    public void save(stock object){
        repository.save(object);
    }
    public List<stock> filterByProduct(String name){
        List<stock> foundStocks = new ArrayList<>();
        for(var stock : repository.findAll()){
            for(var foundProduct : productServ.findByContainsInName(name)){
                if(stock.getId_product() == foundProduct.getId()){
                    foundStocks.add(stock);
                    break;
                }
            }
        }
        return foundStocks;
    }
}
