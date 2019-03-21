package com.roedeer.mongodb.repository;

import com.roedeer.mongodb.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 3/5/2019 11:41 AM
 **/
public interface CoffeeRepository extends MongoRepository<Coffee, String> {
    List<Coffee> findByName(String name);
}
