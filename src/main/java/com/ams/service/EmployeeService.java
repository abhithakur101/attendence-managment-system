package com.ams.service;

import com.ams.enums.Shift;
import com.ams.modal.Employee;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
public interface EmployeeService {

        public Employee findByEmpMobile(String EmpMobile);
        public Boolean checkfindByEmpMobile(String EmpMobile);
        public void updateEmpName(String empName,String empId);
        public void updateEmpEmail(String empEmail,String empId);
        public void updateEmpMobile(String empMobile,String empId );
        public void updateAddress(String empAddress,String empId);
        public void updateEmpDesignation(String Designation,String empId);
        public void updateEmpPassword(String empPassword,String empId);
        public void updateOfficeAddress(String OfficeAddress,String empId);
        public void updateShift(Shift shift,String empId);
        public void updateModifiedDate(String modifiedDate,String empId);
        public void updateDob(String dob,String empId);
        public void updateLocation(String Location,String empId);
        public void updateOfficeId(Long officeId,String empId);
        public void updateReportingOfficer(String reportingOfficer,String empId);
        public void updateHRManager(String HRManager,String empId);
        public void updateAttendenceOfficer(String attendenceOfficer,String empId);
        public void updateSubLocation(String SubLocation,String empId);

        public Employee updateEmployee(String empName,  String empMobile,  String empEmail, String empAddress,
                              byte[] empPic,  String Designation, String empPassword,
                               String OfficeAddress,  Shift shift,String empId);
        public List<Employee> findAll();
        public void addEmployee(Employee employee);
        public  List<Object[]>  findAllEmployee();
}
