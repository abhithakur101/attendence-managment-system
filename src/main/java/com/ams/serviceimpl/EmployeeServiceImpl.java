
package com.ams.serviceimpl;

import com.ams.enums.Shift;
import com.ams.modal.Employee;
import com.ams.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ams.service.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
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
    Sort sort;

    public  List<Object[]> findAllEmployee(){
        List<Object[]> employee =employeeRepo.findAllEmployees(sort);
        return  employee;
    }

    public Employee updateEmployee(String empName, String empMobile, String empEmail, String empAddress,
                               byte[] empPic, String Designation, String empPassword,
                               String OfficeAddress, Shift shift, String empId){
        employeeRepo.updateEmployee( empName,  empMobile,  empEmail,  empAddress,
                 empPic,  Designation,  empPassword,
                 OfficeAddress,  shift,  empId);
       return employeeRepo.findByEmpMobile(empMobile);

    }

    public void updateEmpName(String empName,String empId){
        employeeRepo.updateEmpName(empName,empId);
    }
    public void updateEmpEmail(String empEmail,String empId){
        employeeRepo.updateEmpEmail(empEmail, empId);
    }
    public void updateEmpMobile(String empMobile,String empId ){
        employeeRepo.updateEmpMobile(empMobile, empId);
    }
    public void updateAddress(String empAddress,String empId){
        employeeRepo.updateAddress(empAddress, empId);
    }
    public void updateEmpDesignation(String Designation,String empId){
        employeeRepo.updateEmpDesignation(Designation, empId);
    }
    public void updateEmpPassword(String empPassword,String empId){
        employeeRepo.updateEmpPassword(empPassword, empId);
    }
    public void updateOfficeAddress(String OfficeAddress,String empId){
        employeeRepo.updateOfficeAddress(OfficeAddress, empId);
    }
    public void updateShift(Shift shift,String empId){
        employeeRepo.updateShift(shift, empId);
    }
    public void updateModifiedDate(String Date,String empId){
            employeeRepo.updateModifiedDate(Date, empId);
}
    public void updateModifiedBy(String ModifiedBy,String empId){
        employeeRepo.updateModifiedBy(ModifiedBy, empId);
    }
    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }
}

