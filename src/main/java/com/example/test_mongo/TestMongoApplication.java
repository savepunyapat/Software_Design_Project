package com.example.test_mongo;

import com.example.test_mongo.models.Artist;
import com.example.test_mongo.models.Order;
import com.example.test_mongo.repositories.AllArtist;
import com.example.test_mongo.repositories.AllOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TestMongoApplication implements CommandLineRunner {
    AllArtist artist1;
    AllOrder order1;



    public static void main(String[] args) {
        SpringApplication.run(TestMongoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------------------------------------");
        System.out.println("Ready to use!");
        //createArtist();
    }
}
