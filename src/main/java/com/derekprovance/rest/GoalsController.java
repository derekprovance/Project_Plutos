package com.derekprovance.rest;

import com.derekprovance.data.UserSingleton;
import com.derekprovance.service.GoalsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GoalsController {

    @RequestMapping("/goals")
    public static Map<String,String> goalInformation() {
        GoalsService goalsService = new GoalsService(UserSingleton.getInstance().getUser());

        Map<String,String> payload = new HashMap<>();
        payload.put("rent", goalsService.getRentFormatted());
        payload.put("expenses", goalsService.getRemainingExpenseFormatted());
        payload.put("other", goalsService.getOtherGoalsFormatted());
        payload.put("pocket_change", goalsService.getPocketChangeFormatted());
        payload.put("loans", goalsService.getLoanExpenseFormatted());

        return payload;
    }

}
