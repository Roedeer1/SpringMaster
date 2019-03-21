package com.roedeer.jpademo.repository;

import com.roedeer.jpademo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Roedeer on 2/28/2019.
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
