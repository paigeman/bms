package com.ncu.bms.bean;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBook_NoIsNull() {
            addCriterion("book_No is null");
            return (Criteria) this;
        }

        public Criteria andBook_NoIsNotNull() {
            addCriterion("book_No is not null");
            return (Criteria) this;
        }

        public Criteria andBook_NoEqualTo(String value) {
            addCriterion("book_No =", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoNotEqualTo(String value) {
            addCriterion("book_No <>", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoGreaterThan(String value) {
            addCriterion("book_No >", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoGreaterThanOrEqualTo(String value) {
            addCriterion("book_No >=", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoLessThan(String value) {
            addCriterion("book_No <", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoLessThanOrEqualTo(String value) {
            addCriterion("book_No <=", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoLike(String value) {
            addCriterion("book_No like", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoNotLike(String value) {
            addCriterion("book_No not like", value, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoIn(List<String> values) {
            addCriterion("book_No in", values, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoNotIn(List<String> values) {
            addCriterion("book_No not in", values, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoBetween(String value1, String value2) {
            addCriterion("book_No between", value1, value2, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_NoNotBetween(String value1, String value2) {
            addCriterion("book_No not between", value1, value2, "book_No");
            return (Criteria) this;
        }

        public Criteria andBook_nameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBook_nameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBook_nameEqualTo(String value) {
            addCriterion("book_name =", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameGreaterThan(String value) {
            addCriterion("book_name >", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameLessThan(String value) {
            addCriterion("book_name <", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameLike(String value) {
            addCriterion("book_name like", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameNotLike(String value) {
            addCriterion("book_name not like", value, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameIn(List<String> values) {
            addCriterion("book_name in", values, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_nameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "book_name");
            return (Criteria) this;
        }

        public Criteria andBook_authorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBook_authorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBook_authorEqualTo(String value) {
            addCriterion("book_author =", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorGreaterThan(String value) {
            addCriterion("book_author >", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorLessThan(String value) {
            addCriterion("book_author <", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorLike(String value) {
            addCriterion("book_author like", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorNotLike(String value) {
            addCriterion("book_author not like", value, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorIn(List<String> values) {
            addCriterion("book_author in", values, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_authorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "book_author");
            return (Criteria) this;
        }

        public Criteria andBook_publisherIsNull() {
            addCriterion("book_publisher is null");
            return (Criteria) this;
        }

        public Criteria andBook_publisherIsNotNull() {
            addCriterion("book_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andBook_publisherEqualTo(String value) {
            addCriterion("book_publisher =", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherNotEqualTo(String value) {
            addCriterion("book_publisher <>", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherGreaterThan(String value) {
            addCriterion("book_publisher >", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherGreaterThanOrEqualTo(String value) {
            addCriterion("book_publisher >=", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherLessThan(String value) {
            addCriterion("book_publisher <", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherLessThanOrEqualTo(String value) {
            addCriterion("book_publisher <=", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherLike(String value) {
            addCriterion("book_publisher like", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherNotLike(String value) {
            addCriterion("book_publisher not like", value, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherIn(List<String> values) {
            addCriterion("book_publisher in", values, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherNotIn(List<String> values) {
            addCriterion("book_publisher not in", values, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherBetween(String value1, String value2) {
            addCriterion("book_publisher between", value1, value2, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_publisherNotBetween(String value1, String value2) {
            addCriterion("book_publisher not between", value1, value2, "book_publisher");
            return (Criteria) this;
        }

        public Criteria andBook_bioIsNull() {
            addCriterion("book_bio is null");
            return (Criteria) this;
        }

        public Criteria andBook_bioIsNotNull() {
            addCriterion("book_bio is not null");
            return (Criteria) this;
        }

        public Criteria andBook_bioEqualTo(String value) {
            addCriterion("book_bio =", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioNotEqualTo(String value) {
            addCriterion("book_bio <>", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioGreaterThan(String value) {
            addCriterion("book_bio >", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioGreaterThanOrEqualTo(String value) {
            addCriterion("book_bio >=", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioLessThan(String value) {
            addCriterion("book_bio <", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioLessThanOrEqualTo(String value) {
            addCriterion("book_bio <=", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioLike(String value) {
            addCriterion("book_bio like", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioNotLike(String value) {
            addCriterion("book_bio not like", value, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioIn(List<String> values) {
            addCriterion("book_bio in", values, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioNotIn(List<String> values) {
            addCriterion("book_bio not in", values, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioBetween(String value1, String value2) {
            addCriterion("book_bio between", value1, value2, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_bioNotBetween(String value1, String value2) {
            addCriterion("book_bio not between", value1, value2, "book_bio");
            return (Criteria) this;
        }

        public Criteria andBook_categoryIsNull() {
            addCriterion("book_category is null");
            return (Criteria) this;
        }

        public Criteria andBook_categoryIsNotNull() {
            addCriterion("book_category is not null");
            return (Criteria) this;
        }

        public Criteria andBook_categoryEqualTo(String value) {
            addCriterion("book_category =", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryNotEqualTo(String value) {
            addCriterion("book_category <>", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryGreaterThan(String value) {
            addCriterion("book_category >", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryGreaterThanOrEqualTo(String value) {
            addCriterion("book_category >=", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryLessThan(String value) {
            addCriterion("book_category <", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryLessThanOrEqualTo(String value) {
            addCriterion("book_category <=", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryLike(String value) {
            addCriterion("book_category like", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryNotLike(String value) {
            addCriterion("book_category not like", value, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryIn(List<String> values) {
            addCriterion("book_category in", values, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryNotIn(List<String> values) {
            addCriterion("book_category not in", values, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryBetween(String value1, String value2) {
            addCriterion("book_category between", value1, value2, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_categoryNotBetween(String value1, String value2) {
            addCriterion("book_category not between", value1, value2, "book_category");
            return (Criteria) this;
        }

        public Criteria andBook_priceIsNull() {
            addCriterion("book_price is null");
            return (Criteria) this;
        }

        public Criteria andBook_priceIsNotNull() {
            addCriterion("book_price is not null");
            return (Criteria) this;
        }

        public Criteria andBook_priceEqualTo(Float value) {
            addCriterion("book_price =", value, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceNotEqualTo(Float value) {
            addCriterion("book_price <>", value, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceGreaterThan(Float value) {
            addCriterion("book_price >", value, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceGreaterThanOrEqualTo(Float value) {
            addCriterion("book_price >=", value, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceLessThan(Float value) {
            addCriterion("book_price <", value, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceLessThanOrEqualTo(Float value) {
            addCriterion("book_price <=", value, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceIn(List<Float> values) {
            addCriterion("book_price in", values, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceNotIn(List<Float> values) {
            addCriterion("book_price not in", values, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceBetween(Float value1, Float value2) {
            addCriterion("book_price between", value1, value2, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_priceNotBetween(Float value1, Float value2) {
            addCriterion("book_price not between", value1, value2, "book_price");
            return (Criteria) this;
        }

        public Criteria andBook_numberIsNull() {
            addCriterion("book_number is null");
            return (Criteria) this;
        }

        public Criteria andBook_numberIsNotNull() {
            addCriterion("book_number is not null");
            return (Criteria) this;
        }

        public Criteria andBook_numberEqualTo(Integer value) {
            addCriterion("book_number =", value, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberNotEqualTo(Integer value) {
            addCriterion("book_number <>", value, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberGreaterThan(Integer value) {
            addCriterion("book_number >", value, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_number >=", value, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberLessThan(Integer value) {
            addCriterion("book_number <", value, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberLessThanOrEqualTo(Integer value) {
            addCriterion("book_number <=", value, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberIn(List<Integer> values) {
            addCriterion("book_number in", values, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberNotIn(List<Integer> values) {
            addCriterion("book_number not in", values, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberBetween(Integer value1, Integer value2) {
            addCriterion("book_number between", value1, value2, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("book_number not between", value1, value2, "book_number");
            return (Criteria) this;
        }

        public Criteria andBook_imageIsNull() {
            addCriterion("book_image is null");
            return (Criteria) this;
        }

        public Criteria andBook_imageIsNotNull() {
            addCriterion("book_image is not null");
            return (Criteria) this;
        }

        public Criteria andBook_imageEqualTo(String value) {
            addCriterion("book_image =", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageNotEqualTo(String value) {
            addCriterion("book_image <>", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageGreaterThan(String value) {
            addCriterion("book_image >", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageGreaterThanOrEqualTo(String value) {
            addCriterion("book_image >=", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageLessThan(String value) {
            addCriterion("book_image <", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageLessThanOrEqualTo(String value) {
            addCriterion("book_image <=", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageLike(String value) {
            addCriterion("book_image like", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageNotLike(String value) {
            addCriterion("book_image not like", value, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageIn(List<String> values) {
            addCriterion("book_image in", values, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageNotIn(List<String> values) {
            addCriterion("book_image not in", values, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageBetween(String value1, String value2) {
            addCriterion("book_image between", value1, value2, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_imageNotBetween(String value1, String value2) {
            addCriterion("book_image not between", value1, value2, "book_image");
            return (Criteria) this;
        }

        public Criteria andBook_banIsNull() {
            addCriterion("book_ban is null");
            return (Criteria) this;
        }

        public Criteria andBook_banIsNotNull() {
            addCriterion("book_ban is not null");
            return (Criteria) this;
        }

        public Criteria andBook_banEqualTo(Integer value) {
            addCriterion("book_ban =", value, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banNotEqualTo(Integer value) {
            addCriterion("book_ban <>", value, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banGreaterThan(Integer value) {
            addCriterion("book_ban >", value, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_ban >=", value, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banLessThan(Integer value) {
            addCriterion("book_ban <", value, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banLessThanOrEqualTo(Integer value) {
            addCriterion("book_ban <=", value, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banIn(List<Integer> values) {
            addCriterion("book_ban in", values, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banNotIn(List<Integer> values) {
            addCriterion("book_ban not in", values, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banBetween(Integer value1, Integer value2) {
            addCriterion("book_ban between", value1, value2, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_banNotBetween(Integer value1, Integer value2) {
            addCriterion("book_ban not between", value1, value2, "book_ban");
            return (Criteria) this;
        }

        public Criteria andBook_limitIsNull() {
            addCriterion("book_limit is null");
            return (Criteria) this;
        }

        public Criteria andBook_limitIsNotNull() {
            addCriterion("book_limit is not null");
            return (Criteria) this;
        }

        public Criteria andBook_limitEqualTo(Integer value) {
            addCriterion("book_limit =", value, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitNotEqualTo(Integer value) {
            addCriterion("book_limit <>", value, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitGreaterThan(Integer value) {
            addCriterion("book_limit >", value, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_limit >=", value, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitLessThan(Integer value) {
            addCriterion("book_limit <", value, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitLessThanOrEqualTo(Integer value) {
            addCriterion("book_limit <=", value, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitIn(List<Integer> values) {
            addCriterion("book_limit in", values, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitNotIn(List<Integer> values) {
            addCriterion("book_limit not in", values, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitBetween(Integer value1, Integer value2) {
            addCriterion("book_limit between", value1, value2, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_limitNotBetween(Integer value1, Integer value2) {
            addCriterion("book_limit not between", value1, value2, "book_limit");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayIsNull() {
            addCriterion("book_per_day is null");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayIsNotNull() {
            addCriterion("book_per_day is not null");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayEqualTo(Float value) {
            addCriterion("book_per_day =", value, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayNotEqualTo(Float value) {
            addCriterion("book_per_day <>", value, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayGreaterThan(Float value) {
            addCriterion("book_per_day >", value, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayGreaterThanOrEqualTo(Float value) {
            addCriterion("book_per_day >=", value, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayLessThan(Float value) {
            addCriterion("book_per_day <", value, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayLessThanOrEqualTo(Float value) {
            addCriterion("book_per_day <=", value, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayIn(List<Float> values) {
            addCriterion("book_per_day in", values, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayNotIn(List<Float> values) {
            addCriterion("book_per_day not in", values, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayBetween(Float value1, Float value2) {
            addCriterion("book_per_day between", value1, value2, "book_per_day");
            return (Criteria) this;
        }

        public Criteria andBook_per_dayNotBetween(Float value1, Float value2) {
            addCriterion("book_per_day not between", value1, value2, "book_per_day");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}