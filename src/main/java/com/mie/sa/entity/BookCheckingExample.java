package com.mie.sa.entity;

import com.mie.base.core.entity.AbstractExample;
import com.mie.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookCheckingExample extends AbstractExample<BookChecking> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<BookChecking> pageView = new PageView<BookChecking>(1, 10);

    private static final long serialVersionUID = 1L;

    public BookCheckingExample() {
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

    @Override
    public PageView<BookChecking> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<BookChecking> pageView) {
        this.pageView = pageView;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        private static final long serialVersionUID = 1L;

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

        public Criteria andBook_idIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBook_idIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBook_idEqualTo(String value) {
            addCriterion("book_id =", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idNotEqualTo(String value) {
            addCriterion("book_id <>", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idGreaterThan(String value) {
            addCriterion("book_id >", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idGreaterThanOrEqualTo(String value) {
            addCriterion("book_id >=", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idLessThan(String value) {
            addCriterion("book_id <", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idLessThanOrEqualTo(String value) {
            addCriterion("book_id <=", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idLike(String value) {
            addCriterion("book_id like", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idNotLike(String value) {
            addCriterion("book_id not like", value, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idIn(List<String> values) {
            addCriterion("book_id in", values, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idNotIn(List<String> values) {
            addCriterion("book_id not in", values, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idBetween(String value1, String value2) {
            addCriterion("book_id between", value1, value2, "book_id");
            return (Criteria) this;
        }

        public Criteria andBook_idNotBetween(String value1, String value2) {
            addCriterion("book_id not between", value1, value2, "book_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idIsNull() {
            addCriterion("apply_user_id is null");
            return (Criteria) this;
        }

        public Criteria andApply_user_idIsNotNull() {
            addCriterion("apply_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andApply_user_idEqualTo(String value) {
            addCriterion("apply_user_id =", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idNotEqualTo(String value) {
            addCriterion("apply_user_id <>", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idGreaterThan(String value) {
            addCriterion("apply_user_id >", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user_id >=", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idLessThan(String value) {
            addCriterion("apply_user_id <", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idLessThanOrEqualTo(String value) {
            addCriterion("apply_user_id <=", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idLike(String value) {
            addCriterion("apply_user_id like", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idNotLike(String value) {
            addCriterion("apply_user_id not like", value, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idIn(List<String> values) {
            addCriterion("apply_user_id in", values, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idNotIn(List<String> values) {
            addCriterion("apply_user_id not in", values, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idBetween(String value1, String value2) {
            addCriterion("apply_user_id between", value1, value2, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andApply_user_idNotBetween(String value1, String value2) {
            addCriterion("apply_user_id not between", value1, value2, "apply_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idIsNull() {
            addCriterion("check_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idIsNotNull() {
            addCriterion("check_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idEqualTo(String value) {
            addCriterion("check_user_id =", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idNotEqualTo(String value) {
            addCriterion("check_user_id <>", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idGreaterThan(String value) {
            addCriterion("check_user_id >", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idGreaterThanOrEqualTo(String value) {
            addCriterion("check_user_id >=", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idLessThan(String value) {
            addCriterion("check_user_id <", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idLessThanOrEqualTo(String value) {
            addCriterion("check_user_id <=", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idLike(String value) {
            addCriterion("check_user_id like", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idNotLike(String value) {
            addCriterion("check_user_id not like", value, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idIn(List<String> values) {
            addCriterion("check_user_id in", values, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idNotIn(List<String> values) {
            addCriterion("check_user_id not in", values, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idBetween(String value1, String value2) {
            addCriterion("check_user_id between", value1, value2, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_user_idNotBetween(String value1, String value2) {
            addCriterion("check_user_id not between", value1, value2, "check_user_id");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceIsNull() {
            addCriterion("check_alipay_balance is null");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceIsNotNull() {
            addCriterion("check_alipay_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceEqualTo(BigDecimal value) {
            addCriterion("check_alipay_balance =", value, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceNotEqualTo(BigDecimal value) {
            addCriterion("check_alipay_balance <>", value, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceGreaterThan(BigDecimal value) {
            addCriterion("check_alipay_balance >", value, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("check_alipay_balance >=", value, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceLessThan(BigDecimal value) {
            addCriterion("check_alipay_balance <", value, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("check_alipay_balance <=", value, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceIn(List<BigDecimal> values) {
            addCriterion("check_alipay_balance in", values, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceNotIn(List<BigDecimal> values) {
            addCriterion("check_alipay_balance not in", values, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_alipay_balance between", value1, value2, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_alipay_balanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_alipay_balance not between", value1, value2, "check_alipay_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_statusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheck_statusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_statusEqualTo(Byte value) {
            addCriterion("check_status =", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusNotEqualTo(Byte value) {
            addCriterion("check_status <>", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusGreaterThan(Byte value) {
            addCriterion("check_status >", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_status >=", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusLessThan(Byte value) {
            addCriterion("check_status <", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusLessThanOrEqualTo(Byte value) {
            addCriterion("check_status <=", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusIn(List<Byte> values) {
            addCriterion("check_status in", values, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusNotIn(List<Byte> values) {
            addCriterion("check_status not in", values, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusBetween(Byte value1, Byte value2) {
            addCriterion("check_status between", value1, value2, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusNotBetween(Byte value1, Byte value2) {
            addCriterion("check_status not between", value1, value2, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceIsNull() {
            addCriterion("check_balance is null");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceIsNotNull() {
            addCriterion("check_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceEqualTo(BigDecimal value) {
            addCriterion("check_balance =", value, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceNotEqualTo(BigDecimal value) {
            addCriterion("check_balance <>", value, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceGreaterThan(BigDecimal value) {
            addCriterion("check_balance >", value, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("check_balance >=", value, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceLessThan(BigDecimal value) {
            addCriterion("check_balance <", value, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("check_balance <=", value, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceIn(List<BigDecimal> values) {
            addCriterion("check_balance in", values, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceNotIn(List<BigDecimal> values) {
            addCriterion("check_balance not in", values, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_balance between", value1, value2, "check_balance");
            return (Criteria) this;
        }

        public Criteria andCheck_balanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_balance not between", value1, value2, "check_balance");
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

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "is_delete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        private static final long serialVersionUID = 1L;

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