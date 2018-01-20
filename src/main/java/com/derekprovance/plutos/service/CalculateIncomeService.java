package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.models.Income;
import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CalculateIncomeService extends AbstractFinanceService {
    private User user;

    @Autowired
    private IncomeRepository incomeRepository;

    public CalculateIncomeService(User usr) {
        user = usr;
    }

    public Long calculateIncome() {
        return calculateIncome(FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateIncome(FinanceTimePeriod timePeriod) {
        final List<Income> incomes = incomeRepository.getIncomesForUser(user.getId());
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
