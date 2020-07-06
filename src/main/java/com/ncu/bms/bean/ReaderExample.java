package com.ncu.bms.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReaderExample() {
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

        public Criteria andReader_idIsNull() {
            addCriterion("reader_id is null");
            return (Criteria) this;
        }

        public Criteria andReader_idIsNotNull() {
            addCriterion("reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andReader_idEqualTo(String value) {
            addCriterion("reader_id =", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idNotEqualTo(String value) {
            addCriterion("reader_id <>", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idGreaterThan(String value) {
            addCriterion("reader_id >", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idGreaterThanOrEqualTo(String value) {
            addCriterion("reader_id >=", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idLessThan(String value) {
            addCriterion("reader_id <", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idLessThanOrEqualTo(String value) {
            addCriterion("reader_id <=", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idLike(String value) {
            addCriterion("reader_id like", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idNotLike(String value) {
            addCriterion("reader_id not like", value, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idIn(List<String> values) {
            addCriterion("reader_id in", values, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idNotIn(List<String> values) {
            addCriterion("reader_id not in", values, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idBetween(String value1, String value2) {
            addCriterion("reader_id between", value1, value2, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_idNotBetween(String value1, String value2) {
            addCriterion("reader_id not between", value1, value2, "reader_id");
            return (Criteria) this;
        }

        public Criteria andReader_nameIsNull() {
            addCriterion("reader_name is null");
            return (Criteria) this;
        }

        public Criteria andReader_nameIsNotNull() {
            addCriterion("reader_name is not null");
            return (Criteria) this;
        }

        public Criteria andReader_nameEqualTo(String value) {
            addCriterion("reader_name =", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameNotEqualTo(String value) {
            addCriterion("reader_name <>", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameGreaterThan(String value) {
            addCriterion("reader_name >", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameGreaterThanOrEqualTo(String value) {
            addCriterion("reader_name >=", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameLessThan(String value) {
            addCriterion("reader_name <", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameLessThanOrEqualTo(String value) {
            addCriterion("reader_name <=", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameLike(String value) {
            addCriterion("reader_name like", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameNotLike(String value) {
            addCriterion("reader_name not like", value, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameIn(List<String> values) {
            addCriterion("reader_name in", values, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameNotIn(List<String> values) {
            addCriterion("reader_name not in", values, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameBetween(String value1, String value2) {
            addCriterion("reader_name between", value1, value2, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_nameNotBetween(String value1, String value2) {
            addCriterion("reader_name not between", value1, value2, "reader_name");
            return (Criteria) this;
        }

        public Criteria andReader_sexIsNull() {
            addCriterion("reader_sex is null");
            return (Criteria) this;
        }

        public Criteria andReader_sexIsNotNull() {
            addCriterion("reader_sex is not null");
            return (Criteria) this;
        }

        public Criteria andReader_sexEqualTo(String value) {
            addCriterion("reader_sex =", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexNotEqualTo(String value) {
            addCriterion("reader_sex <>", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexGreaterThan(String value) {
            addCriterion("reader_sex >", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexGreaterThanOrEqualTo(String value) {
            addCriterion("reader_sex >=", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexLessThan(String value) {
            addCriterion("reader_sex <", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexLessThanOrEqualTo(String value) {
            addCriterion("reader_sex <=", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexLike(String value) {
            addCriterion("reader_sex like", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexNotLike(String value) {
            addCriterion("reader_sex not like", value, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexIn(List<String> values) {
            addCriterion("reader_sex in", values, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexNotIn(List<String> values) {
            addCriterion("reader_sex not in", values, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexBetween(String value1, String value2) {
            addCriterion("reader_sex between", value1, value2, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_sexNotBetween(String value1, String value2) {
            addCriterion("reader_sex not between", value1, value2, "reader_sex");
            return (Criteria) this;
        }

        public Criteria andReader_contactIsNull() {
            addCriterion("reader_contact is null");
            return (Criteria) this;
        }

        public Criteria andReader_contactIsNotNull() {
            addCriterion("reader_contact is not null");
            return (Criteria) this;
        }

        public Criteria andReader_contactEqualTo(String value) {
            addCriterion("reader_contact =", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactNotEqualTo(String value) {
            addCriterion("reader_contact <>", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactGreaterThan(String value) {
            addCriterion("reader_contact >", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactGreaterThanOrEqualTo(String value) {
            addCriterion("reader_contact >=", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactLessThan(String value) {
            addCriterion("reader_contact <", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactLessThanOrEqualTo(String value) {
            addCriterion("reader_contact <=", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactLike(String value) {
            addCriterion("reader_contact like", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactNotLike(String value) {
            addCriterion("reader_contact not like", value, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactIn(List<String> values) {
            addCriterion("reader_contact in", values, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactNotIn(List<String> values) {
            addCriterion("reader_contact not in", values, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactBetween(String value1, String value2) {
            addCriterion("reader_contact between", value1, value2, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_contactNotBetween(String value1, String value2) {
            addCriterion("reader_contact not between", value1, value2, "reader_contact");
            return (Criteria) this;
        }

        public Criteria andReader_fineIsNull() {
            addCriterion("reader_fine is null");
            return (Criteria) this;
        }

        public Criteria andReader_fineIsNotNull() {
            addCriterion("reader_fine is not null");
            return (Criteria) this;
        }

        public Criteria andReader_fineEqualTo(Float value) {
            addCriterion("reader_fine =", value, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineNotEqualTo(Float value) {
            addCriterion("reader_fine <>", value, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineGreaterThan(Float value) {
            addCriterion("reader_fine >", value, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineGreaterThanOrEqualTo(Float value) {
            addCriterion("reader_fine >=", value, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineLessThan(Float value) {
            addCriterion("reader_fine <", value, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineLessThanOrEqualTo(Float value) {
            addCriterion("reader_fine <=", value, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineIn(List<Float> values) {
            addCriterion("reader_fine in", values, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineNotIn(List<Float> values) {
            addCriterion("reader_fine not in", values, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineBetween(Float value1, Float value2) {
            addCriterion("reader_fine between", value1, value2, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_fineNotBetween(Float value1, Float value2) {
            addCriterion("reader_fine not between", value1, value2, "reader_fine");
            return (Criteria) this;
        }

        public Criteria andReader_banIsNull() {
            addCriterion("reader_ban is null");
            return (Criteria) this;
        }

        public Criteria andReader_banIsNotNull() {
            addCriterion("reader_ban is not null");
            return (Criteria) this;
        }

        public Criteria andReader_banEqualTo(Integer value) {
            addCriterion("reader_ban =", value, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banNotEqualTo(Integer value) {
            addCriterion("reader_ban <>", value, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banGreaterThan(Integer value) {
            addCriterion("reader_ban >", value, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_ban >=", value, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banLessThan(Integer value) {
            addCriterion("reader_ban <", value, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banLessThanOrEqualTo(Integer value) {
            addCriterion("reader_ban <=", value, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banIn(List<Integer> values) {
            addCriterion("reader_ban in", values, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banNotIn(List<Integer> values) {
            addCriterion("reader_ban not in", values, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banBetween(Integer value1, Integer value2) {
            addCriterion("reader_ban between", value1, value2, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_banNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_ban not between", value1, value2, "reader_ban");
            return (Criteria) this;
        }

        public Criteria andReader_imageIsNull() {
            addCriterion("reader_image is null");
            return (Criteria) this;
        }

        public Criteria andReader_imageIsNotNull() {
            addCriterion("reader_image is not null");
            return (Criteria) this;
        }

        public Criteria andReader_imageEqualTo(String value) {
            addCriterion("reader_image =", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageNotEqualTo(String value) {
            addCriterion("reader_image <>", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageGreaterThan(String value) {
            addCriterion("reader_image >", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageGreaterThanOrEqualTo(String value) {
            addCriterion("reader_image >=", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageLessThan(String value) {
            addCriterion("reader_image <", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageLessThanOrEqualTo(String value) {
            addCriterion("reader_image <=", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageLike(String value) {
            addCriterion("reader_image like", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageNotLike(String value) {
            addCriterion("reader_image not like", value, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageIn(List<String> values) {
            addCriterion("reader_image in", values, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageNotIn(List<String> values) {
            addCriterion("reader_image not in", values, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageBetween(String value1, String value2) {
            addCriterion("reader_image between", value1, value2, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_imageNotBetween(String value1, String value2) {
            addCriterion("reader_image not between", value1, value2, "reader_image");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeIsNull() {
            addCriterion("reader_register_time is null");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeIsNotNull() {
            addCriterion("reader_register_time is not null");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeEqualTo(Date value) {
            addCriterion("reader_register_time =", value, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeNotEqualTo(Date value) {
            addCriterion("reader_register_time <>", value, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeGreaterThan(Date value) {
            addCriterion("reader_register_time >", value, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("reader_register_time >=", value, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeLessThan(Date value) {
            addCriterion("reader_register_time <", value, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeLessThanOrEqualTo(Date value) {
            addCriterion("reader_register_time <=", value, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeIn(List<Date> values) {
            addCriterion("reader_register_time in", values, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeNotIn(List<Date> values) {
            addCriterion("reader_register_time not in", values, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeBetween(Date value1, Date value2) {
            addCriterion("reader_register_time between", value1, value2, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_register_timeNotBetween(Date value1, Date value2) {
            addCriterion("reader_register_time not between", value1, value2, "reader_register_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeIsNull() {
            addCriterion("reader_last_sign_time is null");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeIsNotNull() {
            addCriterion("reader_last_sign_time is not null");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeEqualTo(Date value) {
            addCriterion("reader_last_sign_time =", value, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeNotEqualTo(Date value) {
            addCriterion("reader_last_sign_time <>", value, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeGreaterThan(Date value) {
            addCriterion("reader_last_sign_time >", value, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("reader_last_sign_time >=", value, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeLessThan(Date value) {
            addCriterion("reader_last_sign_time <", value, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeLessThanOrEqualTo(Date value) {
            addCriterion("reader_last_sign_time <=", value, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeIn(List<Date> values) {
            addCriterion("reader_last_sign_time in", values, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeNotIn(List<Date> values) {
            addCriterion("reader_last_sign_time not in", values, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeBetween(Date value1, Date value2) {
            addCriterion("reader_last_sign_time between", value1, value2, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_last_sign_timeNotBetween(Date value1, Date value2) {
            addCriterion("reader_last_sign_time not between", value1, value2, "reader_last_sign_time");
            return (Criteria) this;
        }

        public Criteria andReader_pwdIsNull() {
            addCriterion("reader_pwd is null");
            return (Criteria) this;
        }

        public Criteria andReader_pwdIsNotNull() {
            addCriterion("reader_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andReader_pwdEqualTo(String value) {
            addCriterion("reader_pwd =", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdNotEqualTo(String value) {
            addCriterion("reader_pwd <>", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdGreaterThan(String value) {
            addCriterion("reader_pwd >", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdGreaterThanOrEqualTo(String value) {
            addCriterion("reader_pwd >=", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdLessThan(String value) {
            addCriterion("reader_pwd <", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdLessThanOrEqualTo(String value) {
            addCriterion("reader_pwd <=", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdLike(String value) {
            addCriterion("reader_pwd like", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdNotLike(String value) {
            addCriterion("reader_pwd not like", value, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdIn(List<String> values) {
            addCriterion("reader_pwd in", values, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdNotIn(List<String> values) {
            addCriterion("reader_pwd not in", values, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdBetween(String value1, String value2) {
            addCriterion("reader_pwd between", value1, value2, "reader_pwd");
            return (Criteria) this;
        }

        public Criteria andReader_pwdNotBetween(String value1, String value2) {
            addCriterion("reader_pwd not between", value1, value2, "reader_pwd");
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