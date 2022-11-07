package com.wf.loan.controller;

import com.wf.loan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin("*")
@RestController
public class LoginController {
    @Autowired
    LoginService service;

    @PostMapping("/login")
    public boolean validateLogin(@RequestBody Map<String, String> userData ) {
        String id=userData.get("employee_id");
        String pass=userData.get("employee_password");
        return service.validateLogin(id,pass).isPresent();
    }
}
