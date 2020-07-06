package com.ncu.bms.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdmin_idIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_idIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_idEqualTo(String value) {
            addCriterion("admin_id =", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotEqualTo(String value) {
            addCriterion("admin_id <>", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idGreaterThan(String value) {
            addCriterion("admin_id >", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idGreaterThanOrEqualTo(String value) {
            addCriterion("admin_id >=", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idLessThan(String value) {
            addCriterion("admin_id <", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idLessThanOrEqualTo(String value) {
            addCriterion("admin_id <=", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idLike(String value) {
            addCriterion("admin_id like", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotLike(String value) {
            addCriterion("admin_id not like", value, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idIn(List<String> values) {
            addCriterion("admin_id in", values, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotIn(List<String> values) {
            addCriterion("admin_id not in", values, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idBetween(String value1, String value2) {
            addCriterion("admin_id between", value1, value2, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_idNotBetween(String value1, String value2) {
            addCriterion("admin_id not between", value1, value2, "admin_id");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameEqualTo(String value) {
            addCriterion("admin_name =", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameGreaterThan(String value) {
            addCriterion("admin_name >", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameLessThan(String value) {
            addCriterion("admin_name <", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameLike(String value) {
            addCriterion("admin_name like", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameNotLike(String value) {
            addCriterion("admin_name not like", value, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameIn(List<String> values) {
            addCriterion("admin_name in", values, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_nameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "admin_name");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexIsNull() {
            addCriterion("admin_sex is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexIsNotNull() {
            addCriterion("admin_sex is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexEqualTo(String value) {
            addCriterion("admin_sex =", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexNotEqualTo(String value) {
            addCriterion("admin_sex <>", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexGreaterThan(String value) {
            addCriterion("admin_sex >", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexGreaterThanOrEqualTo(String value) {
            addCriterion("admin_sex >=", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexLessThan(String value) {
            addCriterion("admin_sex <", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexLessThanOrEqualTo(String value) {
            addCriterion("admin_sex <=", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexLike(String value) {
            addCriterion("admin_sex like", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexNotLike(String value) {
            addCriterion("admin_sex not like", value, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexIn(List<String> values) {
            addCriterion("admin_sex in", values, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexNotIn(List<String> values) {
            addCriterion("admin_sex not in", values, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexBetween(String value1, String value2) {
            addCriterion("admin_sex between", value1, value2, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_sexNotBetween(String value1, String value2) {
            addCriterion("admin_sex not between", value1, value2, "admin_sex");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactIsNull() {
            addCriterion("admin_contact is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactIsNotNull() {
            addCriterion("admin_contact is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactEqualTo(String value) {
            addCriterion("admin_contact =", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactNotEqualTo(String value) {
            addCriterion("admin_contact <>", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactGreaterThan(String value) {
            addCriterion("admin_contact >", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactGreaterThanOrEqualTo(String value) {
            addCriterion("admin_contact >=", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactLessThan(String value) {
            addCriterion("admin_contact <", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactLessThanOrEqualTo(String value) {
            addCriterion("admin_contact <=", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactLike(String value) {
            addCriterion("admin_contact like", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactNotLike(String value) {
            addCriterion("admin_contact not like", value, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactIn(List<String> values) {
            addCriterion("admin_contact in", values, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactNotIn(List<String> values) {
            addCriterion("admin_contact not in", values, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactBetween(String value1, String value2) {
            addCriterion("admin_contact between", value1, value2, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_contactNotBetween(String value1, String value2) {
            addCriterion("admin_contact not between", value1, value2, "admin_contact");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageIsNull() {
            addCriterion("admin_image is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageIsNotNull() {
            addCriterion("admin_image is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageEqualTo(String value) {
            addCriterion("admin_image =", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageNotEqualTo(String value) {
            addCriterion("admin_image <>", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageGreaterThan(String value) {
            addCriterion("admin_image >", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageGreaterThanOrEqualTo(String value) {
            addCriterion("admin_image >=", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageLessThan(String value) {
            addCriterion("admin_image <", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageLessThanOrEqualTo(String value) {
            addCriterion("admin_image <=", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageLike(String value) {
            addCriterion("admin_image like", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageNotLike(String value) {
            addCriterion("admin_image not like", value, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageIn(List<String> values) {
            addCriterion("admin_image in", values, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageNotIn(List<String> values) {
            addCriterion("admin_image not in", values, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageBetween(String value1, String value2) {
            addCriterion("admin_image between", value1, value2, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_imageNotBetween(String value1, String value2) {
            addCriterion("admin_image not between", value1, value2, "admin_image");
            return (Criteria) this;
        }

        public Criteria andAdmin_banIsNull() {
            addCriterion("admin_ban is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_banIsNotNull() {
            addCriterion("admin_ban is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_banEqualTo(Integer value) {
            addCriterion("admin_ban =", value, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banNotEqualTo(Integer value) {
            addCriterion("admin_ban <>", value, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banGreaterThan(Integer value) {
            addCriterion("admin_ban >", value, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_ban >=", value, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banLessThan(Integer value) {
            addCriterion("admin_ban <", value, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banLessThanOrEqualTo(Integer value) {
            addCriterion("admin_ban <=", value, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banIn(List<Integer> values) {
            addCriterion("admin_ban in", values, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banNotIn(List<Integer> values) {
            addCriterion("admin_ban not in", values, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banBetween(Integer value1, Integer value2) {
            addCriterion("admin_ban between", value1, value2, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_banNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_ban not between", value1, value2, "admin_ban");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdIsNull() {
            addCriterion("admin_pwd is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdIsNotNull() {
            addCriterion("admin_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdEqualTo(String value) {
            addCriterion("admin_pwd =", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdNotEqualTo(String value) {
            addCriterion("admin_pwd <>", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdGreaterThan(String value) {
            addCriterion("admin_pwd >", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_pwd >=", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdLessThan(String value) {
            addCriterion("admin_pwd <", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdLessThanOrEqualTo(String value) {
            addCriterion("admin_pwd <=", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdLike(String value) {
            addCriterion("admin_pwd like", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdNotLike(String value) {
            addCriterion("admin_pwd not like", value, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdIn(List<String> values) {
            addCriterion("admin_pwd in", values, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdNotIn(List<String> values) {
            addCriterion("admin_pwd not in", values, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdBetween(String value1, String value2) {
            addCriterion("admin_pwd between", value1, value2, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_pwdNotBetween(String value1, String value2) {
            addCriterion("admin_pwd not between", value1, value2, "admin_pwd");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootIsNull() {
            addCriterion("admin_root is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootIsNotNull() {
            addCriterion("admin_root is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootEqualTo(Integer value) {
            addCriterion("admin_root =", value, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootNotEqualTo(Integer value) {
            addCriterion("admin_root <>", value, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootGreaterThan(Integer value) {
            addCriterion("admin_root >", value, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_root >=", value, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootLessThan(Integer value) {
            addCriterion("admin_root <", value, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootLessThanOrEqualTo(Integer value) {
            addCriterion("admin_root <=", value, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootIn(List<Integer> values) {
            addCriterion("admin_root in", values, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootNotIn(List<Integer> values) {
            addCriterion("admin_root not in", values, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootBetween(Integer value1, Integer value2) {
            addCriterion("admin_root between", value1, value2, "admin_root");
            return (Criteria) this;
        }

        public Criteria andAdmin_rootNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_root not between", value1, value2, "admin_root");
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