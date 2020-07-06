package com.ncu.bms.service;

import com.ncu.bms.bean.Order;

public interface IOrderService {

    /**
     * @param order 订单
     * */
    public boolean isSaveOrder(Order order);

    /**
     * @param orderId 订单id
     * @param alipayFlowNum 流水号
     * @param paidAmount 支付金额
     * */
    public boolean isUpdateOrderStatus(String orderId,String alipayFlowNum,String paidAmount);

    /**
     * @param orderId 订单id
     * */
    public Order getOrderById(String orderId);

}
