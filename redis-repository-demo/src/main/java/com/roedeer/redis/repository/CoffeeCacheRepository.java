package com.roedeer.redis.repository;

import com.roedeer.redis.model.Coffee;
import com.roedeer.redis.model.CoffeeCache;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 3/6/2019 9:54 AM
 **/
public interface CoffeeCacheRepository extends CrudRepository<CoffeeCache, Long> {
    Optional<CoffeeCache> findOneByName(String name);
}
