package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.ExpenseType;
import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.util.Formatters;

public class GoalsService {
    private User user;

    private CalculateIncomeService incomeService;
    private CalculateExpenseService expenseService;

    public GoalsService(User user) {
        this.user = user;
        initializeServices();
    }

    private void initializeServices() {
        this.incomeService = new CalculateIncomeService(user);
        this.expenseService = new CalculateExpenseService(user);
    }

    public String getRentFormatted() {
        return Formatters.convertToStringCurrency(getHousingExpense());
    }

    public String getRemainingExpenseFormatted() {
        return Formatters.convertToStringCurrency(getRemainingExpenses());
    }

    public String getOtherGoalsFormatted() {
        return Formatters.convertToStringCurrency(getRemainingIncome());
    }

    public String getPocketChangeFormatted() {
        return Formatters.convertToStringCurrency(user.getPocketChange());
    }

    public String getLoanExpenseFormatted() {
        return Formatters.convertToStringCurrency(getLoansExpense());
    }

    private Long getHousingExpense() {
        return expenseService.calculateExpenseByCategory(ExpenseType.HOUSING);
    }

    private Long getLoansExpense() {
        return expenseService.calculateExpenseByCategory(ExpenseType.LOAN);
    }

    private Long getAllExpenses() {
        return expenseService.calculateExpenses();
    }

    private Long getRemainingExpenses() {
        return getAllExpenses() - getHousingExpense() - getLoansExpense();
    }

    private Long getRemainingIncome() {
        return incomeService.calculateIncome() - getAllExpenses() - user.getPocketChange();
    }
}
