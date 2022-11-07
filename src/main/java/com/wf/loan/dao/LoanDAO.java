package com.wf.loan.dao;

import com.wf.loan.model.CardDetails;
import com.wf.loan.model.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDAO extends JpaRepository<LoanDetails,Integer> {

    @Query(value="SELECT * FROM loan_card_master  where loan_id= :loan_id",nativeQuery = true)
    LoanDetails findCardByLoanId(@Param("loan_id") String loan_id);
}
