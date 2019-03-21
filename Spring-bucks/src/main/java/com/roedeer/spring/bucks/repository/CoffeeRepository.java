package com.roedeer.spring.bucks.repository;

import com.roedeer.spring.bucks.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
