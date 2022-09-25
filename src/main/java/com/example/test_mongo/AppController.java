package com.example.test_mongo;

import com.example.test_mongo.repositories.AllOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.test_mongo.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {
    @Autowired
    private AllOrder orderlist;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/Order",method = RequestMethod.GET)
    public String OrderPlace(){

        return "Order";
    }

}
