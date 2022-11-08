package com.wf.loan.dao;

import com.wf.loan.model.Card;
import com.wf.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDAO extends JpaRepository<Card,Integer> {
    @Query(value="SELECT * FROM employee_card_details  where employee_id= :employee_id",nativeQuery = true)
    List<Card> findCardByEmployeeId(@Param("employee_id") String employee_id);

}
