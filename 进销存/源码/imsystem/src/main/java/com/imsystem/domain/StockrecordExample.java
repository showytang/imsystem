package com.imsystem.domain;

import java.util.ArrayList;
import java.util.List;

public class StockrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockrecordExample() {
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

        public Criteria andAftersdidIsNull() {
            addCriterion("aftersdid is null");
            return (Criteria) this;
        }

        public Criteria andAftersdidIsNotNull() {
            addCriterion("aftersdid is not null");
            return (Criteria) this;
        }

        public Criteria andAftersdidEqualTo(String value) {
            addCriterion("aftersdid =", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidNotEqualTo(String value) {
            addCriterion("aftersdid <>", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidGreaterThan(String value) {
            addCriterion("aftersdid >", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidGreaterThanOrEqualTo(String value) {
            addCriterion("aftersdid >=", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidLessThan(String value) {
            addCriterion("aftersdid <", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidLessThanOrEqualTo(String value) {
            addCriterion("aftersdid <=", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidLike(String value) {
            addCriterion("aftersdid like", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidNotLike(String value) {
            addCriterion("aftersdid not like", value, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidIn(List<String> values) {
            addCriterion("aftersdid in", values, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidNotIn(List<String> values) {
            addCriterion("aftersdid not in", values, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidBetween(String value1, String value2) {
            addCriterion("aftersdid between", value1, value2, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andAftersdidNotBetween(String value1, String value2) {
            addCriterion("aftersdid not between", value1, value2, "aftersdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidIsNull() {
            addCriterion("beforesdid is null");
            return (Criteria) this;
        }

        public Criteria andBeforesdidIsNotNull() {
            addCriterion("beforesdid is not null");
            return (Criteria) this;
        }

        public Criteria andBeforesdidEqualTo(String value) {
            addCriterion("beforesdid =", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidNotEqualTo(String value) {
            addCriterion("beforesdid <>", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidGreaterThan(String value) {
            addCriterion("beforesdid >", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidGreaterThanOrEqualTo(String value) {
            addCriterion("beforesdid >=", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidLessThan(String value) {
            addCriterion("beforesdid <", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidLessThanOrEqualTo(String value) {
            addCriterion("beforesdid <=", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidLike(String value) {
            addCriterion("beforesdid like", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidNotLike(String value) {
            addCriterion("beforesdid not like", value, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidIn(List<String> values) {
            addCriterion("beforesdid in", values, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidNotIn(List<String> values) {
            addCriterion("beforesdid not in", values, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidBetween(String value1, String value2) {
            addCriterion("beforesdid between", value1, value2, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andBeforesdidNotBetween(String value1, String value2) {
            addCriterion("beforesdid not between", value1, value2, "beforesdid");
            return (Criteria) this;
        }

        public Criteria andAftersidIsNull() {
            addCriterion("aftersid is null");
            return (Criteria) this;
        }

        public Criteria andAftersidIsNotNull() {
            addCriterion("aftersid is not null");
            return (Criteria) this;
        }

        public Criteria andAftersidEqualTo(String value) {
            addCriterion("aftersid =", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidNotEqualTo(String value) {
            addCriterion("aftersid <>", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidGreaterThan(String value) {
            addCriterion("aftersid >", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidGreaterThanOrEqualTo(String value) {
            addCriterion("aftersid >=", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidLessThan(String value) {
            addCriterion("aftersid <", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidLessThanOrEqualTo(String value) {
            addCriterion("aftersid <=", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidLike(String value) {
            addCriterion("aftersid like", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidNotLike(String value) {
            addCriterion("aftersid not like", value, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidIn(List<String> values) {
            addCriterion("aftersid in", values, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidNotIn(List<String> values) {
            addCriterion("aftersid not in", values, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidBetween(String value1, String value2) {
            addCriterion("aftersid between", value1, value2, "aftersid");
            return (Criteria) this;
        }

        public Criteria andAftersidNotBetween(String value1, String value2) {
            addCriterion("aftersid not between", value1, value2, "aftersid");
            return (Criteria) this;
        }

        public Criteria andBeforesidIsNull() {
            addCriterion("beforesid is null");
            return (Criteria) this;
        }

        public Criteria andBeforesidIsNotNull() {
            addCriterion("beforesid is not null");
            return (Criteria) this;
        }

        public Criteria andBeforesidEqualTo(String value) {
            addCriterion("beforesid =", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidNotEqualTo(String value) {
            addCriterion("beforesid <>", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidGreaterThan(String value) {
            addCriterion("beforesid >", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidGreaterThanOrEqualTo(String value) {
            addCriterion("beforesid >=", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidLessThan(String value) {
            addCriterion("beforesid <", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidLessThanOrEqualTo(String value) {
            addCriterion("beforesid <=", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidLike(String value) {
            addCriterion("beforesid like", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidNotLike(String value) {
            addCriterion("beforesid not like", value, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidIn(List<String> values) {
            addCriterion("beforesid in", values, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidNotIn(List<String> values) {
            addCriterion("beforesid not in", values, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidBetween(String value1, String value2) {
            addCriterion("beforesid between", value1, value2, "beforesid");
            return (Criteria) this;
        }

        public Criteria andBeforesidNotBetween(String value1, String value2) {
            addCriterion("beforesid not between", value1, value2, "beforesid");
            return (Criteria) this;
        }

        public Criteria andColumn1IsNull() {
            addCriterion("column1 is null");
            return (Criteria) this;
        }

        public Criteria andColumn1IsNotNull() {
            addCriterion("column1 is not null");
            return (Criteria) this;
        }

        public Criteria andColumn1EqualTo(String value) {
            addCriterion("column1 =", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1NotEqualTo(String value) {
            addCriterion("column1 <>", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1GreaterThan(String value) {
            addCriterion("column1 >", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1GreaterThanOrEqualTo(String value) {
            addCriterion("column1 >=", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1LessThan(String value) {
            addCriterion("column1 <", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1LessThanOrEqualTo(String value) {
            addCriterion("column1 <=", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1Like(String value) {
            addCriterion("column1 like", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1NotLike(String value) {
            addCriterion("column1 not like", value, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1In(List<String> values) {
            addCriterion("column1 in", values, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1NotIn(List<String> values) {
            addCriterion("column1 not in", values, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1Between(String value1, String value2) {
            addCriterion("column1 between", value1, value2, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn1NotBetween(String value1, String value2) {
            addCriterion("column1 not between", value1, value2, "column1");
            return (Criteria) this;
        }

        public Criteria andColumn2IsNull() {
            addCriterion("column2 is null");
            return (Criteria) this;
        }

        public Criteria andColumn2IsNotNull() {
            addCriterion("column2 is not null");
            return (Criteria) this;
        }

        public Criteria andColumn2EqualTo(String value) {
            addCriterion("column2 =", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2NotEqualTo(String value) {
            addCriterion("column2 <>", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2GreaterThan(String value) {
            addCriterion("column2 >", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2GreaterThanOrEqualTo(String value) {
            addCriterion("column2 >=", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2LessThan(String value) {
            addCriterion("column2 <", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2LessThanOrEqualTo(String value) {
            addCriterion("column2 <=", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2Like(String value) {
            addCriterion("column2 like", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2NotLike(String value) {
            addCriterion("column2 not like", value, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2In(List<String> values) {
            addCriterion("column2 in", values, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2NotIn(List<String> values) {
            addCriterion("column2 not in", values, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2Between(String value1, String value2) {
            addCriterion("column2 between", value1, value2, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn2NotBetween(String value1, String value2) {
            addCriterion("column2 not between", value1, value2, "column2");
            return (Criteria) this;
        }

        public Criteria andColumn3IsNull() {
            addCriterion("column3 is null");
            return (Criteria) this;
        }

        public Criteria andColumn3IsNotNull() {
            addCriterion("column3 is not null");
            return (Criteria) this;
        }

        public Criteria andColumn3EqualTo(String value) {
            addCriterion("column3 =", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3NotEqualTo(String value) {
            addCriterion("column3 <>", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3GreaterThan(String value) {
            addCriterion("column3 >", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3GreaterThanOrEqualTo(String value) {
            addCriterion("column3 >=", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3LessThan(String value) {
            addCriterion("column3 <", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3LessThanOrEqualTo(String value) {
            addCriterion("column3 <=", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3Like(String value) {
            addCriterion("column3 like", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3NotLike(String value) {
            addCriterion("column3 not like", value, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3In(List<String> values) {
            addCriterion("column3 in", values, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3NotIn(List<String> values) {
            addCriterion("column3 not in", values, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3Between(String value1, String value2) {
            addCriterion("column3 between", value1, value2, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn3NotBetween(String value1, String value2) {
            addCriterion("column3 not between", value1, value2, "column3");
            return (Criteria) this;
        }

        public Criteria andColumn4IsNull() {
            addCriterion("column4 is null");
            return (Criteria) this;
        }

        public Criteria andColumn4IsNotNull() {
            addCriterion("column4 is not null");
            return (Criteria) this;
        }

        public Criteria andColumn4EqualTo(String value) {
            addCriterion("column4 =", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4NotEqualTo(String value) {
            addCriterion("column4 <>", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4GreaterThan(String value) {
            addCriterion("column4 >", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4GreaterThanOrEqualTo(String value) {
            addCriterion("column4 >=", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4LessThan(String value) {
            addCriterion("column4 <", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4LessThanOrEqualTo(String value) {
            addCriterion("column4 <=", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4Like(String value) {
            addCriterion("column4 like", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4NotLike(String value) {
            addCriterion("column4 not like", value, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4In(List<String> values) {
            addCriterion("column4 in", values, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4NotIn(List<String> values) {
            addCriterion("column4 not in", values, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4Between(String value1, String value2) {
            addCriterion("column4 between", value1, value2, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn4NotBetween(String value1, String value2) {
            addCriterion("column4 not between", value1, value2, "column4");
            return (Criteria) this;
        }

        public Criteria andColumn5IsNull() {
            addCriterion("column5 is null");
            return (Criteria) this;
        }

        public Criteria andColumn5IsNotNull() {
            addCriterion("column5 is not null");
            return (Criteria) this;
        }

        public Criteria andColumn5EqualTo(String value) {
            addCriterion("column5 =", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5NotEqualTo(String value) {
            addCriterion("column5 <>", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5GreaterThan(String value) {
            addCriterion("column5 >", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5GreaterThanOrEqualTo(String value) {
            addCriterion("column5 >=", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5LessThan(String value) {
            addCriterion("column5 <", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5LessThanOrEqualTo(String value) {
            addCriterion("column5 <=", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5Like(String value) {
            addCriterion("column5 like", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5NotLike(String value) {
            addCriterion("column5 not like", value, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5In(List<String> values) {
            addCriterion("column5 in", values, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5NotIn(List<String> values) {
            addCriterion("column5 not in", values, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5Between(String value1, String value2) {
            addCriterion("column5 between", value1, value2, "column5");
            return (Criteria) this;
        }

        public Criteria andColumn5NotBetween(String value1, String value2) {
            addCriterion("column5 not between", value1, value2, "column5");
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