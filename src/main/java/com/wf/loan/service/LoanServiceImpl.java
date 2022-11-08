package com.wf.loan.service;

import com.wf.loan.dao.CardDAO;
import com.wf.loan.dao.EmployeeIssueDetailsDao;
import com.wf.loan.dao.ItemDAO;
import com.wf.loan.dao.LoanDAO;
import com.wf.loan.model.Card;
import com.wf.loan.model.EmployeeIssueDetails;
import com.wf.loan.model.Item;
import com.wf.loan.model.Loan;
import com.wf.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    CardDAO cardDao;

    @Autowired
    LoanDAO loanDao;

	@Autowired
	private ItemDAO itemDao;
	
	@Autowired
	private EmployeeIssueDetailsDao employeeIssueDetailsDao;
	
	@Override
	public List<Loan> getAllLoans() {
		System.out.println(loanDao.findAll());
		return loanDao.findAll();
	}

	@Override
	public ResponseEntity<HttpStatus> processLoan(String empId, Item item) {
		try {
			List<Item> items = itemDao.getAvailableItems();
			int itemId = -1;
			for(Item currentItem : items) {
				if(currentItem.getItem_category().equals(currentItem.getItem_category()) && currentItem.getItem_description().equals(item.getItem_description())) {
					itemId = currentItem.getItem_id();
				}
			}
			if(itemId == -1) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			else {
				//save in employee issue table and employee card details table
				//find loan id from inventory
				
				List<Loan> loanMaster = getAllLoans();
				String loanId = null;
				for(Loan currLoan : loanMaster) {
					if(currLoan.getLoan_type().equals(item.getItem_category())) {
						loanId = currLoan.getLoan_id();
					}
				}
//			    public Card(String loan_id, String card_issue_date, String employee_id) {

				if(loanId != null) {
					employeeIssueDetailsDao.save(new EmployeeIssueDetails(empId, itemId));
					cardDao.save(new Card(loanId, CurrentDate.getCurrentDate(), empId));
				}
			}
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
		return itemDao.getAvailableItems();
	}
	
	
    @Override
    public List<Map<String,String>> viewLoan(String employee_id) {
        List<Card> cards=cardDao.findCardByEmployeeId(employee_id);
        List<Map<String,String>> result=new ArrayList<>();
        for(Card card: cards){
            Map<String,String> loanMap=new HashMap<String,String>();
            loanMap.put("card issue date",card.getCard_issue_date());
            Loan loan=loanDao.findCardByLoanId(card.getLoan_id());
            loanMap.put("loan type",loan.getLoan_type());
            loanMap.put("Duration in years",loan.getDuration_in_years()+"");
            result.add(loanMap);
        }
        return result;


    }
}
