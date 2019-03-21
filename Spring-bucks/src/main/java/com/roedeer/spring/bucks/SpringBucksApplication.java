package com.roedeer.spring.bucks;

import com.roedeer.spring.bucks.model.Coffee;
import com.roedeer.spring.bucks.model.CoffeeOrder;
import com.roedeer.spring.bucks.model.OrderState;
import com.roedeer.spring.bucks.repository.CoffeeOrderRepository;
import com.roedeer.spring.bucks.repository.CoffeeRepository;
import com.roedeer.spring.bucks.service.CoffeeOrderService;
import com.roedeer.spring.bucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 3/2/2019 2:04 PM
 **/
@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
public class SpringBucksApplication implements ApplicationRunner {
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;
    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("All coffee {}", coffeeRepository.findAll());

        Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
        if (latte.isPresent()) {
            CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
            log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
            log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
        }
    }
}
