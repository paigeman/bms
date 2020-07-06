package com.ncu.bms.bean;

import java.util.Date;

public class Record {
    private Integer record_id;

    private String record_book;

    private String record_reader;

    private String record_admin;

    private Date record_borrow;

    private Date record_return;

    private Integer record_is_return;

    private Integer record_is_overtime;

    private Integer record_is_lost;

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public String getRecord_book() {
        return record_book;
    }

    public void setRecord_book(String record_book) {
        this.record_book = record_book == null ? null : record_book.trim();
    }

    public String getRecord_reader() {
        return record_reader;
    }

    public void setRecord_reader(String record_reader) {
        this.record_reader = record_reader == null ? null : record_reader.trim();
    }

    public String getRecord_admin() {
        return record_admin;
    }

    public void setRecord_admin(String record_admin) {
        this.record_admin = record_admin == null ? null : record_admin.trim();
    }

    public Date getRecord_borrow() {
        return record_borrow;
    }

    public void setRecord_borrow(Date record_borrow) {
        this.record_borrow = record_borrow;
    }

    public Date getRecord_return() {
        return record_return;
    }

    public void setRecord_return(Date record_return) {
        this.record_return = record_return;
    }

    public Integer getRecord_is_return() {
        return record_is_return;
    }

    public void setRecord_is_return(Integer record_is_return) {
        this.record_is_return = record_is_return;
    }

    public Integer getRecord_is_overtime() {
        return record_is_overtime;
    }

    public void setRecord_is_overtime(Integer record_is_overtime) {
        this.record_is_overtime = record_is_overtime;
    }

    public Integer getRecord_is_lost() {
        return record_is_lost;
    }

    public void setRecord_is_lost(Integer record_is_lost) {
        this.record_is_lost = record_is_lost;
    }
}