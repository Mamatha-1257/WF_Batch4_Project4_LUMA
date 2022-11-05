package com.wf.loan.service;

import com.wf.loan.model.EmployeeDetails;

import javax.swing.text.html.Option;
import java.util.Optional;

 public interface LoginService {


     Optional<EmployeeDetails> validateLogin(String employee_id, String employee_password);
}
