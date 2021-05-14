package com.example.lab1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanExample() {
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

        public Criteria andCustomerCodeIsNull() {
            addCriterion("customer_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNotNull() {
            addCriterion("customer_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeEqualTo(String value) {
            addCriterion("customer_code =", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotEqualTo(String value) {
            addCriterion("customer_code <>", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThan(String value) {
            addCriterion("customer_code >", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("customer_code >=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThan(String value) {
            addCriterion("customer_code <", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
            addCriterion("customer_code <=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLike(String value) {
            addCriterion("customer_code like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotLike(String value) {
            addCriterion("customer_code not like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIn(List<String> values) {
            addCriterion("customer_code in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotIn(List<String> values) {
            addCriterion("customer_code not in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeBetween(String value1, String value2) {
            addCriterion("customer_code between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotBetween(String value1, String value2) {
            addCriterion("customer_code not between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andAccountNumIsNull() {
            addCriterion("account_num is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumIsNotNull() {
            addCriterion("account_num is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumEqualTo(String value) {
            addCriterion("account_num =", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotEqualTo(String value) {
            addCriterion("account_num <>", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumGreaterThan(String value) {
            addCriterion("account_num >", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumGreaterThanOrEqualTo(String value) {
            addCriterion("account_num >=", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumLessThan(String value) {
            addCriterion("account_num <", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumLessThanOrEqualTo(String value) {
            addCriterion("account_num <=", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumLike(String value) {
            addCriterion("account_num like", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotLike(String value) {
            addCriterion("account_num not like", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumIn(List<String> values) {
            addCriterion("account_num in", values, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotIn(List<String> values) {
            addCriterion("account_num not in", values, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumBetween(String value1, String value2) {
            addCriterion("account_num between", value1, value2, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotBetween(String value1, String value2) {
            addCriterion("account_num not between", value1, value2, "accountNum");
            return (Criteria) this;
        }

        public Criteria andYearlyRateIsNull() {
            addCriterion("yearly_rate is null");
            return (Criteria) this;
        }

        public Criteria andYearlyRateIsNotNull() {
            addCriterion("yearly_rate is not null");
            return (Criteria) this;
        }

        public Criteria andYearlyRateEqualTo(Double value) {
            addCriterion("yearly_rate =", value, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateNotEqualTo(Double value) {
            addCriterion("yearly_rate <>", value, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateGreaterThan(Double value) {
            addCriterion("yearly_rate >", value, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateGreaterThanOrEqualTo(Double value) {
            addCriterion("yearly_rate >=", value, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateLessThan(Double value) {
            addCriterion("yearly_rate <", value, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateLessThanOrEqualTo(Double value) {
            addCriterion("yearly_rate <=", value, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateIn(List<Double> values) {
            addCriterion("yearly_rate in", values, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateNotIn(List<Double> values) {
            addCriterion("yearly_rate not in", values, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateBetween(Double value1, Double value2) {
            addCriterion("yearly_rate between", value1, value2, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andYearlyRateNotBetween(Double value1, Double value2) {
            addCriterion("yearly_rate not between", value1, value2, "yearlyRate");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountIsNull() {
            addCriterion("repayment_count is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountIsNotNull() {
            addCriterion("repayment_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountEqualTo(Integer value) {
            addCriterion("repayment_count =", value, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountNotEqualTo(Integer value) {
            addCriterion("repayment_count <>", value, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountGreaterThan(Integer value) {
            addCriterion("repayment_count >", value, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_count >=", value, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountLessThan(Integer value) {
            addCriterion("repayment_count <", value, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_count <=", value, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountIn(List<Integer> values) {
            addCriterion("repayment_count in", values, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountNotIn(List<Integer> values) {
            addCriterion("repayment_count not in", values, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountBetween(Integer value1, Integer value2) {
            addCriterion("repayment_count between", value1, value2, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andRepaymentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_count not between", value1, value2, "repaymentCount");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNull() {
            addCriterion("due_date is null");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNotNull() {
            addCriterion("due_date is not null");
            return (Criteria) this;
        }

        public Criteria andDueDateEqualTo(Date value) {
            addCriterionForJDBCDate("due_date =", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("due_date <>", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThan(Date value) {
            addCriterionForJDBCDate("due_date >", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("due_date >=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThan(Date value) {
            addCriterionForJDBCDate("due_date <", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("due_date <=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateIn(List<Date> values) {
            addCriterionForJDBCDate("due_date in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("due_date not in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("due_date between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("due_date not between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateIsNull() {
            addCriterion("loan_date is null");
            return (Criteria) this;
        }

        public Criteria andLoanDateIsNotNull() {
            addCriterion("loan_date is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDateEqualTo(Date value) {
            addCriterionForJDBCDate("loan_date =", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("loan_date <>", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateGreaterThan(Date value) {
            addCriterionForJDBCDate("loan_date >", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loan_date >=", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateLessThan(Date value) {
            addCriterionForJDBCDate("loan_date <", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loan_date <=", value, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateIn(List<Date> values) {
            addCriterionForJDBCDate("loan_date in", values, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("loan_date not in", values, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loan_date between", value1, value2, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loan_date not between", value1, value2, "loanDate");
            return (Criteria) this;
        }

        public Criteria andLoanCostIsNull() {
            addCriterion("loan_cost is null");
            return (Criteria) this;
        }

        public Criteria andLoanCostIsNotNull() {
            addCriterion("loan_cost is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCostEqualTo(Double value) {
            addCriterion("loan_cost =", value, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostNotEqualTo(Double value) {
            addCriterion("loan_cost <>", value, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostGreaterThan(Double value) {
            addCriterion("loan_cost >", value, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_cost >=", value, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostLessThan(Double value) {
            addCriterion("loan_cost <", value, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostLessThanOrEqualTo(Double value) {
            addCriterion("loan_cost <=", value, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostIn(List<Double> values) {
            addCriterion("loan_cost in", values, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostNotIn(List<Double> values) {
            addCriterion("loan_cost not in", values, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostBetween(Double value1, Double value2) {
            addCriterion("loan_cost between", value1, value2, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanCostNotBetween(Double value1, Double value2) {
            addCriterion("loan_cost not between", value1, value2, "loanCost");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNull() {
            addCriterion("loan_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("loan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(Double value) {
            addCriterion("loan_amount =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(Double value) {
            addCriterion("loan_amount <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(Double value) {
            addCriterion("loan_amount >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_amount >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(Double value) {
            addCriterion("loan_amount <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(Double value) {
            addCriterion("loan_amount <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<Double> values) {
            addCriterion("loan_amount in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<Double> values) {
            addCriterion("loan_amount not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(Double value1, Double value2) {
            addCriterion("loan_amount between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(Double value1, Double value2) {
            addCriterion("loan_amount not between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumIsNull() {
            addCriterion("institution_account_num is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumIsNotNull() {
            addCriterion("institution_account_num is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumEqualTo(String value) {
            addCriterion("institution_account_num =", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumNotEqualTo(String value) {
            addCriterion("institution_account_num <>", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumGreaterThan(String value) {
            addCriterion("institution_account_num >", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumGreaterThanOrEqualTo(String value) {
            addCriterion("institution_account_num >=", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumLessThan(String value) {
            addCriterion("institution_account_num <", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumLessThanOrEqualTo(String value) {
            addCriterion("institution_account_num <=", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumLike(String value) {
            addCriterion("institution_account_num like", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumNotLike(String value) {
            addCriterion("institution_account_num not like", value, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumIn(List<String> values) {
            addCriterion("institution_account_num in", values, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumNotIn(List<String> values) {
            addCriterion("institution_account_num not in", values, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumBetween(String value1, String value2) {
            addCriterion("institution_account_num between", value1, value2, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andInstitutionAccountNumNotBetween(String value1, String value2) {
            addCriterion("institution_account_num not between", value1, value2, "institutionAccountNum");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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