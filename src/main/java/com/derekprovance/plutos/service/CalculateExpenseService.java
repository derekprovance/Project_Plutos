package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.ExpenseType;
import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.data.models.Expenditure;
import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateExpenseService extends AbstractFinanceService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    public Long calculateExpenses() {
        return calculateExpenses(FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateExpenses(FinanceTimePeriod timePeriod) {
        final List<Expenditure> expenditures = expenditureRepository.getAllExpenditures(UserSingleton.getInstance().getUser().getId());
        return totalExpenditures(expenditures, timePeriod);
    }

    public Long calculateExpenseByCategory(ExpenseType expenseType) {
        return calculateExpenseByCategory(expenseType, FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateExpenseByCategory(ExpenseType expenseType, FinanceTimePeriod timePeriod) {
        final List<Expenditure> expenditures = expenditureRepository.getExpendituresByCategory(UserSingleton.getInstance().getUser().getId(), expenseType);
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
