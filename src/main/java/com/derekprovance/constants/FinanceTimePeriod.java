package com.derekprovance.constants;

public enum FinanceTimePeriod {
    WEEKLY(0.25),
    BI_WEEKLY(0.5),
    MONTHLY(1),
    QUARTERLY(4),
    ANNUAL(12);

    private final double monthBase;

    FinanceTimePeriod(double monthBase) {
        this.monthBase = monthBase;
    }

    public double getMonthBase() { return monthBase; }
}
