package cn.second.lhj.asso.po;

import java.util.ArrayList;
import java.util.List;

public class CspAssoGuiderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CspAssoGuiderExample() {
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

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(String value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(String value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(String value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(String value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(String value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLike(String value) {
            addCriterion("t_id like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotLike(String value) {
            addCriterion("t_id not like", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<String> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<String> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(String value1, String value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(String value1, String value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTNameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andTNameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andTNameEqualTo(String value) {
            addCriterion("t_name =", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThan(String value) {
            addCriterion("t_name >", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThan(String value) {
            addCriterion("t_name <", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLike(String value) {
            addCriterion("t_name like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotLike(String value) {
            addCriterion("t_name not like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameIn(List<String> values) {
            addCriterion("t_name in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTDepartmentIsNull() {
            addCriterion("t_department is null");
            return (Criteria) this;
        }

        public Criteria andTDepartmentIsNotNull() {
            addCriterion("t_department is not null");
            return (Criteria) this;
        }

        public Criteria andTDepartmentEqualTo(String value) {
            addCriterion("t_department =", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentNotEqualTo(String value) {
            addCriterion("t_department <>", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentGreaterThan(String value) {
            addCriterion("t_department >", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("t_department >=", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentLessThan(String value) {
            addCriterion("t_department <", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentLessThanOrEqualTo(String value) {
            addCriterion("t_department <=", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentLike(String value) {
            addCriterion("t_department like", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentNotLike(String value) {
            addCriterion("t_department not like", value, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentIn(List<String> values) {
            addCriterion("t_department in", values, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentNotIn(List<String> values) {
            addCriterion("t_department not in", values, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentBetween(String value1, String value2) {
            addCriterion("t_department between", value1, value2, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andTDepartmentNotBetween(String value1, String value2) {
            addCriterion("t_department not between", value1, value2, "tDepartment");
            return (Criteria) this;
        }

        public Criteria andAssoNumberIsNull() {
            addCriterion("asso_number is null");
            return (Criteria) this;
        }

        public Criteria andAssoNumberIsNotNull() {
            addCriterion("asso_number is not null");
            return (Criteria) this;
        }

        public Criteria andAssoNumberEqualTo(Integer value) {
            addCriterion("asso_number =", value, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberNotEqualTo(Integer value) {
            addCriterion("asso_number <>", value, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberGreaterThan(Integer value) {
            addCriterion("asso_number >", value, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("asso_number >=", value, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberLessThan(Integer value) {
            addCriterion("asso_number <", value, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberLessThanOrEqualTo(Integer value) {
            addCriterion("asso_number <=", value, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberIn(List<Integer> values) {
            addCriterion("asso_number in", values, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberNotIn(List<Integer> values) {
            addCriterion("asso_number not in", values, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberBetween(Integer value1, Integer value2) {
            addCriterion("asso_number between", value1, value2, "assoNumber");
            return (Criteria) this;
        }

        public Criteria andAssoNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("asso_number not between", value1, value2, "assoNumber");
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