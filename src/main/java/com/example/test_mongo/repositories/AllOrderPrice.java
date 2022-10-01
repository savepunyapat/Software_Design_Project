package com.example.test_mongo.repositories;


import com.example.test_mongo.models.Order;
import com.example.test_mongo.models.OrderPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AllOrderPrice extends MongoRepository<OrderPrice,String> {

    @Query("{'month': ?0}")
    List<OrderPrice> findAllByMonth(int month);
    @Query("{month: '?0'}")
    List<OrderPrice> findById(int month);
    @Query()

    void deleteAllById(int id);


}