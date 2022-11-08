package com.wf.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_issue_details")
public class EmployeeIssueDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issue_id;

	@Column
	private String employee_id;
	
	@Column
	private int item_id;

	public EmployeeIssueDetails() {
		
	}
	
	public EmployeeIssueDetails(String employee_id, int item_id) {
		super();
		this.employee_id = employee_id;
		this.item_id = item_id;
	}

	public int getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "EmployeeIssueDetails [issue_id=" + issue_id + ", employee_id=" + employee_id + ", item_id=" + item_id
				+ "]";
	}
	
	
	
}
