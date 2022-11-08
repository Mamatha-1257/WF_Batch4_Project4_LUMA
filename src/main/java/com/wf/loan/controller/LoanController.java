package com.wf.loan.controller;

import com.wf.loan.model.Item;
import com.wf.loan.model.Loan;
import com.wf.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class LoanController {
    @Autowired
    LoanService service;

	@GetMapping("/items")
	public List<Item> getItems(){
		return service.getItems();
	}
	
	@GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }
    
    @PostMapping("/loans")
    public List<Map<String, String>> viewLoan(@RequestBody Map<String, String> userData ) {
        String id=userData.get("employee_id");
        return service.viewLoan(id);
    }
    
	@PostMapping("/applyloan")
	public ResponseEntity<HttpStatus> processLoan(@RequestBody Map<String, String> data) {
		//based on item details get item id 
		//populate employee issue details
		String empId = data.get("employee_id");
		String itemCategory = data.get("item_category");
	    String itemDescription = data.get("item_description");
	    String itemValuation = data.get("item_valuation");
	    String itemMake = data.get("item_make");
	    System.out.println(empId + itemMake);
	    Item item = new Item(itemCategory, itemDescription, Double.parseDouble(itemValuation), itemMake);
		return service.processLoan(empId, item);
	}
}
