package com.derekprovance.plutos.service;

public class AbstractFinanceService {
    protected static Long calculateMonthlyValue(Double monthBase, Long value) {
        return monthBase > 0 ? (long)(value / monthBase) : (long)(value * monthBase);
    }

    protected static Long calculateBase(Double monthBase, Long value) {
        return (long)(value * monthBase);
    }

    protected static boolean isBetween(Long x, Long lower, Long upper) {
        return lower <= x && x <= upper;
    }
}
