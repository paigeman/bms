package com.ncu.bms.service;

import com.ncu.bms.bean.Orders;

public interface IOrderService {

    /**
     * @param order 订单
     * */
    public boolean isSaveOrder(Orders order);

    /**
     * @param orderId 订单id
     * @param alipayFlowNum 流水号
     * @param paidAmount 支付金额
     * */
    public boolean isUpdateOrderStatus(String orderId,String alipayFlowNum,String paidAmount);

    /**
     * @param orderId 订单id
     * */
    public Orders getOrderById(String orderId);

}
