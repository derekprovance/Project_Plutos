package com.derekprovance.plutos.controllers;

import com.derekprovance.plutos.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public Map<String,String> loginUser() {

        loginService.loginUser();

        Map<String,String> status = new HashMap<>();
        status.put("status", "ok");

        return status;
    }
}
