package com.example.test_mongo.repositories;

import com.example.test_mongo.models.OrderInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AllOrderInfo extends MongoRepository<OrderInfo,String> {
    void deleteAllById(int id);
}
