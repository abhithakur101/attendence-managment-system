package com.ams.service;

import com.ams.request.AttendanceRequset;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface AttendenceService {
	
	public String submitAttendence(AttendanceRequset attendanceRequset);

}
