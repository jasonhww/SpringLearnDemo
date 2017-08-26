package org.hww.jdbctemplate.tx.notemethod.beans;

import org.hww.jdbctemplate.tx.configmethod.beans.OrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring事务管理操作-xml配置方式
 */
@Transactional
public class OrderService2 {

    private OrderDao2 orderDao2;

    public void setOrderDao2(OrderDao2 orderDao2) {
        this.orderDao2 = orderDao2;
    }

    public void txAccount() {
        orderDao2.lessMoney();

        //异常
        //int i = 10 / 0;

        orderDao2.addMoney();
    }
}
