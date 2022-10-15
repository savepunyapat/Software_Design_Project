package com.example.test_mongo;

import com.example.test_mongo.repositories.AllOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TestMongoApplication implements CommandLineRunner {
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
