package com.example.test_mongo.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.test_mongo.models.OrderInfo;
import com.example.test_mongo.models.OrderPrice;
import com.example.test_mongo.repositories.AllOrderInfo;
import com.example.test_mongo.repositories.AllOrderPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        orderPrice.setMonth(month);
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
    @PostMapping("/replace")
    public String replaceData(Order order,OrderInfo orderInfo,OrderPrice orderPrice){
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        orderPrice.setMonth(month);
        orderlist.save(order);
        orderPrice1.save(orderPrice);
        orderInfo1.save(orderInfo);
        return "redirect:/AllOrder";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") int id,Model model){
        ModelAndView editView = new ModelAndView("edit");
        Order orderob = orderlist.findOrderById(id);
        model.addAttribute("orderid",id);
        editView.addObject("orderobs",orderob);
        return editView;
    }

    @GetMapping("/info/{id}")
    public ModelAndView showInf(@PathVariable(name= "id")int id){
        ModelAndView editView = new ModelAndView("");
        OrderInfo orderinfo = orderInfo1.findOrderInfoById(id);
        editView.addObject("orderInfo",orderinfo);
        return editView;
    }

    @GetMapping("/Profit")
    public String getProfit(Model model){
        int allsum =0,monthly=0;
        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        System.out.println(month);

        List<OrderPrice> priceslist = orderPrice1.findAll();
        List<OrderPrice> pricesMonth = orderPrice1.findAllByMonth(month);
        for (OrderPrice orderPrice : priceslist) {
            allsum += orderPrice.getPrice();
        }
        for (OrderPrice orderPrice : pricesMonth){
            monthly += orderPrice.getPrice();
        }
        model.addAttribute("priceList",priceslist);
        model.addAttribute("priceMonth",pricesMonth);
        model.addAttribute("month",monthly);
        System.out.println(allsum);
        System.out.println("Month : "+monthly);
        System.out.println("all : "+allsum);
        model.addAttribute("valsum",allsum);

        return "info";
    }



}
