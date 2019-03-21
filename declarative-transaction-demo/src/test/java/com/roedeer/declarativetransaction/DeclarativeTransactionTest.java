package com.roedeer.declarativetransaction;

import com.roedeer.declarativetransactiondemo.DeclarativeTransactionDemoApplication;
import com.roedeer.declarativetransactiondemo.FooService;
import com.roedeer.declarativetransactiondemo.RollbackException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 2/28/2019 11:23 PM
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeclarativeTransactionDemoApplication.class)
public class DeclarativeTransactionTest {
    @Autowired
    private FooService fooService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void invokeInsertThenRollback() {
        try {
            fooService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR = 'BBB'", Long.class));
        }
    }

    @Test
    public void invokeInsertThenRollbackBySelfService() {
        try {
            fooService.invokeInsertThenRollbackBySelfService();
        } catch (Exception e) {
            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR = 'BBB'", Long.class));
        }
    }

    @Test
    public void invokeInsertThenRollbackByAopContext() {
        try {
            fooService.invokeInsertThenRollbackByAopContext();
        } catch (Exception e) {
            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR = 'BBB'", Long.class));
        }
    }

    @Test
    public void invokeInsertThenRollbackAddTransaction() {
        try {
            fooService.invokeInsertThenRollbackAddTransaction();
        } catch (Exception e) {
            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR = 'BBB'", Long.class));
        }
    }

}
