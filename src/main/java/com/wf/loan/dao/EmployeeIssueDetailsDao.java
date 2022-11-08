package com.wf.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wf.loan.model.EmployeeIssueDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeIssueDetailsDao extends JpaRepository<EmployeeIssueDetails, Integer> {
    @Query(value="SELECT * FROM employee_issue_details  where employee_id= :employee_id",nativeQuery = true)
    List<EmployeeIssueDetails> findIssueByEmployeeId(@Param("employee_id") String employee_id);
	
}
