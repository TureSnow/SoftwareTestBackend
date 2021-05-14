package com.example.lab1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RepayPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepayPlanExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andIouNumIsNull() {
            addCriterion("iou_num is null");
            return (Criteria) this;
        }

        public Criteria andIouNumIsNotNull() {
            addCriterion("iou_num is not null");
            return (Criteria) this;
        }

        public Criteria andIouNumEqualTo(String value) {
            addCriterion("iou_num =", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumNotEqualTo(String value) {
            addCriterion("iou_num <>", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumGreaterThan(String value) {
            addCriterion("iou_num >", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumGreaterThanOrEqualTo(String value) {
            addCriterion("iou_num >=", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumLessThan(String value) {
            addCriterion("iou_num <", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumLessThanOrEqualTo(String value) {
            addCriterion("iou_num <=", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumLike(String value) {
            addCriterion("iou_num like", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumNotLike(String value) {
            addCriterion("iou_num not like", value, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumIn(List<String> values) {
            addCriterion("iou_num in", values, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumNotIn(List<String> values) {
            addCriterion("iou_num not in", values, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumBetween(String value1, String value2) {
            addCriterion("iou_num between", value1, value2, "iouNum");
            return (Criteria) this;
        }

        public Criteria andIouNumNotBetween(String value1, String value2) {
            addCriterion("iou_num not between", value1, value2, "iouNum");
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

        public Criteria andPlanNumIsNull() {
            addCriterion("plan_num is null");
            return (Criteria) this;
        }

        public Criteria andPlanNumIsNotNull() {
            addCriterion("plan_num is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNumEqualTo(Double value) {
            addCriterion("plan_num =", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotEqualTo(Double value) {
            addCriterion("plan_num <>", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumGreaterThan(Double value) {
            addCriterion("plan_num >", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_num >=", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumLessThan(Double value) {
            addCriterion("plan_num <", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumLessThanOrEqualTo(Double value) {
            addCriterion("plan_num <=", value, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumIn(List<Double> values) {
            addCriterion("plan_num in", values, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotIn(List<Double> values) {
            addCriterion("plan_num not in", values, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumBetween(Double value1, Double value2) {
            addCriterion("plan_num between", value1, value2, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanNumNotBetween(Double value1, Double value2) {
            addCriterion("plan_num not between", value1, value2, "planNum");
            return (Criteria) this;
        }

        public Criteria andPlanAmountIsNull() {
            addCriterion("plan_amount is null");
            return (Criteria) this;
        }

        public Criteria andPlanAmountIsNotNull() {
            addCriterion("plan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPlanAmountEqualTo(Double value) {
            addCriterion("plan_amount =", value, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountNotEqualTo(Double value) {
            addCriterion("plan_amount <>", value, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountGreaterThan(Double value) {
            addCriterion("plan_amount >", value, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_amount >=", value, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountLessThan(Double value) {
            addCriterion("plan_amount <", value, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountLessThanOrEqualTo(Double value) {
            addCriterion("plan_amount <=", value, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountIn(List<Double> values) {
            addCriterion("plan_amount in", values, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountNotIn(List<Double> values) {
            addCriterion("plan_amount not in", values, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountBetween(Double value1, Double value2) {
            addCriterion("plan_amount between", value1, value2, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanAmountNotBetween(Double value1, Double value2) {
            addCriterion("plan_amount not between", value1, value2, "planAmount");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalIsNull() {
            addCriterion("plan_principal is null");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalIsNotNull() {
            addCriterion("plan_principal is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalEqualTo(Double value) {
            addCriterion("plan_principal =", value, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalNotEqualTo(Double value) {
            addCriterion("plan_principal <>", value, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalGreaterThan(Double value) {
            addCriterion("plan_principal >", value, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_principal >=", value, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalLessThan(Double value) {
            addCriterion("plan_principal <", value, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalLessThanOrEqualTo(Double value) {
            addCriterion("plan_principal <=", value, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalIn(List<Double> values) {
            addCriterion("plan_principal in", values, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalNotIn(List<Double> values) {
            addCriterion("plan_principal not in", values, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalBetween(Double value1, Double value2) {
            addCriterion("plan_principal between", value1, value2, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanPrincipalNotBetween(Double value1, Double value2) {
            addCriterion("plan_principal not between", value1, value2, "planPrincipal");
            return (Criteria) this;
        }

        public Criteria andPlanInterestIsNull() {
            addCriterion("plan_interest is null");
            return (Criteria) this;
        }

        public Criteria andPlanInterestIsNotNull() {
            addCriterion("plan_interest is not null");
            return (Criteria) this;
        }

        public Criteria andPlanInterestEqualTo(Double value) {
            addCriterion("plan_interest =", value, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestNotEqualTo(Double value) {
            addCriterion("plan_interest <>", value, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestGreaterThan(Double value) {
            addCriterion("plan_interest >", value, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestGreaterThanOrEqualTo(Double value) {
            addCriterion("plan_interest >=", value, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestLessThan(Double value) {
            addCriterion("plan_interest <", value, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestLessThanOrEqualTo(Double value) {
            addCriterion("plan_interest <=", value, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestIn(List<Double> values) {
            addCriterion("plan_interest in", values, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestNotIn(List<Double> values) {
            addCriterion("plan_interest not in", values, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestBetween(Double value1, Double value2) {
            addCriterion("plan_interest between", value1, value2, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanInterestNotBetween(Double value1, Double value2) {
            addCriterion("plan_interest not between", value1, value2, "planInterest");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNull() {
            addCriterion("plan_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNotNull() {
            addCriterion("plan_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDateEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date =", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date <>", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_date >", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date >=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThan(Date value) {
            addCriterionForJDBCDate("plan_date <", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date <=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateIn(List<Date> values) {
            addCriterionForJDBCDate("plan_date in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_date not in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_date between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_date not between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIsNull() {
            addCriterion("remain_amount is null");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIsNotNull() {
            addCriterion("remain_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRemainAmountEqualTo(Double value) {
            addCriterion("remain_amount =", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotEqualTo(Double value) {
            addCriterion("remain_amount <>", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountGreaterThan(Double value) {
            addCriterion("remain_amount >", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("remain_amount >=", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountLessThan(Double value) {
            addCriterion("remain_amount <", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountLessThanOrEqualTo(Double value) {
            addCriterion("remain_amount <=", value, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountIn(List<Double> values) {
            addCriterion("remain_amount in", values, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotIn(List<Double> values) {
            addCriterion("remain_amount not in", values, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountBetween(Double value1, Double value2) {
            addCriterion("remain_amount between", value1, value2, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainAmountNotBetween(Double value1, Double value2) {
            addCriterion("remain_amount not between", value1, value2, "remainAmount");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalIsNull() {
            addCriterion("remain_principal is null");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalIsNotNull() {
            addCriterion("remain_principal is not null");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalEqualTo(Double value) {
            addCriterion("remain_principal =", value, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalNotEqualTo(Double value) {
            addCriterion("remain_principal <>", value, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalGreaterThan(Double value) {
            addCriterion("remain_principal >", value, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalGreaterThanOrEqualTo(Double value) {
            addCriterion("remain_principal >=", value, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalLessThan(Double value) {
            addCriterion("remain_principal <", value, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalLessThanOrEqualTo(Double value) {
            addCriterion("remain_principal <=", value, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalIn(List<Double> values) {
            addCriterion("remain_principal in", values, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalNotIn(List<Double> values) {
            addCriterion("remain_principal not in", values, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalBetween(Double value1, Double value2) {
            addCriterion("remain_principal between", value1, value2, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainPrincipalNotBetween(Double value1, Double value2) {
            addCriterion("remain_principal not between", value1, value2, "remainPrincipal");
            return (Criteria) this;
        }

        public Criteria andRemainInterestIsNull() {
            addCriterion("remain_interest is null");
            return (Criteria) this;
        }

        public Criteria andRemainInterestIsNotNull() {
            addCriterion("remain_interest is not null");
            return (Criteria) this;
        }

        public Criteria andRemainInterestEqualTo(Double value) {
            addCriterion("remain_interest =", value, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestNotEqualTo(Double value) {
            addCriterion("remain_interest <>", value, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestGreaterThan(Double value) {
            addCriterion("remain_interest >", value, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestGreaterThanOrEqualTo(Double value) {
            addCriterion("remain_interest >=", value, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestLessThan(Double value) {
            addCriterion("remain_interest <", value, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestLessThanOrEqualTo(Double value) {
            addCriterion("remain_interest <=", value, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestIn(List<Double> values) {
            addCriterion("remain_interest in", values, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestNotIn(List<Double> values) {
            addCriterion("remain_interest not in", values, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestBetween(Double value1, Double value2) {
            addCriterion("remain_interest between", value1, value2, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andRemainInterestNotBetween(Double value1, Double value2) {
            addCriterion("remain_interest not between", value1, value2, "remainInterest");
            return (Criteria) this;
        }

        public Criteria andFineIsNull() {
            addCriterion("fine is null");
            return (Criteria) this;
        }

        public Criteria andFineIsNotNull() {
            addCriterion("fine is not null");
            return (Criteria) this;
        }

        public Criteria andFineEqualTo(Double value) {
            addCriterion("fine =", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotEqualTo(Double value) {
            addCriterion("fine <>", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThan(Double value) {
            addCriterion("fine >", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineGreaterThanOrEqualTo(Double value) {
            addCriterion("fine >=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThan(Double value) {
            addCriterion("fine <", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineLessThanOrEqualTo(Double value) {
            addCriterion("fine <=", value, "fine");
            return (Criteria) this;
        }

        public Criteria andFineIn(List<Double> values) {
            addCriterion("fine in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotIn(List<Double> values) {
            addCriterion("fine not in", values, "fine");
            return (Criteria) this;
        }

        public Criteria andFineBetween(Double value1, Double value2) {
            addCriterion("fine between", value1, value2, "fine");
            return (Criteria) this;
        }

        public Criteria andFineNotBetween(Double value1, Double value2) {
            addCriterion("fine not between", value1, value2, "fine");
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