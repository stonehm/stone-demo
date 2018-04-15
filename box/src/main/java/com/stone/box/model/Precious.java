package com.stone.box.model;

import java.io.Serializable;

public class Precious implements Serializable {
    private String id;
    private String userId;
    private String activityId;
    private String activityType;
    private String preciousNo;
    private String score;
    private String preciousId;
    private String awardAmount;
    private Long unlockPeriod;
    private String unlockStatus;
    private Long unlockStartTime;
    private Long unlockEndTime;
    private Long createTime;
    private String limitRange;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getPreciousNo() {
        return preciousNo;
    }

    public void setPreciousNo(String preciousNo) {
        this.preciousNo = preciousNo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPreciousId() {
        return preciousId;
    }

    public void setPreciousId(String preciousId) {
        this.preciousId = preciousId;
    }

    public String getAwardAmount() {
        return awardAmount;
    }

    public void setAwardAmount(String awardAmount) {
        this.awardAmount = awardAmount;
    }

    public Long getUnlockPeriod() {
        return unlockPeriod;
    }

    public void setUnlockPeriod(Long unlockPeriod) {
        this.unlockPeriod = unlockPeriod;
    }

    public String getUnlockStatus() {
        return unlockStatus;
    }

    public void setUnlockStatus(String unlockStatus) {
        this.unlockStatus = unlockStatus;
    }

    public Long getUnlockStartTime() {
        return unlockStartTime;
    }

    public void setUnlockStartTime(Long unlockStartTime) {
        this.unlockStartTime = unlockStartTime;
    }

    public Long getUnlockEndTime() {
        return unlockEndTime;
    }

    public void setUnlockEndTime(Long unlockEndTime) {
        this.unlockEndTime = unlockEndTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getLimitRange() {
        return limitRange;
    }

    public void setLimitRange(String limitRange) {
        this.limitRange = limitRange;
    }

    @Override
    public String toString() {
        return "Precious{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", activityId='" + activityId + '\'' +
                ", activityType='" + activityType + '\'' +
                ", preciousNo='" + preciousNo + '\'' +
                ", score='" + score + '\'' +
                ", preciousId='" + preciousId + '\'' +
                ", awardAmount='" + awardAmount + '\'' +
                ", unlockPeriod='" + unlockPeriod + '\'' +
                ", unlockStatus='" + unlockStatus + '\'' +
                ", unlockStartTime='" + unlockStartTime + '\'' +
                ", unlockEndTime='" + unlockEndTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", limitRange='" + limitRange + '\'' +
                '}';
    }
}
