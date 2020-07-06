package com.ncu.bms.service.impl;


import com.ncu.bms.bean.Flow;
import com.ncu.bms.bean.Order;
import com.ncu.bms.dao.FlowMapper;
import com.ncu.bms.dao.OrderMapper;
import com.ncu.bms.service.IOrderService;
import com.ncu.bms.util.OrderStatusEnum;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private FlowMapper flowMapper;

    @Autowired
    private Sid sid;

    @Override
    public boolean isSaveOrder(Order order) {
        String orderId = order.getId();
        if(orderMapper.selectByPrimaryKey(orderId)!=null){
            return false;
        }
        else{
           if(orderMapper.insert(order)!=0){
               return true;
           }
           else{
               return false;
           }
        }
    }

    @Override
    public boolean isUpdateOrderStatus(String orderId, String alipayFlowNum, String paidAmount) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order==null){
            return false;
        }
        else{
            if(order.getOrder_status().equals(OrderStatusEnum.WAIT_PAY.key)){
                order.setOrder_status(OrderStatusEnum.PAID.key);
                order.setPaid_time(new Date());
                order.setPaid_amount(paidAmount);
                if(orderMapper.updateByPrimaryKeySelective(order)==0){
                    return false;
                }
                else{
                    String flowId = sid.nextShort();
                    Flow flow = new Flow();
                    flow.setId(flowId);
                    flow.setFlow_num(alipayFlowNum);
                    flow.setCreate_time(new Date());
                    flow.setOrder_num(orderId);
                    flow.setPaid_amount(paidAmount);
                    flow.setPaid_method(1);
                    if(flowMapper.insertSelective(flow)!=0){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

}
