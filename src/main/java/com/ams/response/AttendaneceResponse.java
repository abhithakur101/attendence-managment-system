package com.ams.response;

import java.util.List;

import com.ams.modal.Attendance;

public class AttendaneceResponse {

	private String message;
	private Integer status;
	private List<Attendance> attendanceList;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the attendanceList
	 */
	public List<Attendance> getAttendanceList() {
		return attendanceList;
	}
	/**
	 * @param attendanceList the attendanceList to set
	 */
	public void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}


	
	
}
