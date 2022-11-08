package com.wf.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wf.loan.model.EmployeeIssueDetails;

public interface EmployeeIssueDetailsDao extends JpaRepository<EmployeeIssueDetails, Integer> {
	
}
