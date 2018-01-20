package com.derekprovance.plutos.controllers;

import com.derekprovance.plutos.constants.FinanceTimePeriod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ExpensesController {

    @RequestMapping("/expenses")
    public Map<String,String> getAllExpenses(@RequestParam(value="payPeriod", defaultValue="BI_WEEKLY") FinanceTimePeriod payPeriod) {
        Map<String, String> payload = new HashMap<>();
        //TODO - too much logic in this controller. Disabled the interface
//        final List<Expenditure> allExpenditures = expenditureRepository.getAllExpenditures(UserSingleton.getInstance().getUser().getId());

//        allExpenditures.forEach(expenditure -> payload.put(expenditure.getName(), Formatters.convertToStringCurrency(expenditure.getValue())));
        return payload;
    }
}
