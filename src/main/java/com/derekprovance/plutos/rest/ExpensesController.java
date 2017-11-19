package com.derekprovance.plutos.rest;

import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.data.models.Expenditure;
import com.derekprovance.plutos.repository.ExpenditureRepository;
import com.derekprovance.plutos.util.Formatters;
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
