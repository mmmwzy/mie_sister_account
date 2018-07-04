package com.mie.sa.entity;

import com.mie.base.core.entity.AbstractExample;
import com.mie.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillExample extends AbstractExample<Bill> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Bill> pageView = new PageView<Bill>(1, 10);

    private static final long serialVersionUID = 1L;

    public BillExample() {
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
    public PageView<Bill> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Bill> pageView) {
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

        public Criteria andBill_typeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBill_typeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBill_typeEqualTo(Byte value) {
            addCriterion("bill_type =", value, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeNotEqualTo(Byte value) {
            addCriterion("bill_type <>", value, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeGreaterThan(Byte value) {
            addCriterion("bill_type >", value, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_type >=", value, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeLessThan(Byte value) {
            addCriterion("bill_type <", value, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeLessThanOrEqualTo(Byte value) {
            addCriterion("bill_type <=", value, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeIn(List<Byte> values) {
            addCriterion("bill_type in", values, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeNotIn(List<Byte> values) {
            addCriterion("bill_type not in", values, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeBetween(Byte value1, Byte value2) {
            addCriterion("bill_type between", value1, value2, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_type not between", value1, value2, "bill_type");
            return (Criteria) this;
        }

        public Criteria andBill_describeIsNull() {
            addCriterion("bill_describe is null");
            return (Criteria) this;
        }

        public Criteria andBill_describeIsNotNull() {
            addCriterion("bill_describe is not null");
            return (Criteria) this;
        }

        public Criteria andBill_describeEqualTo(String value) {
            addCriterion("bill_describe =", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeNotEqualTo(String value) {
            addCriterion("bill_describe <>", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeGreaterThan(String value) {
            addCriterion("bill_describe >", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_describe >=", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeLessThan(String value) {
            addCriterion("bill_describe <", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeLessThanOrEqualTo(String value) {
            addCriterion("bill_describe <=", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeLike(String value) {
            addCriterion("bill_describe like", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeNotLike(String value) {
            addCriterion("bill_describe not like", value, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeIn(List<String> values) {
            addCriterion("bill_describe in", values, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeNotIn(List<String> values) {
            addCriterion("bill_describe not in", values, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeBetween(String value1, String value2) {
            addCriterion("bill_describe between", value1, value2, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_describeNotBetween(String value1, String value2) {
            addCriterion("bill_describe not between", value1, value2, "bill_describe");
            return (Criteria) this;
        }

        public Criteria andBill_amountIsNull() {
            addCriterion("bill_amount is null");
            return (Criteria) this;
        }

        public Criteria andBill_amountIsNotNull() {
            addCriterion("bill_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBill_amountEqualTo(BigDecimal value) {
            addCriterion("bill_amount =", value, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountNotEqualTo(BigDecimal value) {
            addCriterion("bill_amount <>", value, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountGreaterThan(BigDecimal value) {
            addCriterion("bill_amount >", value, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_amount >=", value, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountLessThan(BigDecimal value) {
            addCriterion("bill_amount <", value, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_amount <=", value, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountIn(List<BigDecimal> values) {
            addCriterion("bill_amount in", values, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountNotIn(List<BigDecimal> values) {
            addCriterion("bill_amount not in", values, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_amount between", value1, value2, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_amount not between", value1, value2, "bill_amount");
            return (Criteria) this;
        }

        public Criteria andBill_remarkIsNull() {
            addCriterion("bill_remark is null");
            return (Criteria) this;
        }

        public Criteria andBill_remarkIsNotNull() {
            addCriterion("bill_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBill_remarkEqualTo(String value) {
            addCriterion("bill_remark =", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkNotEqualTo(String value) {
            addCriterion("bill_remark <>", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkGreaterThan(String value) {
            addCriterion("bill_remark >", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("bill_remark >=", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkLessThan(String value) {
            addCriterion("bill_remark <", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkLessThanOrEqualTo(String value) {
            addCriterion("bill_remark <=", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkLike(String value) {
            addCriterion("bill_remark like", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkNotLike(String value) {
            addCriterion("bill_remark not like", value, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkIn(List<String> values) {
            addCriterion("bill_remark in", values, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkNotIn(List<String> values) {
            addCriterion("bill_remark not in", values, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkBetween(String value1, String value2) {
            addCriterion("bill_remark between", value1, value2, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_remarkNotBetween(String value1, String value2) {
            addCriterion("bill_remark not between", value1, value2, "bill_remark");
            return (Criteria) this;
        }

        public Criteria andBill_userIsNull() {
            addCriterion("bill_user is null");
            return (Criteria) this;
        }

        public Criteria andBill_userIsNotNull() {
            addCriterion("bill_user is not null");
            return (Criteria) this;
        }

        public Criteria andBill_userEqualTo(String value) {
            addCriterion("bill_user =", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userNotEqualTo(String value) {
            addCriterion("bill_user <>", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userGreaterThan(String value) {
            addCriterion("bill_user >", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userGreaterThanOrEqualTo(String value) {
            addCriterion("bill_user >=", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userLessThan(String value) {
            addCriterion("bill_user <", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userLessThanOrEqualTo(String value) {
            addCriterion("bill_user <=", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userLike(String value) {
            addCriterion("bill_user like", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userNotLike(String value) {
            addCriterion("bill_user not like", value, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userIn(List<String> values) {
            addCriterion("bill_user in", values, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userNotIn(List<String> values) {
            addCriterion("bill_user not in", values, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userBetween(String value1, String value2) {
            addCriterion("bill_user between", value1, value2, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_userNotBetween(String value1, String value2) {
            addCriterion("bill_user not between", value1, value2, "bill_user");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeIsNull() {
            addCriterion("bill_dispatch_type is null");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeIsNotNull() {
            addCriterion("bill_dispatch_type is not null");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeEqualTo(Byte value) {
            addCriterion("bill_dispatch_type =", value, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeNotEqualTo(Byte value) {
            addCriterion("bill_dispatch_type <>", value, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeGreaterThan(Byte value) {
            addCriterion("bill_dispatch_type >", value, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_type >=", value, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeLessThan(Byte value) {
            addCriterion("bill_dispatch_type <", value, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeLessThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_type <=", value, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeIn(List<Byte> values) {
            addCriterion("bill_dispatch_type in", values, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeNotIn(List<Byte> values) {
            addCriterion("bill_dispatch_type not in", values, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_type between", value1, value2, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_type not between", value1, value2, "bill_dispatch_type");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusIsNull() {
            addCriterion("bill_dispatch_status is null");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusIsNotNull() {
            addCriterion("bill_dispatch_status is not null");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusEqualTo(Byte value) {
            addCriterion("bill_dispatch_status =", value, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusNotEqualTo(Byte value) {
            addCriterion("bill_dispatch_status <>", value, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusGreaterThan(Byte value) {
            addCriterion("bill_dispatch_status >", value, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_status >=", value, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusLessThan(Byte value) {
            addCriterion("bill_dispatch_status <", value, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusLessThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_status <=", value, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusIn(List<Byte> values) {
            addCriterion("bill_dispatch_status in", values, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusNotIn(List<Byte> values) {
            addCriterion("bill_dispatch_status not in", values, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_status between", value1, value2, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_statusNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_status not between", value1, value2, "bill_dispatch_status");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderIsNull() {
            addCriterion("bill_dispatch_order is null");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderIsNotNull() {
            addCriterion("bill_dispatch_order is not null");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderEqualTo(String value) {
            addCriterion("bill_dispatch_order =", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderNotEqualTo(String value) {
            addCriterion("bill_dispatch_order <>", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderGreaterThan(String value) {
            addCriterion("bill_dispatch_order >", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderGreaterThanOrEqualTo(String value) {
            addCriterion("bill_dispatch_order >=", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderLessThan(String value) {
            addCriterion("bill_dispatch_order <", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderLessThanOrEqualTo(String value) {
            addCriterion("bill_dispatch_order <=", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderLike(String value) {
            addCriterion("bill_dispatch_order like", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderNotLike(String value) {
            addCriterion("bill_dispatch_order not like", value, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderIn(List<String> values) {
            addCriterion("bill_dispatch_order in", values, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderNotIn(List<String> values) {
            addCriterion("bill_dispatch_order not in", values, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderBetween(String value1, String value2) {
            addCriterion("bill_dispatch_order between", value1, value2, "bill_dispatch_order");
            return (Criteria) this;
        }

        public Criteria andBill_dispatch_orderNotBetween(String value1, String value2) {
            addCriterion("bill_dispatch_order not between", value1, value2, "bill_dispatch_order");
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