package com.ncu.bms.bean;

public class Admin {
    private String admin_id;

    private String admin_name;

    private String admin_sex;

    private String admin_contact;

    private String admin_image;

    private Integer admin_ban;

    private String admin_pwd;

    private Integer admin_root;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id == null ? null : admin_id.trim();
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name == null ? null : admin_name.trim();
    }

    public String getAdmin_sex() {
        return admin_sex;
    }

    public void setAdmin_sex(String admin_sex) {
        this.admin_sex = admin_sex == null ? null : admin_sex.trim();
    }

    public String getAdmin_contact() {
        return admin_contact;
    }

    public void setAdmin_contact(String admin_contact) {
        this.admin_contact = admin_contact == null ? null : admin_contact.trim();
    }

    public String getAdmin_image() {
        return admin_image;
    }

    public void setAdmin_image(String admin_image) {
        this.admin_image = admin_image == null ? null : admin_image.trim();
    }

    public Integer getAdmin_ban() {
        return admin_ban;
    }

    public void setAdmin_ban(Integer admin_ban) {
        this.admin_ban = admin_ban;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd == null ? null : admin_pwd.trim();
    }

    public Integer getAdmin_root() {
        return admin_root;
    }

    public void setAdmin_root(Integer admin_root) {
        this.admin_root = admin_root;
    }
}