package com.wf.loan.service;

import java.util.List;
import java.util.Map;


//import com.wf.loan.model.EmployeeDetails;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemService {
    List<Map<String,String>> viewItem(String employee_id);
}
