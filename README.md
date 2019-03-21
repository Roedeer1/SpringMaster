###### hello spring

> spring的actuator，可以查看spring的url，bean，health

##### spring data source

> 默认使用spring自带的Hikari，还有其他的阿里的druid
>
> 也可以自己配置DataSource，例如pure-spring-DataSource
>
> spring自己加载了一些jdbc的操作bean，例如jdbcTemplate，可以执行batch update等
>
> -------------------------------------------------
>
> 1.多数据源，分库分表，读写分离的关系，该如何配置  --> 答疑2019-02 
>
> 系统需要访问垂直拆分，水平拆分的分库分表的数据库，使用数据库中间件
>
> TDDL、Cobar、MyCAT、Sharding-Shpere

##### spring transaction

> spring有声明式事务和编程性事务，注释和使用transactionTemplate管理事务的区别

spring errorCode使用CustomSQLErrorCodesTranslation定制捕获sql异常

##### spring jpa

