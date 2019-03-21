package com.roedeer.jpademo.repository;

import com.roedeer.jpademo.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Roedeer on 2/28/2019.
 */
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
