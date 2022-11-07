package com.wf.loan.service;

import com.wf.loan.model.EmployeeDetails;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LoanService {
    List<Map<String,String>> viewLoan(String employee_id);
}
