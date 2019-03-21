package com.roedeer.declarativetransactiondemo;

/**
 * @Description TODO
 * @Author Roedeer
 * @Date 2/28/2019 3:09 PM
 **/
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
    void invokeInsertThenRollbackBySelfService() throws RollbackException;
    void invokeInsertThenRollbackByAopContext() throws RollbackException;
    void invokeInsertThenRollbackAddTransaction() throws RollbackException;
    void insertThenRollbackWithPropagation() throws RollbackException;
    void invokeInsertThenRollbackWithPropagation();
}
