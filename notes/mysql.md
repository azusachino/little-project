# 关于mysql的一些笔记

## mysql查询优化原理分析

操作：查询条件放到子查询中，子查询只查主键ID，然后使用子查询中确定的主键关联查询其他的属性字段；  
原理：减少回表操作；  

```sql
select * from test a inner join (select id from test where val=4 limit 300000,5) b on a.id=b.id;
```

## 乐观锁&悲观锁

![mysql-lock](../resources/sql/mysql-lock.jpg)
select...for update是MySQL提供的实现悲观锁的方式.在MySQL中用悲观锁务必须确定走了索引，而不是全表扫描，否则将会将整个数据表锁住.  
利用数据版本号(version)机制(或者是时间戳)是乐观锁最常用的一种实现方式
