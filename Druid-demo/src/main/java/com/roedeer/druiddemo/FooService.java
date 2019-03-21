package com.roedeer.druiddemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 3/1/2019 9:26 AM
 **/
@Repository
@Slf4j
public class FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过sql的select和update同时操作,会有一个获得锁操作,然后再使用线程等待2秒,让Druid捕捉到并打印出来
     */
    @Transactional
    public void selectForUpdate() {
        jdbcTemplate.queryForObject("select id from foo where id = 1 for update", Long.class);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }
}
