package cn.second.lhj.stuinfo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuInfoExample() {
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

        public Criteria andStuIntegralIsNull() {
            addCriterion("stu_integral is null");
            return (Criteria) this;
        }

        public Criteria andStuIntegralIsNotNull() {
            addCriterion("stu_integral is not null");
            return (Criteria) this;
        }

        public Criteria andStuIntegralEqualTo(Double value) {
            addCriterion("stu_integral =", value, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralNotEqualTo(Double value) {
            addCriterion("stu_integral <>", value, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralGreaterThan(Double value) {
            addCriterion("stu_integral >", value, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralGreaterThanOrEqualTo(Double value) {
            addCriterion("stu_integral >=", value, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralLessThan(Double value) {
            addCriterion("stu_integral <", value, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralLessThanOrEqualTo(Double value) {
            addCriterion("stu_integral <=", value, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralIn(List<Double> values) {
            addCriterion("stu_integral in", values, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralNotIn(List<Double> values) {
            addCriterion("stu_integral not in", values, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralBetween(Double value1, Double value2) {
            addCriterion("stu_integral between", value1, value2, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andStuIntegralNotBetween(Double value1, Double value2) {
            addCriterion("stu_integral not between", value1, value2, "stuIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralIsNull() {
            addCriterion("last_integral is null");
            return (Criteria) this;
        }

        public Criteria andLastIntegralIsNotNull() {
            addCriterion("last_integral is not null");
            return (Criteria) this;
        }

        public Criteria andLastIntegralEqualTo(Double value) {
            addCriterion("last_integral =", value, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralNotEqualTo(Double value) {
            addCriterion("last_integral <>", value, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralGreaterThan(Double value) {
            addCriterion("last_integral >", value, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralGreaterThanOrEqualTo(Double value) {
            addCriterion("last_integral >=", value, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralLessThan(Double value) {
            addCriterion("last_integral <", value, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralLessThanOrEqualTo(Double value) {
            addCriterion("last_integral <=", value, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralIn(List<Double> values) {
            addCriterion("last_integral in", values, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralNotIn(List<Double> values) {
            addCriterion("last_integral not in", values, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralBetween(Double value1, Double value2) {
            addCriterion("last_integral between", value1, value2, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andLastIntegralNotBetween(Double value1, Double value2) {
            addCriterion("last_integral not between", value1, value2, "lastIntegral");
            return (Criteria) this;
        }

        public Criteria andWriteTimeIsNull() {
            addCriterion("write_time is null");
            return (Criteria) this;
        }

        public Criteria andWriteTimeIsNotNull() {
            addCriterion("write_time is not null");
            return (Criteria) this;
        }

        public Criteria andWriteTimeEqualTo(Date value) {
            addCriterion("write_time =", value, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeNotEqualTo(Date value) {
            addCriterion("write_time <>", value, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeGreaterThan(Date value) {
            addCriterion("write_time >", value, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("write_time >=", value, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeLessThan(Date value) {
            addCriterion("write_time <", value, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeLessThanOrEqualTo(Date value) {
            addCriterion("write_time <=", value, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeIn(List<Date> values) {
            addCriterion("write_time in", values, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeNotIn(List<Date> values) {
            addCriterion("write_time not in", values, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeBetween(Date value1, Date value2) {
            addCriterion("write_time between", value1, value2, "writeTime");
            return (Criteria) this;
        }

        public Criteria andWriteTimeNotBetween(Date value1, Date value2) {
            addCriterion("write_time not between", value1, value2, "writeTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
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