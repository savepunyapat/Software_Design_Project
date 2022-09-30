package com.example.test_mongo.controllers;

import java.util.List;

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

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/Order")
    public String Order(){
        return "Order";
    }

    @PostMapping("/Order")
    public String ShowOrder(Order order){
        System.out.println("KUY");
        System.out.println(order.getItemName()+order.getArtistName());
        orderlist.save(order);
        return "Order";
    }
    @GetMapping("/AllOrder")
    public String getOrder(Model model){
        List<Order> listorder = orderlist.findAll();
        model.addAttribute("listorders",listorder);
        System.out.println("show data");
        return "AllOrder";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id){
        orderlist.deleteAllById(id);
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
