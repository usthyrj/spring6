package com.regis.dao.impl;

import com.regis.dao.OrderDao;
import org.springframework.stereotype.Repository;

//@Repository
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle正在保存用户信息.....");
    }
}
