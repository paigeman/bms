package com.ncu.bms.bean;

import java.util.Date;

public class Flow {
    private String id;

    private String flow_num;

    private String order_num;

    private String paid_amount;

    private Integer paid_method;

    private Date create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFlow_num() {
        return flow_num;
    }

    public void setFlow_num(String flow_num) {
        this.flow_num = flow_num == null ? null : flow_num.trim();
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num == null ? null : order_num.trim();
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount == null ? null : paid_amount.trim();
    }

    public Integer getPaid_method() {
        return paid_method;
    }

    public void setPaid_method(Integer paid_method) {
        this.paid_method = paid_method;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}