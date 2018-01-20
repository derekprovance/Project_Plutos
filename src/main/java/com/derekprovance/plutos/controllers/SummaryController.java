package com.derekprovance.plutos.controllers;

import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.service.CalculateExpenseService;
import com.derekprovance.plutos.service.CalculateIncomeService;
import com.derekprovance.plutos.service.SummaryService;
import com.derekprovance.plutos.util.Formatters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SummaryController {

    //TODO - Too much logic in this controller. It brings shame on you sir
    @RequestMapping("/summary")
    public Map<String, String> generateSummary(@RequestParam(value="payPeriod", defaultValue="BI_WEEKLY") FinanceTimePeriod payPeriod) {
        CalculateIncomeService incomeService = new CalculateIncomeService(UserSingleton.getInstance().getUser());
        CalculateExpenseService expenseService = new CalculateExpenseService(UserSingleton.getInstance().getUser());

        Long totalIncome = incomeService.calculateIncome(payPeriod);
        Long totalExpense = expenseService.calculateExpenses(payPeriod);

        String totalIncomeHuman = Formatters.convertToStringCurrency(totalIncome);
        String totalExpenseHuman = Formatters.convertToStringCurrency(totalExpense);
        String totalEarningsHuman = Formatters.convertToStringCurrency(totalIncome - totalExpense);

        Map<String,String> payload = new HashMap<>();
        payload.put("period", payPeriod.toString());
        payload.put("income", totalIncomeHuman);
        payload.put("expense", totalExpenseHuman);
        payload.put("net_profit", totalEarningsHuman);

        return payload;
    }

    @RequestMapping("/daily")
    public static Map<String, Map<String, String>> generateDailySpend() {
        SummaryService service = new SummaryService();

        Map<String,Map<String, String>> payload = new HashMap<>();

        payload.put("info", service.prepareInfoPayload());
        payload.put("days", service.prepareDaySpendPayload());

        return payload;
    }
}