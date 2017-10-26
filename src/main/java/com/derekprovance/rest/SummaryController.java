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

        payloadInfo.put("period", FinanceTimePeriod.BI_WEEKLY.toString());
        payload.put("info", payloadInfo);

        payload.put("days", prepareDaySpendPayload());

        return payload;
    }

    private static Map<String, String> prepareDaySpendPayload() {
        Map<String, String> payloadDay = new HashMap<>();

        Long biWeeklyPocketChange = UserSingleton.getInstance().getUser().getPocketChange();

        final LocalDateTime today = LocalDateTime.now();
        Boolean firstHalf = today.getDayOfMonth() < 15;

        int lowerMinimal = firstHalf ? 1 : (today.getMonth().maxLength() == 31 ? 17 : 16);
        int upperMaximum = firstHalf ? (today.getMonth().maxLength() == 31 ? 16 : 15) : today.getMonth().maxLength();

        int count = lowerMinimal;
        int baseCount = 1;
        while(count <= upperMaximum) {
            Long daySpend = biWeeklyPocketChange - ((biWeeklyPocketChange / (upperMaximum - lowerMinimal + 1)) * baseCount);
            payloadDay.put(String.valueOf(count), Formatters.convertToStringCurrency(daySpend));

            count++;
            baseCount++;
        }

        return payloadDay;
    }
}