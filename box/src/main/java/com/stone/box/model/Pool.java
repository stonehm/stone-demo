package com.stone.box.model;

public class Pool {
    private Integer nextPoolSize;
    private Integer poolSize;
    private Integer poolLevel;
    private Integer requiredZoneLevel;
    private boolean nextPool;
    private Integer withdrawAmount;
    private Integer availAmount;
    private Integer curZoneLevel;
    private Integer upgradeAmount;

    public Integer getNextPoolSize() {
        return nextPoolSize;
    }

    public void setNextPoolSize(Integer nextPoolSize) {
        this.nextPoolSize = nextPoolSize;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public Integer getPoolLevel() {
        return poolLevel;
    }

    public void setPoolLevel(Integer poolLevel) {
        this.poolLevel = poolLevel;
    }

    public Integer getRequiredZoneLevel() {
        return requiredZoneLevel;
    }

    public void setRequiredZoneLevel(Integer requiredZoneLevel) {
        this.requiredZoneLevel = requiredZoneLevel;
    }

    public boolean isNextPool() {
        return nextPool;
    }

    public void setNextPool(boolean nextPool) {
        this.nextPool = nextPool;
    }

    public Integer getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Integer withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public Integer getAvailAmount() {
        return availAmount;
    }

    public void setAvailAmount(Integer availAmount) {
        this.availAmount = availAmount;
    }

    public Integer getCurZoneLevel() {
        return curZoneLevel;
    }

    public void setCurZoneLevel(Integer curZoneLevel) {
        this.curZoneLevel = curZoneLevel;
    }

    public Integer getUpgradeAmount() {
        return upgradeAmount;
    }

    public void setUpgradeAmount(Integer upgradeAmount) {
        this.upgradeAmount = upgradeAmount;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "nextPoolSize='" + nextPoolSize + '\'' +
                ", poolSize='" + poolSize + '\'' +
                ", poolLevel='" + poolLevel + '\'' +
                ", requiredZoneLevel='" + requiredZoneLevel + '\'' +
                ", nextPool=" + nextPool +
                ", withdrawAmount='" + withdrawAmount + '\'' +
                ", availAmount='" + availAmount + '\'' +
                ", curZoneLevel='" + curZoneLevel + '\'' +
                ", upgradeAmount='" + upgradeAmount + '\'' +
                '}';
    }
}
