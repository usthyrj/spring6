package com.regis.dao.impl;

import com.regis.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImplForMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存订单信息....");
    }
}
