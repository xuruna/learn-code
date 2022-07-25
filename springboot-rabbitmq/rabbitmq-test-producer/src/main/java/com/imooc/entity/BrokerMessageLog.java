package com.imooc.entity;

import java.util.Date;

public class BrokerMessageLog {

    /**消息唯一id*/
    private String messageId;

    /**消息内容 序列化*/
    private String message;

    /**尝试次数*/
    private Integer tryCount = 0;

    /**消息投递状态 0投递中 1成功 2失败*/
    private String sataus;

    /**下一次重试时间 或者 超时时间*/
    private Date nextRetry;

    private Date createTime;

    private Date updateTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    public String getSataus() {
        return sataus;
    }

    public void setSataus(String sataus) {
        this.sataus = sataus;
    }

    public Date getNextRetry() {
        return nextRetry == null ? null : (Date)nextRetry.clone();
    }

    public void setNextRetry(Date nextRetry) {
        this.nextRetry = nextRetry == null ? null : (Date)nextRetry.clone();
    }

    public Date getCreateTime() {
        return createTime == null ? null : (Date)createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime == null ? null : (Date)createTime.clone();
    }

    public Date getUpdateTime() {
        return updateTime == null ? null : (Date)updateTime.clone();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime == null ? null : (Date)updateTime.clone();
    }
}
