package com.wf.loan.service;

import com.wf.loan.dao.LoginDAO;
import com.wf.loan.model.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    LoginDAO dao;

    @Override
    public Optional<EmployeeDetails> validateLogin(String employee_id, String employee_password) {
        List<EmployeeDetails> user=dao.findEmployeeByIdAndPassword(employee_id,employee_password);
        if(!user.isEmpty()) return Optional.of(user.get(0));
        return Optional.empty();
//        return true;
    }
}
