package com.example.lab1.entity;

import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable {
    private Integer id;

    private String iouNum;

    private String customerCode;

    private String accountNum;

    private Double yearlyRate;

    private Integer repaymentCount;

    private Date dueDate;

    private Date loanDate;

    private Double loanCost;

    private Double loanAmount;

    private String productCode;

    private String institutionAccountNum;

    private String name;

    private double dueBalance;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public double getDueBalance() {
        return dueBalance;
    }

    public void setDueBalance(double dueBalance) {
        this.dueBalance = dueBalance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIouNum() {
        return iouNum;
    }

    public void setIouNum(String iouNum) {
        this.iouNum = iouNum;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(Double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }

    public Integer getRepaymentCount() {
        return repaymentCount;
    }

    public void setRepaymentCount(Integer repaymentCount) {
        this.repaymentCount = repaymentCount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Double getLoanCost() {
        return loanCost;
    }

    public void setLoanCost(Double loanCost) {
        this.loanCost = loanCost;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getInstitutionAccountNum() {
        return institutionAccountNum;
    }

    public void setInstitutionAccountNum(String institutionAccountNum) {
        this.institutionAccountNum = institutionAccountNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Loan other = (Loan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIouNum() == null ? other.getIouNum() == null : this.getIouNum().equals(other.getIouNum()))
            && (this.getCustomerCode() == null ? other.getCustomerCode() == null : this.getCustomerCode().equals(other.getCustomerCode()))
            && (this.getAccountNum() == null ? other.getAccountNum() == null : this.getAccountNum().equals(other.getAccountNum()))
            && (this.getYearlyRate() == null ? other.getYearlyRate() == null : this.getYearlyRate().equals(other.getYearlyRate()))
            && (this.getRepaymentCount() == null ? other.getRepaymentCount() == null : this.getRepaymentCount().equals(other.getRepaymentCount()))
            && (this.getDueDate() == null ? other.getDueDate() == null : this.getDueDate().equals(other.getDueDate()))
            && (this.getLoanDate() == null ? other.getLoanDate() == null : this.getLoanDate().equals(other.getLoanDate()))
            && (this.getLoanCost() == null ? other.getLoanCost() == null : this.getLoanCost().equals(other.getLoanCost()))
            && (this.getLoanAmount() == null ? other.getLoanAmount() == null : this.getLoanAmount().equals(other.getLoanAmount()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getInstitutionAccountNum() == null ? other.getInstitutionAccountNum() == null : this.getInstitutionAccountNum().equals(other.getInstitutionAccountNum()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIouNum() == null) ? 0 : getIouNum().hashCode());
        result = prime * result + ((getCustomerCode() == null) ? 0 : getCustomerCode().hashCode());
        result = prime * result + ((getAccountNum() == null) ? 0 : getAccountNum().hashCode());
        result = prime * result + ((getYearlyRate() == null) ? 0 : getYearlyRate().hashCode());
        result = prime * result + ((getRepaymentCount() == null) ? 0 : getRepaymentCount().hashCode());
        result = prime * result + ((getDueDate() == null) ? 0 : getDueDate().hashCode());
        result = prime * result + ((getLoanDate() == null) ? 0 : getLoanDate().hashCode());
        result = prime * result + ((getLoanCost() == null) ? 0 : getLoanCost().hashCode());
        result = prime * result + ((getLoanAmount() == null) ? 0 : getLoanAmount().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getInstitutionAccountNum() == null) ? 0 : getInstitutionAccountNum().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", iouNum=").append(iouNum);
        sb.append(", customerCode=").append(customerCode);
        sb.append(", accountNum=").append(accountNum);
        sb.append(", yearlyRate=").append(yearlyRate);
        sb.append(", repaymentCount=").append(repaymentCount);
        sb.append(", dueDate=").append(dueDate);
        sb.append(", loanDate=").append(loanDate);
        sb.append(", loanCost=").append(loanCost);
        sb.append(", loanAmount=").append(loanAmount);
        sb.append(", productCode=").append(productCode);
        sb.append(", institutionAccountNum=").append(institutionAccountNum);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}