package cn.second.lhj.applykind.po;

import java.util.ArrayList;
import java.util.List;

public class ApplyKindExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyKindExample() {
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

        public Criteria andKindNameIsNull() {
            addCriterion("kind_name is null");
            return (Criteria) this;
        }

        public Criteria andKindNameIsNotNull() {
            addCriterion("kind_name is not null");
            return (Criteria) this;
        }

        public Criteria andKindNameEqualTo(String value) {
            addCriterion("kind_name =", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotEqualTo(String value) {
            addCriterion("kind_name <>", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameGreaterThan(String value) {
            addCriterion("kind_name >", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameGreaterThanOrEqualTo(String value) {
            addCriterion("kind_name >=", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLessThan(String value) {
            addCriterion("kind_name <", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLessThanOrEqualTo(String value) {
            addCriterion("kind_name <=", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLike(String value) {
            addCriterion("kind_name like", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotLike(String value) {
            addCriterion("kind_name not like", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameIn(List<String> values) {
            addCriterion("kind_name in", values, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotIn(List<String> values) {
            addCriterion("kind_name not in", values, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameBetween(String value1, String value2) {
            addCriterion("kind_name between", value1, value2, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotBetween(String value1, String value2) {
            addCriterion("kind_name not between", value1, value2, "kindName");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
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

        public Criteria andKindIntegralIsNull() {
            addCriterion("kind_integral is null");
            return (Criteria) this;
        }

        public Criteria andKindIntegralIsNotNull() {
            addCriterion("kind_integral is not null");
            return (Criteria) this;
        }

        public Criteria andKindIntegralEqualTo(Double value) {
            addCriterion("kind_integral =", value, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralNotEqualTo(Double value) {
            addCriterion("kind_integral <>", value, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralGreaterThan(Double value) {
            addCriterion("kind_integral >", value, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralGreaterThanOrEqualTo(Double value) {
            addCriterion("kind_integral >=", value, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralLessThan(Double value) {
            addCriterion("kind_integral <", value, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralLessThanOrEqualTo(Double value) {
            addCriterion("kind_integral <=", value, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralIn(List<Double> values) {
            addCriterion("kind_integral in", values, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralNotIn(List<Double> values) {
            addCriterion("kind_integral not in", values, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralBetween(Double value1, Double value2) {
            addCriterion("kind_integral between", value1, value2, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntegralNotBetween(Double value1, Double value2) {
            addCriterion("kind_integral not between", value1, value2, "kindIntegral");
            return (Criteria) this;
        }

        public Criteria andKindIntroIsNull() {
            addCriterion("kind_intro is null");
            return (Criteria) this;
        }

        public Criteria andKindIntroIsNotNull() {
            addCriterion("kind_intro is not null");
            return (Criteria) this;
        }

        public Criteria andKindIntroEqualTo(String value) {
            addCriterion("kind_intro =", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroNotEqualTo(String value) {
            addCriterion("kind_intro <>", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroGreaterThan(String value) {
            addCriterion("kind_intro >", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroGreaterThanOrEqualTo(String value) {
            addCriterion("kind_intro >=", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroLessThan(String value) {
            addCriterion("kind_intro <", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroLessThanOrEqualTo(String value) {
            addCriterion("kind_intro <=", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroLike(String value) {
            addCriterion("kind_intro like", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroNotLike(String value) {
            addCriterion("kind_intro not like", value, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroIn(List<String> values) {
            addCriterion("kind_intro in", values, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroNotIn(List<String> values) {
            addCriterion("kind_intro not in", values, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroBetween(String value1, String value2) {
            addCriterion("kind_intro between", value1, value2, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andKindIntroNotBetween(String value1, String value2) {
            addCriterion("kind_intro not between", value1, value2, "kindIntro");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocIsNull() {
            addCriterion("need_supp_doc is null");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocIsNotNull() {
            addCriterion("need_supp_doc is not null");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocEqualTo(Integer value) {
            addCriterion("need_supp_doc =", value, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocNotEqualTo(Integer value) {
            addCriterion("need_supp_doc <>", value, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocGreaterThan(Integer value) {
            addCriterion("need_supp_doc >", value, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_supp_doc >=", value, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocLessThan(Integer value) {
            addCriterion("need_supp_doc <", value, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocLessThanOrEqualTo(Integer value) {
            addCriterion("need_supp_doc <=", value, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocIn(List<Integer> values) {
            addCriterion("need_supp_doc in", values, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocNotIn(List<Integer> values) {
            addCriterion("need_supp_doc not in", values, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocBetween(Integer value1, Integer value2) {
            addCriterion("need_supp_doc between", value1, value2, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppDocNotBetween(Integer value1, Integer value2) {
            addCriterion("need_supp_doc not between", value1, value2, "needSuppDoc");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileIsNull() {
            addCriterion("need_supp_file is null");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileIsNotNull() {
            addCriterion("need_supp_file is not null");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileEqualTo(Integer value) {
            addCriterion("need_supp_file =", value, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileNotEqualTo(Integer value) {
            addCriterion("need_supp_file <>", value, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileGreaterThan(Integer value) {
            addCriterion("need_supp_file >", value, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_supp_file >=", value, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileLessThan(Integer value) {
            addCriterion("need_supp_file <", value, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileLessThanOrEqualTo(Integer value) {
            addCriterion("need_supp_file <=", value, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileIn(List<Integer> values) {
            addCriterion("need_supp_file in", values, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileNotIn(List<Integer> values) {
            addCriterion("need_supp_file not in", values, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileBetween(Integer value1, Integer value2) {
            addCriterion("need_supp_file between", value1, value2, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedSuppFileNotBetween(Integer value1, Integer value2) {
            addCriterion("need_supp_file not between", value1, value2, "needSuppFile");
            return (Criteria) this;
        }

        public Criteria andNeedCheckIsNull() {
            addCriterion("need_check is null");
            return (Criteria) this;
        }

        public Criteria andNeedCheckIsNotNull() {
            addCriterion("need_check is not null");
            return (Criteria) this;
        }

        public Criteria andNeedCheckEqualTo(Integer value) {
            addCriterion("need_check =", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckNotEqualTo(Integer value) {
            addCriterion("need_check <>", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckGreaterThan(Integer value) {
            addCriterion("need_check >", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_check >=", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckLessThan(Integer value) {
            addCriterion("need_check <", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckLessThanOrEqualTo(Integer value) {
            addCriterion("need_check <=", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckIn(List<Integer> values) {
            addCriterion("need_check in", values, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckNotIn(List<Integer> values) {
            addCriterion("need_check not in", values, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckBetween(Integer value1, Integer value2) {
            addCriterion("need_check between", value1, value2, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("need_check not between", value1, value2, "needCheck");
            return (Criteria) this;
        }

        public Criteria andCheckKindIsNull() {
            addCriterion("check_kind is null");
            return (Criteria) this;
        }

        public Criteria andCheckKindIsNotNull() {
            addCriterion("check_kind is not null");
            return (Criteria) this;
        }

        public Criteria andCheckKindEqualTo(Integer value) {
            addCriterion("check_kind =", value, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindNotEqualTo(Integer value) {
            addCriterion("check_kind <>", value, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindGreaterThan(Integer value) {
            addCriterion("check_kind >", value, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_kind >=", value, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindLessThan(Integer value) {
            addCriterion("check_kind <", value, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindLessThanOrEqualTo(Integer value) {
            addCriterion("check_kind <=", value, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindIn(List<Integer> values) {
            addCriterion("check_kind in", values, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindNotIn(List<Integer> values) {
            addCriterion("check_kind not in", values, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindBetween(Integer value1, Integer value2) {
            addCriterion("check_kind between", value1, value2, "checkKind");
            return (Criteria) this;
        }

        public Criteria andCheckKindNotBetween(Integer value1, Integer value2) {
            addCriterion("check_kind not between", value1, value2, "checkKind");
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