package com.example.thdkurs.controllers;

import com.example.thdkurs.models.*;
import com.example.thdkurs.services.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class MainController {
    AcceptanceServ acceptanceServ;
    BuyerServ buyerServ;
    ProductServ productServ;
    Revaluation_actServ revaluationActServ;
    StockServ stockServ;
    OrderServ orderServ;
    ReturnsServ returnsServ;
    StoreServ storeServ;

    public MainController(StoreServ storeServ, ReturnsServ returnsServ, OrderServ orderServ, StockServ stockServ, AcceptanceServ acceptanceServ, BuyerServ buyerServ, ProductServ productServ, Revaluation_actServ revaluationActServ){
        this.acceptanceServ = acceptanceServ;
        this.buyerServ = buyerServ;
        this.productServ = productServ;
        this.revaluationActServ = revaluationActServ;
        this.stockServ = stockServ;
        this.orderServ = orderServ;
        this.returnsServ = returnsServ;
        this.storeServ = storeServ;
    }
    @GetMapping("/")
    public String mainPage() {
        return "main";
    }
    @GetMapping("/acceptance")
    public String acceptancePage(Model model) {
        model.addAttribute("listAcceptance", acceptanceServ.findAll());
        return "acceptance";
    }
    @GetMapping("/buyer")
    public String buyerPage(Model model) {
        model.addAttribute("listBuyer", buyerServ.findAll());
        return "buyer";
    }
    @GetMapping("/order")
    public String orderPage(Model model) {
        model.addAttribute("listOrder", orderServ.findAll());
        return "order";
    }
    @GetMapping("/product")
    public String productPage(Model model) {
        if(!model.containsAttribute("listProducts")){
            model.addAttribute("listProducts", productServ.findAll());
        }
        return "product";
    }
    @GetMapping("/returns")
    public String returnsPage(Model model) {
        model.addAttribute("listReturns", returnsServ.findAll());
        return "returns";
    }
    @GetMapping("/revaluation_act")
    public String revaluation_actPage(Model model) {
        model.addAttribute("listRev_act", revaluationActServ.findAll());
        return "revaluation_act";
    }
    @GetMapping("/stock")
    public String stockPage(Model model) {
        model.addAttribute("listStock", stockServ.findAll());
        return "stock";
    }
    @GetMapping("/store")
    public String storePage(Model model) {
        model.addAttribute("listStore", storeServ.findAll());
        return "store";
    }
    @PostMapping("/product/add")
    public String addProduct(String name, String unit, String price,@Nullable String description){
        var pr = new product();
        pr.setName(name);
        pr.setUnit(unit);
        pr.setPrice(Integer.parseInt(price));
        if(description!=null){
            pr.setDescription(description);
        }
        productServ.save(pr);
        return "redirect:/product";
    }
    @GetMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        for(var revact : revaluationActServ.findAll()){
            if (revact.getId_product() == id){
                System.out.println("Удален REV_ACT, id="+ revact.getId());
                revaluationActServ.deleteById(revact.getId());
            }
        }
        productServ.deleteById(id);
        return "redirect:/product";
    }
    @PostMapping("product/edit/")
    public String editProduct(String id, String name, String unit, String price,@Nullable String description){
        var pr = new product();
        pr.setId(Integer.parseInt(id));
        pr.setName(name);
        pr.setUnit(unit);
        pr.setPrice(Integer.parseInt(price));
        for(var prod : productServ.findAll()){
            if((prod.getId()==Integer.parseInt(id))){
                if(prod.getPrevious_price()!=null){
                    pr.setPrevious_price(prod.getPrevious_price());
                }
                if(!(prod.getPrice().equals(pr.getPrice()))){
                    var rev_act = new revaluation_act();
                    rev_act.setDate(new Date());
                    rev_act.setId_product(Integer.parseInt(id));
                    rev_act.setSumm(Integer.parseInt(price));
                    rev_act.setResponsible("noname Responsible");
                    revaluationActServ.save(rev_act);
                    pr.setPrevious_price(prod.getPrice());
                    pr.setPrice(Integer.parseInt(price));
                }
            }
        }
        if(description!=null){
            pr.setDescription(description);
        }
        productServ.save(pr);
        return "redirect:/product";
    }
    @GetMapping("product/filterByName")
    public String filterFirstProduct(String value, Model model){
        model.addAttribute("listProducts", productServ.findByContainsInName(value));
        return "product";
    }
    @PostMapping("product/filterByDateOfRevaluation")
    public String filterSecondProduct(String dateFrom, String dateFor, Model model) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        var filteredList = new ArrayList<product>();
        for(var pr : productServ.findAll()){
            for(var act : revaluationActServ.findAll()){
                if(act.getId_product() == pr.getId()
                        &&
                        (act.getDate().after(format.parse(dateFrom)) || format.format(act.getDate()).equals(dateFrom))
                        &&
                        (act.getDate().before(format.parse(dateFor)) || format.format(act.getDate()).equals(dateFor))
                ){
                    filteredList.add(pr);
                }
            }
        }
        model.addAttribute("listProducts", filteredList);
        return "product";
    }
    @PostMapping("product/filterByReturns")
    public String filterThirdProduct(String dateFrom, String dateFor, Model model) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        var filteredList = new ArrayList<product>();
        for(var pr : productServ.findAll()){
            for(var ret : returnsServ.findAll()){
                if(ret.getId_product() == pr.getId()
                        &&
                        (ret.getDate().after(format.parse(dateFrom)) || format.format(ret.getDate()).equals(dateFrom))
                        &&
                        (ret.getDate().before(format.parse(dateFor)) || format.format(ret.getDate()).equals(dateFor))
                ){
                    filteredList.add(pr);
                }
            }
        }
        model.addAttribute("listProducts", filteredList);
        return "product";
    }
    @GetMapping("revact/delete/{id}")
    public String deleteRevAct(@PathVariable int id){
        revaluationActServ.deleteById(id);
        return "redirect:/revaluation_act";
    }
    @GetMapping("stock/delete/{id}")
    public String deleteStock(@PathVariable int id){
        stockServ.deleteById(id);
        return "redirect:/stock";
    }
    @GetMapping("stock/filterByProduct")
    public String filterStockByProduct(Model model, String value){
        model.addAttribute("listStock", stockServ.filterByProduct(value));
        return "stock";
    }
    @GetMapping("returns/delete/{id}")
    public String deleteReturn(@PathVariable int id){
        returnsServ.deleteById(id);
        return "redirect:/returns";
    }
    @PostMapping("returns/add")
    public String addReturn(String id_product, String cause){
        var returns = new returns();
        returns.setDate(new Date());
        returns.setCause(cause);
        if(!productServ.isProduct(Integer.parseInt(id_product))){
            return "redirect:/returns";
        }
        returns.setId_product(Integer.parseInt(id_product));
        returnsServ.save(returns);
        return "redirect:/returns";
    }
}
