package com.ams.repository;


import com.ams.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Repository
public interface UserRepository extends JpaRepository<Employee,Long>  {
    public Employee findByEmpMobile(String EmpMobile);

}

