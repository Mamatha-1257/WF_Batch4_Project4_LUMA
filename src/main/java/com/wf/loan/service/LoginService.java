package com.wf.loan.service;

import com.wf.loan.model.Employee;

import javax.swing.text.html.Option;
import java.util.Optional;

 public interface LoginService {
     Optional<Employee> validateLogin(String employee_id, String employee_password);
}
