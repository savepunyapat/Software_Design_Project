package com.example.test_mongo.controllers;

import java.util.List;

import com.example.test_mongo.models.OrderInfo;
import com.example.test_mongo.models.OrderPrice;
import com.example.test_mongo.repositories.AllOrderInfo;
import com.example.test_mongo.repositories.AllOrderPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.test_mongo.models.Order;
import com.example.test_mongo.repositories.AllOrder;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    private AllOrder orderlist;
    @Autowired
    private AllOrderPrice orderPrice1;
    @Autowired
    private AllOrderInfo orderInfo1;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/Order")
    public String Order(){
        return "Order";
    }

    @PostMapping("/Order")
    public String ShowOrder(Order order, OrderInfo orderInfo, OrderPrice orderPrice){
        System.out.println("Getting Order...");
        System.out.println(order.getItemName()+order.getArtistName());
        orderInfo1.save(orderInfo);
        orderPrice1.save(orderPrice);
        orderlist.save(order);
        return "Order";
    }
    @GetMapping("/AllOrder")
    public String getOrder(Model model){
        List<Order> listorder = orderlist.findAll();
        List<OrderInfo> listInfo = orderInfo1.findAll();
        List<OrderPrice> listPrice = orderPrice1.findAll();
        model.addAttribute("listInfo" ,listInfo);
        model.addAttribute("listPrice",listPrice);
        model.addAttribute("listorders",listorder);
        System.out.println("show data");
        return "AllOrder";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id){
        orderlist.deleteAllById(id);
        orderInfo1.deleteAllById(id);
        orderPrice1.deleteAllById(id);
        return "redirect:/AllOrder";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") int id){
        ModelAndView editView = new ModelAndView("edit");
        List<Order> orderob = orderlist.findOrderById(id);
        editView.addObject("orderob",orderob);
        return editView;
    }


}
