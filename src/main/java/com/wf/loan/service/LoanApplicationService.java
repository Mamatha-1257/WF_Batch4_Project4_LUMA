package com.wf.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wf.loan.model.Item;

public interface LoanApplicationService {

	public ResponseEntity<HttpStatus> processLoan(String employeeId, Item item);
	
	public List<Item> getItems();
	
}
