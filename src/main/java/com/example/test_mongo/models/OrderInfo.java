package com.example.test_mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("OrderInfo")
public class OrderInfo  {
    public OrderInfo(int id, int amount, String info) {
        this.id = id;
        this.amount = amount;
        this.info = info;
    }

    public OrderInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Id
    private int id;
    private int amount;
    private String info;

}
