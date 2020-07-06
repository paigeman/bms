package com.ncu.bms.bean;

import java.util.Date;

public class Reader {
    private String reader_id;

    private String reader_name;

    private String reader_sex;

    private String reader_contact;

    private Float reader_fine;

    private Integer reader_ban;

    private String reader_image;

    private Date reader_register_time;

    private Date reader_last_sign_time;

    private String reader_pwd;

    public String getReader_id() {
        return reader_id;
    }

    public void setReader_id(String reader_id) {
        this.reader_id = reader_id == null ? null : reader_id.trim();
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name == null ? null : reader_name.trim();
    }

    public String getReader_sex() {
        return reader_sex;
    }

    public void setReader_sex(String reader_sex) {
        this.reader_sex = reader_sex == null ? null : reader_sex.trim();
    }

    public String getReader_contact() {
        return reader_contact;
    }

    public void setReader_contact(String reader_contact) {
        this.reader_contact = reader_contact == null ? null : reader_contact.trim();
    }

    public Float getReader_fine() {
        return reader_fine;
    }

    public void setReader_fine(Float reader_fine) {
        this.reader_fine = reader_fine;
    }

    public Integer getReader_ban() {
        return reader_ban;
    }

    public void setReader_ban(Integer reader_ban) {
        this.reader_ban = reader_ban;
    }

    public String getReader_image() {
        return reader_image;
    }

    public void setReader_image(String reader_image) {
        this.reader_image = reader_image == null ? null : reader_image.trim();
    }

    public Date getReader_register_time() {
        return reader_register_time;
    }

    public void setReader_register_time(Date reader_register_time) {
        this.reader_register_time = reader_register_time;
    }

    public Date getReader_last_sign_time() {
        return reader_last_sign_time;
    }

    public void setReader_last_sign_time(Date reader_last_sign_time) {
        this.reader_last_sign_time = reader_last_sign_time;
    }

    public String getReader_pwd() {
        return reader_pwd;
    }

    public void setReader_pwd(String reader_pwd) {
        this.reader_pwd = reader_pwd == null ? null : reader_pwd.trim();
    }
}