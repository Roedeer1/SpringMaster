package com.roedeer.declarativetransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description D:\software\apache-maven-3.5.0\repository\org\springframework\spring-jdbc\5.1.3.RELEASE\
 *              spring-jdbc-5.1.3.RELEASE.jar!\org\springframework\jdbc\support\sql-error-codes.xml
 *              SQLErrorCodes.java
 * @Author Roedeer
 * @Date 2/28/2019 3:04 PM
 **/
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@Slf4j
//public class DeclarativeTransactionDemoApplication implements CommandLineRunner { // test need
public class DeclarativeTransactionDemoApplication {

    @Autowired
    private FooService fooService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeclarativeTransactionDemoApplication.class, args);
    }
//    @Override
//    public void run(String... args) throws Exception {
//        fooService.insertRecord();
//        log.info("AAA {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
//
//        try {
//            fooService.insertThenRollback();
//        } catch (Exception e) {
//            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
//        }
//
//        try {
//            fooService.invokeInsertThenRollback();
//        } catch (Exception e) {
//            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
//        }
//    }
}
