package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.ExpenseType;
import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.util.Formatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalsService {

    @Autowired
    private CalculateIncomeService incomeService;

    @Autowired
    private CalculateExpenseService expenseService;

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
        return Formatters.convertToStringCurrency(UserSingleton.getInstance().getUser().getPocketChange());
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
        return incomeService.calculateIncome() - getAllExpenses() - UserSingleton.getInstance().getUser().getPocketChange();
    }
}
