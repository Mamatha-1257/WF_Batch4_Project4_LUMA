package com.wf.loan.controller;

import com.wf.loan.model.Item;
import com.wf.loan.model.Loan;
import com.wf.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        List<Loan> result= service.getAllLoans();
        return result;
    }
    
    @PostMapping("/loans")
    public List<Map<String, String>> viewLoan(@RequestBody Map<String, String> userData ) {
        String id=userData.get("employee_id");
        List<Map<String, String>> result= service.viewLoan(id);
        return result;
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
