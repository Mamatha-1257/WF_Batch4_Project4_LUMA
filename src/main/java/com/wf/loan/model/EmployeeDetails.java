package com.wf.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_login_details")
public class EmployeeDetails {


    @Id
    int id;
    @Column
    String employee_id;
    @Column
    String employee_password;
    public EmployeeDetails() {

    }

    public EmployeeDetails(int id, String employee_id, String employee_password) {
        this.id = id;
        this.employee_id = employee_id;
        this.employee_password = employee_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_password() {
        return employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }
}