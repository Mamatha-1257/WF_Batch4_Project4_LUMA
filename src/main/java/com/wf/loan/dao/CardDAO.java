package com.wf.loan.dao;

import com.wf.loan.model.CardDetails;
import com.wf.loan.model.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDAO extends JpaRepository<CardDetails,Integer> {
    @Query(value="SELECT * FROM employee_card_details  where employee_id= :employee_id",nativeQuery = true)
    List<CardDetails> findCardByEmployeeId(@Param("employee_id") String employee_id);

}
