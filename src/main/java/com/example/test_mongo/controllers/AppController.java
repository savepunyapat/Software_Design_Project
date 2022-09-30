package com.example.test_mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test_mongo.models.Order;
import com.example.test_mongo.repositories.AllOrder;

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
    public String ShowOrder(){
        System.out.println("KUY");
        //orderlist.save(new Order(71,"Malubinight","Cassette","LANY",690,"XANNy"));
        return "Order";
    }

    @GetMapping("/AllOrder")
    public List<Order> getOrder(Model model){
        List<Order> listorder = orderlist.findAll();
        System.out.println(listorder.get(1).getId());
        System.out.println(listorder.get(1).getItemName());
        model.addAllAttributes(listorder);
        System.out.println("show data");

        return listorder;
    }


}
