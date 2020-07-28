package com.ams.request;

import java.util.List;

import com.ams.modal.Attendance;

public class CorrectionRequest {
	private List<Attendance> attendanceList;

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
	 
	public boolean checkNull() throws IllegalAccessException {
	    for (java.lang.reflect.Field f : getClass().getDeclaredFields())
	        if (f.get(this) != null)
	            return false;
	    return true;            
	}

}
