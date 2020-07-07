package com.ncu.bms.service.impl;


import com.ncu.bms.bean.Flow;
import com.ncu.bms.bean.Orders;
import com.ncu.bms.dao.FlowMapper;
import com.ncu.bms.dao.OrdersMapper;
import com.ncu.bms.service.IOrderService;
import com.ncu.bms.util.OrderStatusEnum;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private FlowMapper flowMapper;

    @Autowired
    private Sid sid;

    @Override
    public boolean isSaveOrder(Orders order) {
//        System.out.println("enter");
        String orderId = order.getId();
//        System.out.println("enter1");
        try{
//            System.out.println(orderId);
//            System.out.println(ordersMapper.selectByPrimaryKey(orderId));
            if(ordersMapper.selectByPrimaryKey(orderId)!=null){
//                System.out.println("enter2");
                return false;
            }
            else{
//                System.out.println("enter3");
                if(ordersMapper.insert(order)!=0){
//                    System.out.println("enter4");
                    return true;
                }
                else{
//                    System.out.println("enter5");
                    return false;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isUpdateOrderStatus(String orderId, String alipayFlowNum, String paidAmount) {
        Orders order = ordersMapper.selectByPrimaryKey(orderId);
        if(order==null){
            return false;
        }
        else{
            if(order.getOrder_status().equals(OrderStatusEnum.WAIT_PAY.key)){
                order.setOrder_status(OrderStatusEnum.PAID.key);
                order.setPaid_time(new Date());
                order.setPaid_amount(paidAmount);
                if(ordersMapper.updateByPrimaryKeySelective(order)==0){
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
    public Orders getOrderById(String orderId) {
        return ordersMapper.selectByPrimaryKey(orderId);
    }

}
