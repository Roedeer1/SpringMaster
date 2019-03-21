package com.roedeer.jedis.service;

import com.roedeer.jedis.model.Coffee;
import com.roedeer.jedis.model.CoffeeOrder;
import com.roedeer.jedis.model.OrderState;
import com.roedeer.jedis.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 3/9/2019 10:59 AM
 **/
@Slf4j
@Service
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository orderRepository;

    public CoffeeOrder createOrder(String customer, Coffee...coffee) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order);
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Update Order: {}", order);
        return true;
    }
}
