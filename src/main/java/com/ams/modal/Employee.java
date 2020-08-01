package com.ams.modal;
import com.ams.enums.Role;
import com.ams.enums.Shift;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Arrays;
@CrossOrigin("*")
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column(name = "EMP_ID")
    private String empId;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "EMP_PASSWORD")
    private String empPassword;
    @Column(name = "EMP_EMAIL")
    private String empEmail;
    @Column(name = "EMP_MOBILE")
    private String empMobile;
    @Column(name = "MANAGER_ID")
    private String managerId;
    @Column(name = "EMP_ADDRESS")
    private String empAddress;
   @Column(name = "EMP_PIC", length = 2147483647)
    private byte[] empPic;
    @Column(name = "EMP_DESIGNATION")
    private String Designation;
    @Column(name = "OFFICE_ADDRESS")
    private String OfficeAddress;
    @Column(name = "EMP_ROLE")
    private Role empRole;
    @Column(name = "EMP_SHIFT")
    private Shift shift;
    @Column(name = "CREATED_DATE")
    private String CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private String ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "ACTIVE_STATUS")
    private String ActiveStatus;

    @Column(name="DOB")
    private String dob;

    @Column(name="Reporting_officer")
    private String reportingOfficer;

    @Column(name="attendence_Officer")
    private String attendenceOfficer;

    @Column(name="HR_Manager")
    private String HRManager;


    @Column(name="Office_Id")
    private Long officeId;

    @Column(name="Location")
    private String Location;

    @Column(name="Sub_Location")
    private String SubLocation;


    public Employee() {
    }


    public Employee(int id, String empId, String empName, String empPassword, String empEmail, String empMobile, String managerId, String empAddress, byte[] empPic, String designation, String officeAddress, Role empRole, Shift shift
            , String createdDate, String createdBy, String modifiedDate, String modifiedBy, String activeStatus,String dob, String reportingOfficer, String attendenceOfficer, String HRManager, Long officeId, String location, String subLocation) {
        this.empId = empId;
        this.empName = empName;
        this.empPassword = empPassword;
        this.empEmail = empEmail;
        this.empMobile = empMobile;
        this.managerId = managerId;
        this.empAddress = empAddress;
        this.empPic = empPic;
        Designation = designation;
        OfficeAddress = officeAddress;
        this.empRole = empRole;
        this.shift = shift;
        this.id = id;
        CreatedDate = createdDate;
        CreatedBy = createdBy;
        ModifiedDate = modifiedDate;
        ModifiedBy = modifiedBy;
        ActiveStatus = activeStatus;
        this.dob = dob;
        this.reportingOfficer = reportingOfficer;
        this.attendenceOfficer = attendenceOfficer;
        this.HRManager = HRManager;
        officeId = officeId;
        Location = location;
        SubLocation = subLocation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empMobile='" + empMobile + '\'' +
                ", managerId='" + managerId + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empPic=" + Arrays.toString(empPic) +
                ", Designation='" + Designation + '\'' +
                ", OfficeAddress='" + OfficeAddress + '\'' +
                ", empRole=" + empRole +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public byte[] getEmpPic() {
        return empPic;
    }

    public void setEmpPic(byte[] empPic) {
        this.empPic = empPic;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getOfficeAddress() {
        return OfficeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        OfficeAddress = officeAddress;
    }

    public Role getEmpRole() {
        return empRole;
    }

    public void setEmpRole(Role empRole) {
        this.empRole = empRole;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getActiveStatus() {
        return ActiveStatus;
    }

    public void setActiveStatus(String activeStatus) {
        ActiveStatus = activeStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getReportingOfficer() {
        return reportingOfficer;
    }

    public void setReportingOfficer(String reportingOfficer) {
        this.reportingOfficer = reportingOfficer;
    }

    public String getAttendenceOfficer() {
        return attendenceOfficer;
    }

    public void setAttendenceOfficer(String attendenceOfficer) {
        this.attendenceOfficer = attendenceOfficer;
    }

    public String getHRManager() {
        return HRManager;
    }

    public void setHRManager(String HRManager) {
        this.HRManager = HRManager;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        officeId = officeId;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getSubLocation() {
        return SubLocation;
    }

    public void setSubLocation(String subLocation) {
        SubLocation = subLocation;
    }
}
