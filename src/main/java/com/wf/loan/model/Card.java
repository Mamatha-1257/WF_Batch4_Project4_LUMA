package com.wf.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="employee_card_details")
public class Card {


    @Id
    @Column
    String loan_id;
    
    @Column
    String card_issue_date;
    
    @Column
    String employee_id;

    public Card() {
    }

    public Card(String loan_id, String card_issue_date, String employee_id) {
        this.loan_id = loan_id;
        this.card_issue_date = card_issue_date;
        this.employee_id = employee_id;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getCard_issue_date() {
        return card_issue_date;
    }

    public void setCard_issue_date(String card_issue_date) {
        this.card_issue_date = card_issue_date;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
