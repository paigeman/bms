package com.ncu.bms.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
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

        public void addCriterion(String condition) {
        //protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
        //protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        public void addCriterion(String condition, Object value1, Object value2, String property) {
        //protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRecord_idIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecord_idIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_idEqualTo(Integer value) {
            addCriterion("record_id =", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotEqualTo(Integer value) {
            addCriterion("record_id <>", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idGreaterThan(Integer value) {
            addCriterion("record_id >", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_id >=", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idLessThan(Integer value) {
            addCriterion("record_id <", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idLessThanOrEqualTo(Integer value) {
            addCriterion("record_id <=", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idIn(List<Integer> values) {
            addCriterion("record_id in", values, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotIn(List<Integer> values) {
            addCriterion("record_id not in", values, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idBetween(Integer value1, Integer value2) {
            addCriterion("record_id between", value1, value2, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotBetween(Integer value1, Integer value2) {
            addCriterion("record_id not between", value1, value2, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_bookIsNull() {
            addCriterion("record_book is null");
            return (Criteria) this;
        }

        public Criteria andRecord_bookIsNotNull() {
            addCriterion("record_book is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_bookEqualTo(String value) {
            addCriterion("record_book =", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookNotEqualTo(String value) {
            addCriterion("record_book <>", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookGreaterThan(String value) {
            addCriterion("record_book >", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookGreaterThanOrEqualTo(String value) {
            addCriterion("record_book >=", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookLessThan(String value) {
            addCriterion("record_book <", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookLessThanOrEqualTo(String value) {
            addCriterion("record_book <=", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookLike(String value) {
            addCriterion("record_book like", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookNotLike(String value) {
            addCriterion("record_book not like", value, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookIn(List<String> values) {
            addCriterion("record_book in", values, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookNotIn(List<String> values) {
            addCriterion("record_book not in", values, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookBetween(String value1, String value2) {
            addCriterion("record_book between", value1, value2, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_bookNotBetween(String value1, String value2) {
            addCriterion("record_book not between", value1, value2, "record_book");
            return (Criteria) this;
        }

        public Criteria andRecord_readerIsNull() {
            addCriterion("record_reader is null");
            return (Criteria) this;
        }

        public Criteria andRecord_readerIsNotNull() {
            addCriterion("record_reader is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_readerEqualTo(String value) {
            addCriterion("record_reader =", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerNotEqualTo(String value) {
            addCriterion("record_reader <>", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerGreaterThan(String value) {
            addCriterion("record_reader >", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerGreaterThanOrEqualTo(String value) {
            addCriterion("record_reader >=", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerLessThan(String value) {
            addCriterion("record_reader <", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerLessThanOrEqualTo(String value) {
            addCriterion("record_reader <=", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerLike(String value) {
            addCriterion("record_reader like", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerNotLike(String value) {
            addCriterion("record_reader not like", value, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerIn(List<String> values) {
            addCriterion("record_reader in", values, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerNotIn(List<String> values) {
            addCriterion("record_reader not in", values, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerBetween(String value1, String value2) {
            addCriterion("record_reader between", value1, value2, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_readerNotBetween(String value1, String value2) {
            addCriterion("record_reader not between", value1, value2, "record_reader");
            return (Criteria) this;
        }

        public Criteria andRecord_adminIsNull() {
            addCriterion("record_admin is null");
            return (Criteria) this;
        }

        public Criteria andRecord_adminIsNotNull() {
            addCriterion("record_admin is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_adminEqualTo(String value) {
            addCriterion("record_admin =", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminNotEqualTo(String value) {
            addCriterion("record_admin <>", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminGreaterThan(String value) {
            addCriterion("record_admin >", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminGreaterThanOrEqualTo(String value) {
            addCriterion("record_admin >=", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminLessThan(String value) {
            addCriterion("record_admin <", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminLessThanOrEqualTo(String value) {
            addCriterion("record_admin <=", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminLike(String value) {
            addCriterion("record_admin like", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminNotLike(String value) {
            addCriterion("record_admin not like", value, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminIn(List<String> values) {
            addCriterion("record_admin in", values, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminNotIn(List<String> values) {
            addCriterion("record_admin not in", values, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminBetween(String value1, String value2) {
            addCriterion("record_admin between", value1, value2, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_adminNotBetween(String value1, String value2) {
            addCriterion("record_admin not between", value1, value2, "record_admin");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowIsNull() {
            addCriterion("record_borrow is null");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowIsNotNull() {
            addCriterion("record_borrow is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowEqualTo(Date value) {
            addCriterion("record_borrow =", value, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowNotEqualTo(Date value) {
            addCriterion("record_borrow <>", value, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowGreaterThan(Date value) {
            addCriterion("record_borrow >", value, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowGreaterThanOrEqualTo(Date value) {
            addCriterion("record_borrow >=", value, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowLessThan(Date value) {
            addCriterion("record_borrow <", value, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowLessThanOrEqualTo(Date value) {
            addCriterion("record_borrow <=", value, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowIn(List<Date> values) {
            addCriterion("record_borrow in", values, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowNotIn(List<Date> values) {
            addCriterion("record_borrow not in", values, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowBetween(Date value1, Date value2) {
            addCriterion("record_borrow between", value1, value2, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_borrowNotBetween(Date value1, Date value2) {
            addCriterion("record_borrow not between", value1, value2, "record_borrow");
            return (Criteria) this;
        }

        public Criteria andRecord_returnIsNull() {
            addCriterion("record_return is null");
            return (Criteria) this;
        }

        public Criteria andRecord_returnIsNotNull() {
            addCriterion("record_return is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_returnEqualTo(Date value) {
            addCriterion("record_return =", value, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnNotEqualTo(Date value) {
            addCriterion("record_return <>", value, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnGreaterThan(Date value) {
            addCriterion("record_return >", value, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnGreaterThanOrEqualTo(Date value) {
            addCriterion("record_return >=", value, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnLessThan(Date value) {
            addCriterion("record_return <", value, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnLessThanOrEqualTo(Date value) {
            addCriterion("record_return <=", value, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnIn(List<Date> values) {
            addCriterion("record_return in", values, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnNotIn(List<Date> values) {
            addCriterion("record_return not in", values, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnBetween(Date value1, Date value2) {
            addCriterion("record_return between", value1, value2, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_returnNotBetween(Date value1, Date value2) {
            addCriterion("record_return not between", value1, value2, "record_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnIsNull() {
            addCriterion("record_is_return is null");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnIsNotNull() {
            addCriterion("record_is_return is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnEqualTo(Integer value) {
            addCriterion("record_is_return =", value, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnNotEqualTo(Integer value) {
            addCriterion("record_is_return <>", value, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnGreaterThan(Integer value) {
            addCriterion("record_is_return >", value, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_is_return >=", value, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnLessThan(Integer value) {
            addCriterion("record_is_return <", value, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnLessThanOrEqualTo(Integer value) {
            addCriterion("record_is_return <=", value, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnIn(List<Integer> values) {
            addCriterion("record_is_return in", values, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnNotIn(List<Integer> values) {
            addCriterion("record_is_return not in", values, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnBetween(Integer value1, Integer value2) {
            addCriterion("record_is_return between", value1, value2, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_returnNotBetween(Integer value1, Integer value2) {
            addCriterion("record_is_return not between", value1, value2, "record_is_return");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeIsNull() {
            addCriterion("record_is_overtime is null");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeIsNotNull() {
            addCriterion("record_is_overtime is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeEqualTo(Integer value) {
            addCriterion("record_is_overtime =", value, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeNotEqualTo(Integer value) {
            addCriterion("record_is_overtime <>", value, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeGreaterThan(Integer value) {
            addCriterion("record_is_overtime >", value, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_is_overtime >=", value, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeLessThan(Integer value) {
            addCriterion("record_is_overtime <", value, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeLessThanOrEqualTo(Integer value) {
            addCriterion("record_is_overtime <=", value, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeIn(List<Integer> values) {
            addCriterion("record_is_overtime in", values, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeNotIn(List<Integer> values) {
            addCriterion("record_is_overtime not in", values, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeBetween(Integer value1, Integer value2) {
            addCriterion("record_is_overtime between", value1, value2, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_overtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("record_is_overtime not between", value1, value2, "record_is_overtime");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostIsNull() {
            addCriterion("record_is_lost is null");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostIsNotNull() {
            addCriterion("record_is_lost is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostEqualTo(Integer value) {
            addCriterion("record_is_lost =", value, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostNotEqualTo(Integer value) {
            addCriterion("record_is_lost <>", value, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostGreaterThan(Integer value) {
            addCriterion("record_is_lost >", value, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_is_lost >=", value, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostLessThan(Integer value) {
            addCriterion("record_is_lost <", value, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostLessThanOrEqualTo(Integer value) {
            addCriterion("record_is_lost <=", value, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostIn(List<Integer> values) {
            addCriterion("record_is_lost in", values, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostNotIn(List<Integer> values) {
            addCriterion("record_is_lost not in", values, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostBetween(Integer value1, Integer value2) {
            addCriterion("record_is_lost between", value1, value2, "record_is_lost");
            return (Criteria) this;
        }

        public Criteria andRecord_is_lostNotBetween(Integer value1, Integer value2) {
            addCriterion("record_is_lost not between", value1, value2, "record_is_lost");
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