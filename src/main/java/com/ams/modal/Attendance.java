package com.ams.modal;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.ams.enums.AttendanceStatus;

/**
 * Entity Class for Attendance Table
 * 
 * 
 * @author ABHISHEK
 *
 */
@CrossOrigin("*")
@Entity
@Table(name = "ATTENDANCE")
public class Attendance {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "EMP_ID")
	private String empId;

	@Column(name = "STATUS")
	private AttendanceStatus status;

	@Column(name = "DATE")
	private String date;
	
	@Column(name="DAY")
	private DayOfWeek day;

	@Column(name = "IN_TIME")
	private Date inTime;

	@Column(name = "OUT_TIME")
	private Date outTime;

	@Column(name = "LATITUDE")
	private Double latitude;

	@Column(name = "LONGITUDE")
	private Double longitude;

	@Column(name = "MANGR_ID")
	private String managerId;

	@Column(name = "APPROVED_BY")
	private String approvedBy;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name="EMP_MOBILE")
	private String empMobile;
	
	@Column(name="LOC_STATUS")
	private Boolean locationStatus;
	
	@Column(name="CORRECTION_FLAG")
	private Boolean coorectionFlag;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the status
	 */
	public AttendanceStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(AttendanceStatus status) {
		this.status = status;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the inTime
	 */
	public Date getInTime() {
		return inTime;
	}

	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	/**
	 * @return the outTime
	 */
	public Date getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime the outTime to set
	 */
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the empMobile
	 */
	public String getEmpMobile() {
		return empMobile;
	}

	/**
	 * @param empMobile the empMobile to set
	 */
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	/**
	 * @return the locationStatus
	 */
	public Boolean getLocationStatus() {
		return locationStatus;
	}

	/**
	 * @param locationStatus the locationStatus to set
	 */
	public void setLocationStatus(Boolean locationStatus) {
		this.locationStatus = locationStatus;
	}

	/**
	 * @return the coorectionFlag
	 */
	public Boolean isCoorectionFlag() {
		return coorectionFlag;
	}

	/**
	 * @param coorectionFlag the coorectionFlag to set
	 */
	public void setCoorectionFlag(Boolean coorectionFlag) {
		this.coorectionFlag = coorectionFlag;
	}

	/**
	 * @return the day
	 */
	public DayOfWeek getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	/**
	 * @return the coorectionFlag
	 */
	public Boolean getCoorectionFlag() {
		return coorectionFlag;
	}

	
}
