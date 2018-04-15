package com.stone.box.model;

public class Balloon {
    private String id;
    private String userId;
    private String amount;
    private String status;
    private String createTime;
    private String showTime;
    private String drawnTime;
    private String drawUserId;
    private String drawnBy;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getDrawnTime() {
        return drawnTime;
    }

    public void setDrawnTime(String drawnTime) {
        this.drawnTime = drawnTime;
    }

    public String getDrawUserId() {
        return drawUserId;
    }

    public void setDrawUserId(String drawUserId) {
        this.drawUserId = drawUserId;
    }

    public String getDrawnBy() {
        return drawnBy;
    }

    public void setDrawnBy(String drawnBy) {
        this.drawnBy = drawnBy;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", showTime='" + showTime + '\'' +
                ", drawnTime='" + drawnTime + '\'' +
                ", drawUserId='" + drawUserId + '\'' +
                ", drawnBy='" + drawnBy + '\'' +
                '}';
    }
}