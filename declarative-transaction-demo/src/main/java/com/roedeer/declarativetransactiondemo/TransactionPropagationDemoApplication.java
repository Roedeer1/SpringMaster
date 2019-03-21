package com.roedeer.declarativetransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description 对Propagation.NESTED(内部创建新事物)和Propagation.REQUIRES_NEW(直接另外创建新事物)的理解
 *              外部事务回滚,内部事务会跟随回滚,其他没影响
 * @Author Roedeer
 * @Date 3/1/2019 9:05 AM
 **/
@SpringBootApplication
@Slf4j
public class TransactionPropagationDemoApplication implements ApplicationRunner {
    @Autowired
    private FooService fooService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TransactionPropagationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            fooService.invokeInsertThenRollbackWithPropagation();
        } catch (Exception e) {

        }
        log.info("AAA {}", jdbcTemplate.queryForObject("select count(*) from foo where bar = 'AAA'", Long.class));
        log.info("BBB {}", jdbcTemplate.queryForObject("select count(*) from foo where bar = 'BBB'", Long.class));
    }
}
