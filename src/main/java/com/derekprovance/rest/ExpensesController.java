package com.derekprovance.rest;

import com.derekprovance.data.UserSingleton;
import com.derekprovance.data.models.Expenditure;
import com.derekprovance.repository.ExpenditureRepository;
import com.derekprovance.util.Formatters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExpensesController {
    @RequestMapping("/expenses")
    public static Map<String,String> getAllExpenses() {
        Map<String, String> payload = new HashMap<>();
        final List<Expenditure> allExpenditures = ExpenditureRepository.getAllExpenditures(UserSingleton.getInstance().getUser().getId());

        allExpenditures.forEach(expenditure -> payload.put(expenditure.getName(), Formatters.convertToStringCurrency(expenditure.getValue())));
        return payload;
    }
}
