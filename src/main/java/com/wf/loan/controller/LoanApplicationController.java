package com.wf.loan.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wf.loan.model.Item;
import com.wf.loan.service.LoanApplicationService;

@RestController
public class LoanApplicationController { 

	@Autowired
	LoanApplicationService loanApplicationService;
	
	@GetMapping("/items")
	public List<Item> getItems(){
		return loanApplicationService.getItems();
	}
	
	@PostMapping("/loans")
	public ResponseEntity<HttpStatus> processLoan(@RequestBody Map<String, Item> loanData) {
		Item item = loanData.get("item");
		String employee_id ="";
		System.out.println("employee" + employee_id);
		System.out.println("item" + item);
		return loanApplicationService.processLoan(employee_id, item);
	}
		
}
