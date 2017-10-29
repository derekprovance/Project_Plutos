package com.derekprovance.service;

import com.derekprovance.constants.FinanceTimePeriod;
import com.derekprovance.data.models.Income;
import com.derekprovance.data.models.User;
import com.derekprovance.repository.IncomeRepository;

import java.util.List;

public class CalculateIncomeService extends AbstractFinanceService {
    private User user;

    public CalculateIncomeService(User usr) {
        user = usr;
    }

    public Long calculateIncome() {
        return calculateIncome(FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateIncome(FinanceTimePeriod timePeriod) {
        final List<Income> incomes = IncomeRepository.getIncomesForUser(user.getId());
        return totalIncomes(incomes, timePeriod);
    }

    private Long totalIncomes(List<Income> incomes, FinanceTimePeriod period) {
        Long totalIncome = 0L;
        Double defaultBase = period.getMonthBase();

        for (Income income : incomes) {
            totalIncome += calculateMonthlyValue(income.getCycleUnit().getMonthBase(), income.getValue());
        }

        Long withholdings = calculateMonthlyValue(FinanceTimePeriod.BI_WEEKLY.getMonthBase(), user.getWitholdings());
        Long deductions = calculateMonthlyValue(FinanceTimePeriod.BI_WEEKLY.getMonthBase(), user.getDeductions());

        return calculateBase(defaultBase, totalIncome - withholdings - deductions);
    }
}
