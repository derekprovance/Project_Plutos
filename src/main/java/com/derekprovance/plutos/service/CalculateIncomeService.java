package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.data.models.Income;
import com.derekprovance.plutos.data.models.User;
import com.derekprovance.plutos.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateIncomeService extends AbstractFinanceService {

    @Autowired
    private IncomeRepository incomeRepository;


    public Long calculateIncome() {
        return calculateIncome(FinanceTimePeriod.BI_WEEKLY);
    }

    public Long calculateIncome(FinanceTimePeriod timePeriod) {
        final List<Income> incomes = incomeRepository.getIncomesForUser(UserSingleton.getInstance().getUser().getId());
        return totalIncomes(incomes, timePeriod);
    }

    private Long totalIncomes(List<Income> incomes, FinanceTimePeriod period) {
        Long totalIncome = 0L;
        Double defaultBase = period.getMonthBase();

        for (Income income : incomes) {
            totalIncome += calculateMonthlyValue(income.getCycleUnit().getMonthBase(), income.getValue());
        }

        Long withholdings = calculateMonthlyValue(FinanceTimePeriod.BI_WEEKLY.getMonthBase(), UserSingleton.getInstance().getUser().getWitholdings());
        Long deductions = calculateMonthlyValue(FinanceTimePeriod.BI_WEEKLY.getMonthBase(), UserSingleton.getInstance().getUser().getDeductions());

        return calculateBase(defaultBase, totalIncome - withholdings - deductions);
    }
}
