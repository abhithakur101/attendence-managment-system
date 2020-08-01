package com.ams.response;

import com.ams.modal.Employee;

import java.util.List;
import java.util.Map;

public class CommanResponse {
    public String message;
    public Boolean status;
    public List<Employee> employees;
    public Employee employee;
    public List<Map> allemployees;


    public CommanResponse(String message, Boolean status) {
        this.message = message;
        status = status;
    }


    public CommanResponse(String message, Boolean status, Employee employee) {
        this.message = message;
        status = status;
        this.employee = employee;
    }
    public CommanResponse(String message, Boolean status, List<Map> allemployees) {
        this.message = message;
        status = status;
        this.allemployees = allemployees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    public CommanResponse(String message, Boolean status, List<Employee> employees) {
//        this.message = message;
//        status = status;
//        this.employees = employees;
//    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public Boolean getstatus() {
        return status;
    }

    public void setstatus(Boolean status) {
        status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
