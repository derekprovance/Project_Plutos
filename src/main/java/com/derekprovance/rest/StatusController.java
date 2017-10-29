package com.derekprovance.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatusController {
    @RequestMapping("/status")
    public Map<String, String> greeting() {
        Map<String,String> status = new HashMap<>();
        status.put("status", "ok");

        return status;
    }
}
