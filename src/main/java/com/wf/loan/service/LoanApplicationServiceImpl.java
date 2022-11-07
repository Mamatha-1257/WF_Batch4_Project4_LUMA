package com.wf.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wf.loan.dao.ItemDAO;
import com.wf.loan.model.Item;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	private ItemDAO dao;
	
	@Override
	public ResponseEntity<HttpStatus> processLoan(String employeeId, Item item) {
		// TODO Auto-generated method stub
		try {
			System.out.println(item);
			dao.save(item);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			    
		}
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return dao.getAvailableItems();
	}
	
	
}
