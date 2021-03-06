package com.ams.request;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.ams.enums.Role;
import com.ams.enums.Shift;

import javax.persistence.Column;

@CrossOrigin("*")
public class AddEmpRequest {
        private int id;
          private String empId;
          private String empName;
          private String empPassword;
          private String empEmail;
          private String empMobile;
          private String managerId;
          private String empAddress;
          private MultipartFile empPic;
          private String Designation;
          private String OfficeAddress;
          private Role empRole;
          private Shift shift;
          private String CreatedDate;		
          private String CreatedBy;
          private String ModifiedDate;
          private String ModifiedBy;
          private String ActiveStatus;
          private String dob;
          private String reportingOfficer;
          private String attendenceOfficer;
          private String HRManager;
          private Long OfficeId;
          private String Location;
          private String SubLocation;



        public AddEmpRequest() {
        }

    public AddEmpRequest(int id, String empId, String empName, String empPassword, String empEmail, String empMobile, String managerId, String empAddress, MultipartFile empPic, String designation, String officeAddress, Role empRole, Shift shift, String createdDate, String createdBy, String modifiedDate, String modifiedBy, String activeStatus, String dob, String reportingOfficer, String attendenceOfficer, String HRManager, Long officeId, String location, String subLocation) {
        this.id = id;
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
        CreatedDate = createdDate;
        CreatedBy = createdBy;
        ModifiedDate = modifiedDate;
        ModifiedBy = modifiedBy;
        ActiveStatus = activeStatus;
        this.dob = dob;
        this.reportingOfficer = reportingOfficer;
        this.attendenceOfficer = attendenceOfficer;
        this.HRManager = HRManager;
        OfficeId = officeId;
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

        public MultipartFile getEmpPic() {
            return empPic;
        }

        public void setEmpPic(MultipartFile empPic) {
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
        return OfficeId;
    }

        public void setOfficeId(Long officeId) {
        OfficeId = officeId;
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
    