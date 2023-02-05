package com.regis.service;

import com.regis.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private OrderDao orderDao;

    public OrderService(OrderDao orderDao1) {
        this.orderDao = orderDao1;
    }

    //    @Autowired
    //    @Qualifier(value = "orderDaoImplForMySQL")
//    @Qualifier(value = "orderDaoImplForOracle")
//    public void setOrderDao(OrderDao orderDao) {
//        this.orderDao = orderDao;
//    }

    public void  generateOrder() {
        orderDao.insert();
    }
}
