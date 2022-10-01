package com.example.test_mongo.repositories;

import com.example.test_mongo.models.OrderInfo;
import com.example.test_mongo.models.OrderPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AllOrderPrice extends MongoRepository<OrderPrice,String> {
    void deleteAllById(int id);
}