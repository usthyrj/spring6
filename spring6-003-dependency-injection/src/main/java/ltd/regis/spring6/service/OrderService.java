package ltd.regis.spring6.service;

import ltd.regis.spring6.dao.OrderDao;

public class OrderService {

    private OrderDao orderDao;

//    通过set方法给属性赋值
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate() {
        orderDao.insert();
    }

    @Override
    public String toString() {
        return "OrderService{" +
                "orderDao=" + orderDao +
                '}';
    }
}
