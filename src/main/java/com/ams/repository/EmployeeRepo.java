package com.ams.repository;

import com.ams.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    public Employee findByEmpMobile(String EmpMobile);
    public List<Employee> findAll();
}
