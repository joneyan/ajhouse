package com.aj.ajhouse.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AjQuestionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AjQuestionsExample() {
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

        public Criteria andQuesTitleIsNull() {
            addCriterion("ques_title is null");
            return (Criteria) this;
        }

        public Criteria andQuesTitleIsNotNull() {
            addCriterion("ques_title is not null");
            return (Criteria) this;
        }

        public Criteria andQuesTitleEqualTo(String value) {
            addCriterion("ques_title =", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotEqualTo(String value) {
            addCriterion("ques_title <>", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleGreaterThan(String value) {
            addCriterion("ques_title >", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ques_title >=", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleLessThan(String value) {
            addCriterion("ques_title <", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleLessThanOrEqualTo(String value) {
            addCriterion("ques_title <=", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleLike(String value) {
            addCriterion("ques_title like", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotLike(String value) {
            addCriterion("ques_title not like", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleIn(List<String> values) {
            addCriterion("ques_title in", values, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotIn(List<String> values) {
            addCriterion("ques_title not in", values, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleBetween(String value1, String value2) {
            addCriterion("ques_title between", value1, value2, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotBetween(String value1, String value2) {
            addCriterion("ques_title not between", value1, value2, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesContentIsNull() {
            addCriterion("ques_content is null");
            return (Criteria) this;
        }

        public Criteria andQuesContentIsNotNull() {
            addCriterion("ques_content is not null");
            return (Criteria) this;
        }

        public Criteria andQuesContentEqualTo(String value) {
            addCriterion("ques_content =", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentNotEqualTo(String value) {
            addCriterion("ques_content <>", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentGreaterThan(String value) {
            addCriterion("ques_content >", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentGreaterThanOrEqualTo(String value) {
            addCriterion("ques_content >=", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentLessThan(String value) {
            addCriterion("ques_content <", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentLessThanOrEqualTo(String value) {
            addCriterion("ques_content <=", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentLike(String value) {
            addCriterion("ques_content like", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentNotLike(String value) {
            addCriterion("ques_content not like", value, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentIn(List<String> values) {
            addCriterion("ques_content in", values, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentNotIn(List<String> values) {
            addCriterion("ques_content not in", values, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentBetween(String value1, String value2) {
            addCriterion("ques_content between", value1, value2, "quesContent");
            return (Criteria) this;
        }

        public Criteria andQuesContentNotBetween(String value1, String value2) {
            addCriterion("ques_content not between", value1, value2, "quesContent");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeIsNull() {
            addCriterion("solvetime is null");
            return (Criteria) this;
        }

        public Criteria andSolvetimeIsNotNull() {
            addCriterion("solvetime is not null");
            return (Criteria) this;
        }

        public Criteria andSolvetimeEqualTo(Date value) {
            addCriterion("solvetime =", value, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeNotEqualTo(Date value) {
            addCriterion("solvetime <>", value, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeGreaterThan(Date value) {
            addCriterion("solvetime >", value, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("solvetime >=", value, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeLessThan(Date value) {
            addCriterion("solvetime <", value, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeLessThanOrEqualTo(Date value) {
            addCriterion("solvetime <=", value, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeIn(List<Date> values) {
            addCriterion("solvetime in", values, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeNotIn(List<Date> values) {
            addCriterion("solvetime not in", values, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeBetween(Date value1, Date value2) {
            addCriterion("solvetime between", value1, value2, "solvetime");
            return (Criteria) this;
        }

        public Criteria andSolvetimeNotBetween(Date value1, Date value2) {
            addCriterion("solvetime not between", value1, value2, "solvetime");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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