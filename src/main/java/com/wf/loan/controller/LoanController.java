package com.wf.loan.controller;

import com.wf.loan.service.LoanService;
import com.wf.loan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LoanController {
    @Autowired
    LoanService service;

    @PostMapping("/loan")
    public List<Map<String, String>> viewLoan(@RequestBody Map<String, String> userData ) {
        String id=userData.get("employee_id");
        List<Map<String, String>> result= service.viewLoan(id);
        return result;
    }
}
