package com.ams.request;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class AttendanceRequset {

	private Long empId;

	private Date date;

	private Date inTime;

	private Date outTime;

	private Double latitude;

	private Double longitude;

	private Long managerId;

	private String approvedBy;

	private Date updateDate;
	
	private MultipartFile multipartFile;
	
	private String empMobile;
	
	

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
	 * @return the multipartFile
	 */
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	/**
	 * @param multipartFile the multipartFile to set
	 */
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
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
	public Long getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(Long managerId) {
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
	
	public boolean checkNull() throws IllegalAccessException {
	    for (java.lang.reflect.Field f : getClass().getDeclaredFields())
	        if (f.get(this) != null)
	            return false;
	    return true;            
	}
	
}
