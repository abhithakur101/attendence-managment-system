
package com.ams.serviceimpl;

import com.ams.enums.Shift;
import com.ams.modal.Employee;
import com.ams.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee findByEmpMobile(String EmpMobile){
    Employee employee =  employeeRepo.findByEmpMobile(EmpMobile);
    return  employee;
    }

    public Boolean checkfindByEmpMobile(String EmpMobile){
        try {
            Employee employee = employeeRepo.findByEmpMobile(EmpMobile);
            if(employee.equals(null)){
                return false;
            }else{
            return  true;
            }
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepo.findAll();
        return  employees;
    }

    public Employee updateEmployee(String empName, String empMobile, String empEmail, String empAddress,
                               byte[] empPic, String Designation, String empPassword,
                               String OfficeAddress, Shift shift, String empId){
        employeeRepo.updateEmployee( empName,  empMobile,  empEmail,  empAddress,
                 empPic,  Designation,  empPassword,
                 OfficeAddress,  shift,  empId);
       return employeeRepo.findByEmpMobile(empMobile);

    }
    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }
}

