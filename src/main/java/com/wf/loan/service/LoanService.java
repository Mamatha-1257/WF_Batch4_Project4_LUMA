package com.wf.loan.service;

import com.wf.loan.model.Item;
import com.wf.loan.model.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface LoanService {
    List<Map<String,String>> viewLoan(String employee_id);
    
    List<Loan> getAllLoans();
    
	ResponseEntity<HttpStatus> processLoan(String empId, Item item);
	
	List<Item> getItems();
}
