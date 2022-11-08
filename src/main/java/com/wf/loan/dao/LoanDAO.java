package com.wf.loan.dao;

import com.wf.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDAO extends JpaRepository<Loan,Integer> {

    @Query(value="SELECT * FROM loan_card_master  where loan_id= :loan_id",nativeQuery = true)
    Loan findCardByLoanId(@Param("loan_id") String loan_id);
}
