package com.derekprovance.data.models;

import com.derekprovance.constants.FinanceTimePeriod;

public class Income {
    private Integer id;
    private Integer userId;
    private String source;
    private Long value;
    private FinanceTimePeriod cycleUnit;
    private Long expires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public FinanceTimePeriod getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(FinanceTimePeriod cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
