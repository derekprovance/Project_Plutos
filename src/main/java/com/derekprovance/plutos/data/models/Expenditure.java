package com.derekprovance.plutos.data.models;

import com.derekprovance.plutos.constants.ExpenseType;
import com.derekprovance.plutos.constants.FinanceTimePeriod;

public class Expenditure {
    private Integer id;
    private Integer userId;
    private String name;
    private Long value;
    private ExpenseType type;
    private FinanceTimePeriod cycleUnit;
    private Integer cycleAmt;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public FinanceTimePeriod getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(FinanceTimePeriod cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public Integer getCycleAmt() {
        return cycleAmt;
    }

    public void setCycleAmt(Integer cycleAmt) {
        this.cycleAmt = cycleAmt;
    }
}
