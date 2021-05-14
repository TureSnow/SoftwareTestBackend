package com.example.lab1.entity;

import java.io.Serializable;
import java.util.Date;

public class RepayPlan implements Serializable {
    private Integer id;

    private String iouNum;

    private Date createTime;

    private Double planNum;

    private Double planAmount;

    private Double planPrincipal;

    private Double planInterest;

    private Date planDate;

    private Double remainAmount;

    private Double remainPrincipal;

    private Double remainInterest;

    private Double fine;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPlanNum() {
        return planNum;
    }

    public void setPlanNum(Double planNum) {
        this.planNum = planNum;
    }

    public Double getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(Double planAmount) {
        this.planAmount = planAmount;
    }

    public Double getPlanPrincipal() {
        return planPrincipal;
    }

    public void setPlanPrincipal(Double planPrincipal) {
        this.planPrincipal = planPrincipal;
    }

    public Double getPlanInterest() {
        return planInterest;
    }

    public void setPlanInterest(Double planInterest) {
        this.planInterest = planInterest;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Double getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Double remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Double getRemainPrincipal() {
        return remainPrincipal;
    }

    public void setRemainPrincipal(Double remainPrincipal) {
        this.remainPrincipal = remainPrincipal;
    }

    public Double getRemainInterest() {
        return remainInterest;
    }

    public void setRemainInterest(Double remainInterest) {
        this.remainInterest = remainInterest;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        RepayPlan other = (RepayPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIouNum() == null ? other.getIouNum() == null : this.getIouNum().equals(other.getIouNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPlanNum() == null ? other.getPlanNum() == null : this.getPlanNum().equals(other.getPlanNum()))
            && (this.getPlanAmount() == null ? other.getPlanAmount() == null : this.getPlanAmount().equals(other.getPlanAmount()))
            && (this.getPlanPrincipal() == null ? other.getPlanPrincipal() == null : this.getPlanPrincipal().equals(other.getPlanPrincipal()))
            && (this.getPlanInterest() == null ? other.getPlanInterest() == null : this.getPlanInterest().equals(other.getPlanInterest()))
            && (this.getPlanDate() == null ? other.getPlanDate() == null : this.getPlanDate().equals(other.getPlanDate()))
            && (this.getRemainAmount() == null ? other.getRemainAmount() == null : this.getRemainAmount().equals(other.getRemainAmount()))
            && (this.getRemainPrincipal() == null ? other.getRemainPrincipal() == null : this.getRemainPrincipal().equals(other.getRemainPrincipal()))
            && (this.getRemainInterest() == null ? other.getRemainInterest() == null : this.getRemainInterest().equals(other.getRemainInterest()))
            && (this.getFine() == null ? other.getFine() == null : this.getFine().equals(other.getFine()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIouNum() == null) ? 0 : getIouNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPlanNum() == null) ? 0 : getPlanNum().hashCode());
        result = prime * result + ((getPlanAmount() == null) ? 0 : getPlanAmount().hashCode());
        result = prime * result + ((getPlanPrincipal() == null) ? 0 : getPlanPrincipal().hashCode());
        result = prime * result + ((getPlanInterest() == null) ? 0 : getPlanInterest().hashCode());
        result = prime * result + ((getPlanDate() == null) ? 0 : getPlanDate().hashCode());
        result = prime * result + ((getRemainAmount() == null) ? 0 : getRemainAmount().hashCode());
        result = prime * result + ((getRemainPrincipal() == null) ? 0 : getRemainPrincipal().hashCode());
        result = prime * result + ((getRemainInterest() == null) ? 0 : getRemainInterest().hashCode());
        result = prime * result + ((getFine() == null) ? 0 : getFine().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", createTime=").append(createTime);
        sb.append(", planNum=").append(planNum);
        sb.append(", planAmount=").append(planAmount);
        sb.append(", planPrincipal=").append(planPrincipal);
        sb.append(", planInterest=").append(planInterest);
        sb.append(", planDate=").append(planDate);
        sb.append(", remainAmount=").append(remainAmount);
        sb.append(", remainPrincipal=").append(remainPrincipal);
        sb.append(", remainInterest=").append(remainInterest);
        sb.append(", fine=").append(fine);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}