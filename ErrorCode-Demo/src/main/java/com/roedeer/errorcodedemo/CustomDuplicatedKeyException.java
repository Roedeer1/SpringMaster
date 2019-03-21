package com.roedeer.errorcodedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 2/28/2019 3:30 PM
 **/
public class CustomDuplicatedKeyException extends DuplicateKeyException {

    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
