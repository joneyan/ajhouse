package com.aj.ajhouse.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class AjDocsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AjDocsExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDoCtitleIsNull() {
            addCriterion("do_ctitle is null");
            return (Criteria) this;
        }

        public Criteria andDoCtitleIsNotNull() {
            addCriterion("do_ctitle is not null");
            return (Criteria) this;
        }

        public Criteria andDoCtitleEqualTo(String value) {
            addCriterion("do_ctitle =", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleNotEqualTo(String value) {
            addCriterion("do_ctitle <>", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleGreaterThan(String value) {
            addCriterion("do_ctitle >", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleGreaterThanOrEqualTo(String value) {
            addCriterion("do_ctitle >=", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleLessThan(String value) {
            addCriterion("do_ctitle <", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleLessThanOrEqualTo(String value) {
            addCriterion("do_ctitle <=", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleLike(String value) {
            addCriterion("do_ctitle like", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleNotLike(String value) {
            addCriterion("do_ctitle not like", value, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleIn(List<String> values) {
            addCriterion("do_ctitle in", values, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleNotIn(List<String> values) {
            addCriterion("do_ctitle not in", values, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleBetween(String value1, String value2) {
            addCriterion("do_ctitle between", value1, value2, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andDoCtitleNotBetween(String value1, String value2) {
            addCriterion("do_ctitle not between", value1, value2, "doCtitle");
            return (Criteria) this;
        }

        public Criteria andMenuTopidIsNull() {
            addCriterion("menu_topid is null");
            return (Criteria) this;
        }

        public Criteria andMenuTopidIsNotNull() {
            addCriterion("menu_topid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTopidEqualTo(Integer value) {
            addCriterion("menu_topid =", value, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidNotEqualTo(Integer value) {
            addCriterion("menu_topid <>", value, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidGreaterThan(Integer value) {
            addCriterion("menu_topid >", value, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_topid >=", value, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidLessThan(Integer value) {
            addCriterion("menu_topid <", value, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidLessThanOrEqualTo(Integer value) {
            addCriterion("menu_topid <=", value, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidIn(List<Integer> values) {
            addCriterion("menu_topid in", values, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidNotIn(List<Integer> values) {
            addCriterion("menu_topid not in", values, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidBetween(Integer value1, Integer value2) {
            addCriterion("menu_topid between", value1, value2, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuTopidNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_topid not between", value1, value2, "menuTopid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidIsNull() {
            addCriterion("menu_leafid is null");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidIsNotNull() {
            addCriterion("menu_leafid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidEqualTo(Integer value) {
            addCriterion("menu_leafid =", value, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidNotEqualTo(Integer value) {
            addCriterion("menu_leafid <>", value, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidGreaterThan(Integer value) {
            addCriterion("menu_leafid >", value, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_leafid >=", value, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidLessThan(Integer value) {
            addCriterion("menu_leafid <", value, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidLessThanOrEqualTo(Integer value) {
            addCriterion("menu_leafid <=", value, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidIn(List<Integer> values) {
            addCriterion("menu_leafid in", values, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidNotIn(List<Integer> values) {
            addCriterion("menu_leafid not in", values, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidBetween(Integer value1, Integer value2) {
            addCriterion("menu_leafid between", value1, value2, "menuLeafid");
            return (Criteria) this;
        }

        public Criteria andMenuLeafidNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_leafid not between", value1, value2, "menuLeafid");
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