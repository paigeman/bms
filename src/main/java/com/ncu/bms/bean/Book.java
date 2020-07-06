package com.ncu.bms.bean;

public class Book {
    private String book_No;

    private String book_name;

    private String book_author;

    private String book_publisher;

    private String book_bio;

    private String book_category;

    private Float book_price;

    private Integer book_number;

    private String book_image;

    private Integer book_ban;

    private Integer book_limit;

    private Float book_per_day;

    public String getBook_No() {
        return book_No;
    }

    public void setBook_No(String book_No) {
        this.book_No = book_No == null ? null : book_No.trim();
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name == null ? null : book_name.trim();
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author == null ? null : book_author.trim();
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher == null ? null : book_publisher.trim();
    }

    public String getBook_bio() {
        return book_bio;
    }

    public void setBook_bio(String book_bio) {
        this.book_bio = book_bio == null ? null : book_bio.trim();
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category == null ? null : book_category.trim();
    }

    public Float getBook_price() {
        return book_price;
    }

    public void setBook_price(Float book_price) {
        this.book_price = book_price;
    }

    public Integer getBook_number() {
        return book_number;
    }

    public void setBook_number(Integer book_number) {
        this.book_number = book_number;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image == null ? null : book_image.trim();
    }

    public Integer getBook_ban() {
        return book_ban;
    }

    public void setBook_ban(Integer book_ban) {
        this.book_ban = book_ban;
    }

    public Integer getBook_limit() {
        return book_limit;
    }

    public void setBook_limit(Integer book_limit) {
        this.book_limit = book_limit;
    }

    public Float getBook_per_day() {
        return book_per_day;
    }

    public void setBook_per_day(Float book_per_day) {
        this.book_per_day = book_per_day;
    }
}