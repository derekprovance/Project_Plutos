package com.derekprovance.plutos.rest;

import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.data.models.Income;
import com.derekprovance.plutos.repository.IncomeRepository;
import com.derekprovance.plutos.util.Formatters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IncomesController {
    @RequestMapping("/incomes")
    public static Map<String,String> getAllIncomes() {
        Map<String, String> payload = new HashMap<>();
        final List<Income> incomes = IncomeRepository.getIncomesForUser(UserSingleton.getInstance().getUser().getId());

        incomes.forEach(income -> {
            payload.put(income.getSource(), Formatters.convertToStringCurrency(income.getValue()));
        });

        return payload;
    }
}
