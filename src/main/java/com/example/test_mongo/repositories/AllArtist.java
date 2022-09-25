package com.example.test_mongo.repositories;

import com.example.test_mongo.models.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AllArtist extends MongoRepository<Artist,String> {
    @Query("{name:'?0'}")
    Artist findArtistByName(String name);

    public long count();

}
