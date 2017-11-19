package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.ExpenseType;
import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.models.Expenditure;
import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.repository.ExpenditureRepository;

import java.util.List;

public class CalculateExpenseService extends AbstractFinanceService {
    private User user;

    public CalculateExpenseService(User user) {
        this.user = user;
    }

    public Long calculateExpenses() {
        return calculateExpenses(FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateExpenses(FinanceTimePeriod timePeriod) {
        final List<Expenditure> expenditures = ExpenditureRepository.getAllExpenditures(user.getId());
        return totalExpenditures(expenditures, timePeriod);
    }

    public Long calculateExpenseByCategory(ExpenseType expenseType) {
        return calculateExpenseByCategory(expenseType, FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateExpenseByCategory(ExpenseType expenseType, FinanceTimePeriod timePeriod) {
        final List<Expenditure> expenditures = ExpenditureRepository.getExpendituresByCategory(user.getId(), expenseType);
        return totalExpenditures(expenditures, timePeriod);
    }

    private Long totalExpenditures(List<Expenditure> expenses, FinanceTimePeriod period) {
        Long totalExpense = 0L;
        Double defaultBase = period.getMonthBase();

        for (Expenditure expense : expenses) {
            Double monthAmt = expense.getCycleUnit().getMonthBase() * expense.getCycleAmt();
            Long monthlyValue = calculateMonthlyValue(expense.getCycleUnit().getMonthBase(), expense.getValue());

            totalExpense += applyMonthAmt(monthlyValue, monthAmt, expense.getCycleAmt());
        }

        return calculateBase(defaultBase, totalExpense);
    }

    private Long applyMonthAmt(Long monthlyValue, Double monthAmt, Integer cycleAmt) {
        if(cycleAmt == 1) { return monthlyValue; }

        return (monthAmt < 1) ? (long)(monthlyValue * (1 - monthAmt)) : (long)(monthlyValue / monthAmt);
    }
}
