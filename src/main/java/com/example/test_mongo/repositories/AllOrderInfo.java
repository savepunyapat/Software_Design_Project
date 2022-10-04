package com.example.test_mongo.repositories;

import com.example.test_mongo.models.Order;
import com.example.test_mongo.models.OrderInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AllOrderInfo extends MongoRepository<OrderInfo,String> {
    @Query("{'id': ?0}")
    OrderInfo findOrderInfoById(int id);
    void deleteAllById(int id);
}
