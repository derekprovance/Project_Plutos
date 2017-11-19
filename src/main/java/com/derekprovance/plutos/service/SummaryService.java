package com.derekprovance.plutos.service;

import com.derekprovance.plutos.constants.FinanceTimePeriod;
import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.util.Formatters;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SummaryService extends AbstractFinanceService {
    public Map<String, String> prepareDaySpendPayload() {
        Map<String, String> payloadDay = new HashMap<>();

        Long biWeeklyPocketChange = UserSingleton.getInstance().getUser().getPocketChange();

        int lowerMinimal = getLowerMinimum();
        int upperMaximum = getUpperMaximum();

        int count = lowerMinimal;
        int baseCount = 1;
        while(count <= upperMaximum) {
            Long daySpend = biWeeklyPocketChange - calculateDailySpend(biWeeklyPocketChange, upperMaximum, lowerMinimal) * baseCount;
            payloadDay.put(String.valueOf(count), Formatters.convertToRoundedStringCurrency(daySpend));

            count++;
            baseCount++;
        }

        return payloadDay;
    }

    public Map<String, String> prepareInfoPayload() {
        Map<String, String> payloadInfo = new HashMap<>();
        Long biWeeklyPocketChange = UserSingleton.getInstance().getUser().getPocketChange();
        final Long dailySpend = calculateDailySpend(biWeeklyPocketChange, getUpperMaximum(), getLowerMinimum());

        payloadInfo.put("period", FinanceTimePeriod.BI_WEEKLY.toString());
        payloadInfo.put("daily_spend", Formatters.convertToRoundedStringCurrency(dailySpend));

        return payloadInfo;
    }

    private Long calculateDailySpend(Long biWeeklyPocketChange, int upperMaximum, int lowerMinimal) {
        return biWeeklyPocketChange / (upperMaximum - lowerMinimal + 1);
    }

    private boolean isFirstHalf() {
        return LocalDateTime.now().getDayOfMonth() < 15;
    }

    private int getLowerMinimum() {
        return isFirstHalf() ? 1 : (LocalDateTime.now().getMonth().maxLength() == 31 ? 17 : 16);
    }

    private int getUpperMaximum() {
        return isFirstHalf() ? (LocalDateTime.now().getMonth().maxLength() == 31 ? 16 : 15) : LocalDateTime.now().getMonth().maxLength();
    }
}
