package com.ncu.bms.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFlow_numIsNull() {
            addCriterion("flow_num is null");
            return (Criteria) this;
        }

        public Criteria andFlow_numIsNotNull() {
            addCriterion("flow_num is not null");
            return (Criteria) this;
        }

        public Criteria andFlow_numEqualTo(String value) {
            addCriterion("flow_num =", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numNotEqualTo(String value) {
            addCriterion("flow_num <>", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numGreaterThan(String value) {
            addCriterion("flow_num >", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numGreaterThanOrEqualTo(String value) {
            addCriterion("flow_num >=", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numLessThan(String value) {
            addCriterion("flow_num <", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numLessThanOrEqualTo(String value) {
            addCriterion("flow_num <=", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numLike(String value) {
            addCriterion("flow_num like", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numNotLike(String value) {
            addCriterion("flow_num not like", value, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numIn(List<String> values) {
            addCriterion("flow_num in", values, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numNotIn(List<String> values) {
            addCriterion("flow_num not in", values, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numBetween(String value1, String value2) {
            addCriterion("flow_num between", value1, value2, "flow_num");
            return (Criteria) this;
        }

        public Criteria andFlow_numNotBetween(String value1, String value2) {
            addCriterion("flow_num not between", value1, value2, "flow_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrder_numIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_numEqualTo(String value) {
            addCriterion("order_num =", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numNotEqualTo(String value) {
            addCriterion("order_num <>", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numGreaterThan(String value) {
            addCriterion("order_num >", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numLessThan(String value) {
            addCriterion("order_num <", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numLike(String value) {
            addCriterion("order_num like", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numNotLike(String value) {
            addCriterion("order_num not like", value, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numIn(List<String> values) {
            addCriterion("order_num in", values, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numNotIn(List<String> values) {
            addCriterion("order_num not in", values, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "order_num");
            return (Criteria) this;
        }

        public Criteria andOrder_numNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "order_num");
            return (Criteria) this;
        }

        public Criteria andPaid_amountIsNull() {
            addCriterion("paid_amount is null");
            return (Criteria) this;
        }

        public Criteria andPaid_amountIsNotNull() {
            addCriterion("paid_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPaid_amountEqualTo(String value) {
            addCriterion("paid_amount =", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountNotEqualTo(String value) {
            addCriterion("paid_amount <>", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountGreaterThan(String value) {
            addCriterion("paid_amount >", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountGreaterThanOrEqualTo(String value) {
            addCriterion("paid_amount >=", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountLessThan(String value) {
            addCriterion("paid_amount <", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountLessThanOrEqualTo(String value) {
            addCriterion("paid_amount <=", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountLike(String value) {
            addCriterion("paid_amount like", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountNotLike(String value) {
            addCriterion("paid_amount not like", value, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountIn(List<String> values) {
            addCriterion("paid_amount in", values, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountNotIn(List<String> values) {
            addCriterion("paid_amount not in", values, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountBetween(String value1, String value2) {
            addCriterion("paid_amount between", value1, value2, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_amountNotBetween(String value1, String value2) {
            addCriterion("paid_amount not between", value1, value2, "paid_amount");
            return (Criteria) this;
        }

        public Criteria andPaid_methodIsNull() {
            addCriterion("paid_method is null");
            return (Criteria) this;
        }

        public Criteria andPaid_methodIsNotNull() {
            addCriterion("paid_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaid_methodEqualTo(Integer value) {
            addCriterion("paid_method =", value, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodNotEqualTo(Integer value) {
            addCriterion("paid_method <>", value, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodGreaterThan(Integer value) {
            addCriterion("paid_method >", value, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodGreaterThanOrEqualTo(Integer value) {
            addCriterion("paid_method >=", value, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodLessThan(Integer value) {
            addCriterion("paid_method <", value, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodLessThanOrEqualTo(Integer value) {
            addCriterion("paid_method <=", value, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodIn(List<Integer> values) {
            addCriterion("paid_method in", values, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodNotIn(List<Integer> values) {
            addCriterion("paid_method not in", values, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodBetween(Integer value1, Integer value2) {
            addCriterion("paid_method between", value1, value2, "paid_method");
            return (Criteria) this;
        }

        public Criteria andPaid_methodNotBetween(Integer value1, Integer value2) {
            addCriterion("paid_method not between", value1, value2, "paid_method");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
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