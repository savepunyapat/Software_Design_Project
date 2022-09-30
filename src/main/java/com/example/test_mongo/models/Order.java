package com.example.test_mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("OrderList")
public class Order {
    @Id
    private int id;
    private String itemName;
    private String type;
    private String artistName;
    private double price;
    private String info;

    private int amount;



    public Order(int id, String itemName, String type, String artistName, double price, String info) {
        super();
        this.id = id;
        this.itemName = itemName;
        this.type = type;
        this.artistName = artistName;
        this.price = price;
        this.info = info;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
