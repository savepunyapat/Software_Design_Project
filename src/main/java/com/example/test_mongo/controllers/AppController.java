package com.example.test_mongo.controllers;

import com.example.test_mongo.repositories.AllOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.test_mongo.models.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private AllOrder orderlist;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/Order")
    public String Order(){
        return "Order";
    }

    @PostMapping("/Order")
    public String ShowOrder(@ModelAttribute("Order1") Order order){
        System.out.println("KUY");
        //orderlist.save(new Order(81,"Malubinight","Cassette","LANY",690,"XANNy"));
        return "Order";
    }

    @GetMapping("/AllOrder")
    public List<Order> getOrder(){

        return orderlist.findAll();
    }


}
