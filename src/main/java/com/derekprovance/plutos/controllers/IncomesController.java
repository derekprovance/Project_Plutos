package com.derekprovance.plutos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IncomesController {
    @RequestMapping("/incomes")
    public Map<String,String> getAllIncomes() {
        //TODO - implement in service and not this controller
        Map<String, String> payload = new HashMap<>();
//        final List<Income> incomes = IncomeRepository.getIncomesForUser(UserSingleton.getInstance().getUser().getId());
//
//        incomes.forEach(income -> {
//            payload.put(income.getSource(), Formatters.convertToStringCurrency(income.getValue()));
//        });

        return payload;
    }
}
