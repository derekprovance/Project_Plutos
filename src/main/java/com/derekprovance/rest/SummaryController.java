package com.derekprovance.rest;

import com.derekprovance.constants.FinanceTimePeriod;
import com.derekprovance.data.UserSingleton;
import com.derekprovance.service.CalculateExpenseService;
import com.derekprovance.service.CalculateIncomeService;
import com.derekprovance.util.Formatters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SummaryController {

    @RequestMapping("/summary")
    public static Map<String, String> generateSummary(@RequestParam(value="payPeriod", defaultValue="BI_WEEKLY") FinanceTimePeriod payPeriod) {
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
        Map<String,Map<String, String>> payload = new HashMap<>();
        Map<String, String> payloadInfo = new HashMap<>();
        Map<String, String> payloadDay = new HashMap<>();

        final LocalDateTime today = LocalDateTime.now();
        Boolean firstHalf = today.getDayOfMonth() < 15;

        //TODO - Will need general spending after all other goal deductions

        int count = firstHalf ? 1 : 16;
        int baseCount = 1;
        while(count <= today.getMonth().maxLength()) {
            payloadDay.put(String.valueOf(count), "0");

            count++;
            baseCount++;
        }

        payloadInfo.put("period", FinanceTimePeriod.BI_WEEKLY.toString());
        payload.put("info", payloadInfo);

        payload.put("days", payloadDay);

        return payload;
    }
}