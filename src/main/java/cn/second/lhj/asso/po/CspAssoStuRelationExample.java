package cn.second.lhj.asso.po;

import java.util.ArrayList;
import java.util.List;

public class CspAssoStuRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoStuRelationExample() {
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

        public Criteria andAssoIdIsNull() {
            addCriterion("asso_id is null");
            return (Criteria) this;
        }

        public Criteria andAssoIdIsNotNull() {
            addCriterion("asso_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssoIdEqualTo(String value) {
            addCriterion("asso_id =", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotEqualTo(String value) {
            addCriterion("asso_id <>", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThan(String value) {
            addCriterion("asso_id >", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdGreaterThanOrEqualTo(String value) {
            addCriterion("asso_id >=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThan(String value) {
            addCriterion("asso_id <", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLessThanOrEqualTo(String value) {
            addCriterion("asso_id <=", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdLike(String value) {
            addCriterion("asso_id like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotLike(String value) {
            addCriterion("asso_id not like", value, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdIn(List<String> values) {
            addCriterion("asso_id in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotIn(List<String> values) {
            addCriterion("asso_id not in", values, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdBetween(String value1, String value2) {
            addCriterion("asso_id between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoIdNotBetween(String value1, String value2) {
            addCriterion("asso_id not between", value1, value2, "assoId");
            return (Criteria) this;
        }

        public Criteria andAssoNameIsNull() {
            addCriterion("asso_name is null");
            return (Criteria) this;
        }

        public Criteria andAssoNameIsNotNull() {
            addCriterion("asso_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssoNameEqualTo(String value) {
            addCriterion("asso_name =", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotEqualTo(String value) {
            addCriterion("asso_name <>", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameGreaterThan(String value) {
            addCriterion("asso_name >", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameGreaterThanOrEqualTo(String value) {
            addCriterion("asso_name >=", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameLessThan(String value) {
            addCriterion("asso_name <", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameLessThanOrEqualTo(String value) {
            addCriterion("asso_name <=", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameLike(String value) {
            addCriterion("asso_name like", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotLike(String value) {
            addCriterion("asso_name not like", value, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameIn(List<String> values) {
            addCriterion("asso_name in", values, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotIn(List<String> values) {
            addCriterion("asso_name not in", values, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameBetween(String value1, String value2) {
            addCriterion("asso_name between", value1, value2, "assoName");
            return (Criteria) this;
        }

        public Criteria andAssoNameNotBetween(String value1, String value2) {
            addCriterion("asso_name not between", value1, value2, "assoName");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_id like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_id not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
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