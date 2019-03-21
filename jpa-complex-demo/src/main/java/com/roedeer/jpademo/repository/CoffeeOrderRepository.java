package com.roedeer.jpademo.repository;

import com.roedeer.jpademo.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Roedeer on 2/28/2019.
 */
public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByCustomerOrderById(String customer);
    List<CoffeeOrder> findByItems_Name(String name);
}
