package com.example.test_mongo;

import com.example.test_mongo.models.Artist;
import com.example.test_mongo.repositories.AllArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TestMongoApplication implements CommandLineRunner {
    AllArtist artist1;
    @Autowired
    public TestMongoApplication(AllArtist artist1){
        this.artist1 = artist1;
    }

    void createArtist(){
        System.out.println("Data creation started...");
        artist1.save(new Artist("1","Gonn","guitar"));
        artist1.save(new Artist("2","Kuy","Bass"));
        artist1.save(new Artist("3","Dog","Keyboard"));
        artist1.save(new Artist("4","Earth","Piano"));
        artist1.save(new Artist("5","Jong","Drum"));
        System.out.println("Data creation complete...");
    }


    public static void main(String[] args) {
        SpringApplication.run(TestMongoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
