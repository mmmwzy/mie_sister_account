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

        public Criteria andBillContextTypeIsNull() {
            addCriterion("bill_context_type is null");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeIsNotNull() {
            addCriterion("bill_context_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeEqualTo(Byte value) {
            addCriterion("bill_context_type =", value, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeNotEqualTo(Byte value) {
            addCriterion("bill_context_type <>", value, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeGreaterThan(Byte value) {
            addCriterion("bill_context_type >", value, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_context_type >=", value, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeLessThan(Byte value) {
            addCriterion("bill_context_type <", value, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bill_context_type <=", value, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeIn(List<Byte> values) {
            addCriterion("bill_context_type in", values, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeNotIn(List<Byte> values) {
            addCriterion("bill_context_type not in", values, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeBetween(Byte value1, Byte value2) {
            addCriterion("bill_context_type between", value1, value2, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillContextTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_context_type not between", value1, value2, "billContextType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(Byte value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(Byte value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(Byte value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(Byte value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<Byte> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<Byte> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(Byte value1, Byte value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillDescribeIsNull() {
            addCriterion("bill_describe is null");
            return (Criteria) this;
        }

        public Criteria andBillDescribeIsNotNull() {
            addCriterion("bill_describe is not null");
            return (Criteria) this;
        }

        public Criteria andBillDescribeEqualTo(String value) {
            addCriterion("bill_describe =", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeNotEqualTo(String value) {
            addCriterion("bill_describe <>", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeGreaterThan(String value) {
            addCriterion("bill_describe >", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_describe >=", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeLessThan(String value) {
            addCriterion("bill_describe <", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeLessThanOrEqualTo(String value) {
            addCriterion("bill_describe <=", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeLike(String value) {
            addCriterion("bill_describe like", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeNotLike(String value) {
            addCriterion("bill_describe not like", value, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeIn(List<String> values) {
            addCriterion("bill_describe in", values, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeNotIn(List<String> values) {
            addCriterion("bill_describe not in", values, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeBetween(String value1, String value2) {
            addCriterion("bill_describe between", value1, value2, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillDescribeNotBetween(String value1, String value2) {
            addCriterion("bill_describe not between", value1, value2, "billDescribe");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNull() {
            addCriterion("bill_amount is null");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNotNull() {
            addCriterion("bill_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBillAmountEqualTo(BigDecimal value) {
            addCriterion("bill_amount =", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotEqualTo(BigDecimal value) {
            addCriterion("bill_amount <>", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThan(BigDecimal value) {
            addCriterion("bill_amount >", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_amount >=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThan(BigDecimal value) {
            addCriterion("bill_amount <", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_amount <=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountIn(List<BigDecimal> values) {
            addCriterion("bill_amount in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotIn(List<BigDecimal> values) {
            addCriterion("bill_amount not in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_amount between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_amount not between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillRemarkIsNull() {
            addCriterion("bill_remark is null");
            return (Criteria) this;
        }

        public Criteria andBillRemarkIsNotNull() {
            addCriterion("bill_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBillRemarkEqualTo(String value) {
            addCriterion("bill_remark =", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotEqualTo(String value) {
            addCriterion("bill_remark <>", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkGreaterThan(String value) {
            addCriterion("bill_remark >", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bill_remark >=", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkLessThan(String value) {
            addCriterion("bill_remark <", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkLessThanOrEqualTo(String value) {
            addCriterion("bill_remark <=", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkLike(String value) {
            addCriterion("bill_remark like", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotLike(String value) {
            addCriterion("bill_remark not like", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkIn(List<String> values) {
            addCriterion("bill_remark in", values, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotIn(List<String> values) {
            addCriterion("bill_remark not in", values, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkBetween(String value1, String value2) {
            addCriterion("bill_remark between", value1, value2, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotBetween(String value1, String value2) {
            addCriterion("bill_remark not between", value1, value2, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillUserNameIsNull() {
            addCriterion("bill_user_name is null");
            return (Criteria) this;
        }

        public Criteria andBillUserNameIsNotNull() {
            addCriterion("bill_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andBillUserNameEqualTo(String value) {
            addCriterion("bill_user_name =", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameNotEqualTo(String value) {
            addCriterion("bill_user_name <>", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameGreaterThan(String value) {
            addCriterion("bill_user_name >", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("bill_user_name >=", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameLessThan(String value) {
            addCriterion("bill_user_name <", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameLessThanOrEqualTo(String value) {
            addCriterion("bill_user_name <=", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameLike(String value) {
            addCriterion("bill_user_name like", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameNotLike(String value) {
            addCriterion("bill_user_name not like", value, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameIn(List<String> values) {
            addCriterion("bill_user_name in", values, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameNotIn(List<String> values) {
            addCriterion("bill_user_name not in", values, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameBetween(String value1, String value2) {
            addCriterion("bill_user_name between", value1, value2, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserNameNotBetween(String value1, String value2) {
            addCriterion("bill_user_name not between", value1, value2, "billUserName");
            return (Criteria) this;
        }

        public Criteria andBillUserIdIsNull() {
            addCriterion("bill_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBillUserIdIsNotNull() {
            addCriterion("bill_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillUserIdEqualTo(String value) {
            addCriterion("bill_user_id =", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdNotEqualTo(String value) {
            addCriterion("bill_user_id <>", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdGreaterThan(String value) {
            addCriterion("bill_user_id >", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_user_id >=", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdLessThan(String value) {
            addCriterion("bill_user_id <", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdLessThanOrEqualTo(String value) {
            addCriterion("bill_user_id <=", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdLike(String value) {
            addCriterion("bill_user_id like", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdNotLike(String value) {
            addCriterion("bill_user_id not like", value, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdIn(List<String> values) {
            addCriterion("bill_user_id in", values, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdNotIn(List<String> values) {
            addCriterion("bill_user_id not in", values, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdBetween(String value1, String value2) {
            addCriterion("bill_user_id between", value1, value2, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillUserIdNotBetween(String value1, String value2) {
            addCriterion("bill_user_id not between", value1, value2, "billUserId");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeIsNull() {
            addCriterion("bill_dispatch_type is null");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeIsNotNull() {
            addCriterion("bill_dispatch_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeEqualTo(Byte value) {
            addCriterion("bill_dispatch_type =", value, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeNotEqualTo(Byte value) {
            addCriterion("bill_dispatch_type <>", value, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeGreaterThan(Byte value) {
            addCriterion("bill_dispatch_type >", value, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_type >=", value, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeLessThan(Byte value) {
            addCriterion("bill_dispatch_type <", value, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_type <=", value, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeIn(List<Byte> values) {
            addCriterion("bill_dispatch_type in", values, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeNotIn(List<Byte> values) {
            addCriterion("bill_dispatch_type not in", values, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_type between", value1, value2, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_type not between", value1, value2, "billDispatchType");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusIsNull() {
            addCriterion("bill_dispatch_status is null");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusIsNotNull() {
            addCriterion("bill_dispatch_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusEqualTo(Byte value) {
            addCriterion("bill_dispatch_status =", value, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusNotEqualTo(Byte value) {
            addCriterion("bill_dispatch_status <>", value, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusGreaterThan(Byte value) {
            addCriterion("bill_dispatch_status >", value, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_status >=", value, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusLessThan(Byte value) {
            addCriterion("bill_dispatch_status <", value, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusLessThanOrEqualTo(Byte value) {
            addCriterion("bill_dispatch_status <=", value, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusIn(List<Byte> values) {
            addCriterion("bill_dispatch_status in", values, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusNotIn(List<Byte> values) {
            addCriterion("bill_dispatch_status not in", values, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_status between", value1, value2, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_dispatch_status not between", value1, value2, "billDispatchStatus");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderIsNull() {
            addCriterion("bill_dispatch_order is null");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderIsNotNull() {
            addCriterion("bill_dispatch_order is not null");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderEqualTo(String value) {
            addCriterion("bill_dispatch_order =", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderNotEqualTo(String value) {
            addCriterion("bill_dispatch_order <>", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderGreaterThan(String value) {
            addCriterion("bill_dispatch_order >", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderGreaterThanOrEqualTo(String value) {
            addCriterion("bill_dispatch_order >=", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderLessThan(String value) {
            addCriterion("bill_dispatch_order <", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderLessThanOrEqualTo(String value) {
            addCriterion("bill_dispatch_order <=", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderLike(String value) {
            addCriterion("bill_dispatch_order like", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderNotLike(String value) {
            addCriterion("bill_dispatch_order not like", value, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderIn(List<String> values) {
            addCriterion("bill_dispatch_order in", values, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderNotIn(List<String> values) {
            addCriterion("bill_dispatch_order not in", values, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderBetween(String value1, String value2) {
            addCriterion("bill_dispatch_order between", value1, value2, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDispatchOrderNotBetween(String value1, String value2) {
            addCriterion("bill_dispatch_order not between", value1, value2, "billDispatchOrder");
            return (Criteria) this;
        }

        public Criteria andBillDataViewIsNull() {
            addCriterion("bill_data_view is null");
            return (Criteria) this;
        }

        public Criteria andBillDataViewIsNotNull() {
            addCriterion("bill_data_view is not null");
            return (Criteria) this;
        }

        public Criteria andBillDataViewEqualTo(String value) {
            addCriterion("bill_data_view =", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewNotEqualTo(String value) {
            addCriterion("bill_data_view <>", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewGreaterThan(String value) {
            addCriterion("bill_data_view >", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewGreaterThanOrEqualTo(String value) {
            addCriterion("bill_data_view >=", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewLessThan(String value) {
            addCriterion("bill_data_view <", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewLessThanOrEqualTo(String value) {
            addCriterion("bill_data_view <=", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewLike(String value) {
            addCriterion("bill_data_view like", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewNotLike(String value) {
            addCriterion("bill_data_view not like", value, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewIn(List<String> values) {
            addCriterion("bill_data_view in", values, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewNotIn(List<String> values) {
            addCriterion("bill_data_view not in", values, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewBetween(String value1, String value2) {
            addCriterion("bill_data_view between", value1, value2, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDataViewNotBetween(String value1, String value2) {
            addCriterion("bill_data_view not between", value1, value2, "billDataView");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNull() {
            addCriterion("bill_date is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(Date value) {
            addCriterion("bill_date =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(Date value) {
            addCriterion("bill_date <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(Date value) {
            addCriterion("bill_date >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_date >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(Date value) {
            addCriterion("bill_date <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(Date value) {
            addCriterion("bill_date <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<Date> values) {
            addCriterion("bill_date in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<Date> values) {
            addCriterion("bill_date not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(Date value1, Date value2) {
            addCriterion("bill_date between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(Date value1, Date value2) {
            addCriterion("bill_date not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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