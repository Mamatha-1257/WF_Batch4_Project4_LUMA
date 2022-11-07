package com.wf.loan.service;

import com.wf.loan.dao.CardDAO;
import com.wf.loan.dao.LoanDAO;
import com.wf.loan.model.CardDetails;
import com.wf.loan.model.LoanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    CardDAO dao;

    @Autowired
    LoanDAO ldao;
    @Override
    public List<Map<String,String>> viewLoan(String employee_id) {
        List<CardDetails> cards=dao.findCardByEmployeeId(employee_id);
        List<Map<String,String>> result=new ArrayList<>();
        for(CardDetails card: cards){
            Map<String,String> loanMap=new HashMap<String,String>();
            loanMap.put("card issue date",card.getCard_issue_date());
            LoanDetails loan=ldao.findCardByLoanId(card.getLoan_id());
            loanMap.put("loan type",loan.getLoan_type());
            loanMap.put("Duration in years",loan.getDuration_in_years()+"");
            result.add(loanMap);
        }
        return result;


    }
}
