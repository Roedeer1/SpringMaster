package com.roedeer.declarativetransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 如何解决invokeInsertThenRollback没有事务管理呢?
 *              1.注入FooService
 *              2.直接使用代理调用有事务的代理方法
 *              3.加上事务处理
 *              测试里面可以查看
 * @Author Roedeer
 * @Date 2/28/2019 3:10 PM
 **/
@Component
@Slf4j
public class FooServiceImpl implements FooService {

    @Autowired
    private FooService fooService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class, propagation = Propagation.NESTED)
    public void insertThenRollbackWithPropagation() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
//        throw new RollbackException();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void invokeInsertThenRollbackWithPropagation() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
        try {
            fooService.insertThenRollbackWithPropagation();
        } catch (RollbackException e) {
            log.error("RollbackException", e);
        }
        throw new RuntimeException();
    }

    @Override
//    @Transactional(rollbackFor = RollbackException.class) //加上事务处理
    public void invokeInsertThenRollback() throws RollbackException {
        insertThenRollback();
//        fooService.insertThenRollback(); // have transactions
//        ((FooService)(AopContext.currentProxy())).insertThenRollback(); //使用代理调用有事务的代理方法
    }

    @Override
    public void invokeInsertThenRollbackBySelfService() throws RollbackException {
        fooService.insertThenRollback(); // have transactions
    }

    @Override
    public void invokeInsertThenRollbackByAopContext() throws RollbackException {
        ((FooService)(AopContext.currentProxy())).insertThenRollback(); //使用代理调用有事务的代理方法
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class) //加上事务处理
    public void invokeInsertThenRollbackAddTransaction() throws RollbackException {
        insertThenRollback();
    }
}
