package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.FinanceTimePeriod;

public class CalculateEmergencyFund extends AbstractFinanceService {

    private static final Integer MONTH_AMT_FOR_EMERGENCY = 6;

    public static Long calculateEmergencyFund(Long monthlyExpense) {
        return calculateEmergencyFund(monthlyExpense, FinanceTimePeriod.MONTHLY);
    }

    public static Long calculateEmergencyFund(Long expense, FinanceTimePeriod timePeriod) {
        Long monthlyExpense = calculateMonthlyValue(timePeriod.getMonthBase(), expense);

        return monthlyExpense * MONTH_AMT_FOR_EMERGENCY;
    }
}
