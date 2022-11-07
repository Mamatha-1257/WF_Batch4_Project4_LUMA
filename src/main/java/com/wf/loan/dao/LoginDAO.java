package com.wf.loan.dao;

import com.wf.loan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoginDAO extends JpaRepository<Employee,Integer> {
    @Query(value="SELECT * FROM employee_login_details  where employee_id= :employee_id and employee_password= :employee_password",nativeQuery = true)
    List<Employee> findEmployeeByIdAndPassword(@Param("employee_id") String employee_id, @Param("employee_password") String employee_password);

}