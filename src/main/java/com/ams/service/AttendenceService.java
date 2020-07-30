package com.ams.service;

import com.ams.request.AttendanceRequset;
import com.ams.response.AttendaneceResponse;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface AttendenceService {
	
	public String submitAttendence(AttendanceRequset attendanceRequset,AttendaneceResponse response);

}
