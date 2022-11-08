package com.wf.loan.service;

import com.wf.loan.model.Item;
import com.wf.loan.model.Loan;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface LoanService {
    public List<Map<String,String>> viewLoan(String employee_id);
    
    public List<Loan> getAllLoans();
    
	public ResponseEntity<HttpStatus> processLoan(String empId, Item item);
	
	public List<Item> getItems();
}
