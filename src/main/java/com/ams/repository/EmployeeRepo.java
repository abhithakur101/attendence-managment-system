package com.ams.repository;

import com.ams.enums.Shift;
import com.ams.modal.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    public Employee findByEmpMobile(String EmpMobile);

    public List<Employee> findAll();

 @Query(value = "SELECT e.empId,e.empName,e.empEmail,e.empMobile,e.shift,e.empRole," +
         "e.OfficeAddress,e.Designation,e.CreatedBy,e.CreatedDate,e.empAddress,e.ActiveStatus," +
         "e.managerId,e.dob,e.attendenceOfficer,e.HRManager,e.reportingOfficer,e.officeId,e.Location," +
         "e.SubLocation FROM Employee e")
 public  List<Object[]>  findAllEmployees();

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.empName=:empName," +
            "e.empMobile=:empMobile,e.empEmail=:empEmail," +
            "e.empAddress=:empAddress,e.empPic=:empPic," +
            "e.Designation=:Designation,e.empPassword=:empPassword," +
            "e.OfficeAddress=:OfficeAddress,e.shift=:shift where e.empId =:empId")
   public void updateEmployee(@Param("empName") String empName, @Param("empMobile") String empMobile, @Param("empEmail") String empEmail, @Param("empAddress") String empAddress,
                        @Param("empPic") byte[] empPic, @Param("Designation") String Designation, @Param("empPassword") String empPassword,
                        @Param("OfficeAddress") String OfficeAddress, @Param("shift") Shift shift, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.empName=:empName  where e.empId =:empId")
    public void updateEmpName(@Param("empName") String empName, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.empMobile=:empMobile  where e.empId =:empId")
    public void updateEmpMobile(@Param("empMobile") String empMobile, @Param("empId") String empId);


    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.empEmail=:empEmail  where e.empId =:empId")
    public void updateEmpEmail(@Param("empEmail") String empEmail, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.empAddress=:empAddress  where e.empId =:empId")
    public void updateAddress(@Param("empAddress") String empAddress, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.Designation=:Designation  where e.empId =:empId")
    public void updateEmpDesignation(@Param("Designation") String Designation, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.empPassword=:empPassword  where e.empId =:empId")
    public void updateEmpPassword(@Param("empPassword") String empPassword, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.OfficeAddress=:OfficeAddress  where e.empId =:empId")
    public void updateOfficeAddress(@Param("OfficeAddress") String OfficeAddress, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.shift=:shift  where e.empId =:empId")
    public void updateShift(@Param("shift") Shift shift, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.ModifiedDate=:ModifiedDate  where e.empId =:empId")
    public void updateModifiedDate(@Param("ModifiedDate") String  ModifiedDate, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.ModifiedBy=:ModifiedBy  where e.empId =:empId")
    public void updateModifiedBy(@Param("ModifiedBy") String ModifiedBy, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.dob=:dob  where e.empId =:empId")
    public void updateDob(@Param("dob") String dob, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.Location=:Location  where e.empId =:empId")
    public void updateLocation(@Param("Location") String Location, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.officeId=:officeId  where e.empId =:empId")
    public void updateOfficeId(@Param("officeId") Long officeId, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.reportingOfficer=:reportingOfficer  where e.empId =:empId")
    public void updateReportingOfficer(@Param("reportingOfficer") String reportingOfficer, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.HRManager=:HRManager  where e.empId =:empId")
    public void updateHRManager(@Param("HRManager") String HRManager, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.attendenceOfficer=:attendenceOfficer  where e.empId =:empId")
    public void updateAttendenceOfficer(@Param("attendenceOfficer") String attendenceOfficer, @Param("empId") String empId);

    @Transactional
    @Modifying
    @Query(value = "update Employee e set e.SubLocation=:SubLocation  where e.empId =:empId")
    public void updateSubLocation(@Param("SubLocation") String SubLocation, @Param("empId") String empId);






}
