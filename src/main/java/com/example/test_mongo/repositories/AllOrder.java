package com.example.test_mongo.repositories;

import com.example.test_mongo.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface AllOrder extends MongoRepository<Order,String> {

    @Query("{'id': ?0}")
    List<Order> findOrderById(int id);


    void deleteAllById(int id);

}
