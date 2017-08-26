package org.hww.jdbctemplate.tx.configmethod.beans;

import org.hww.jdbctemplate.tx.configmethod.beans.OrderDao;

/**
 * Spring事务管理操作-xml配置方式
 */
public class OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void txAccount() {
        orderDao.lessMoney();

        //异常
        int i = 10 / 0;

        orderDao.addMoney();
    }
}
