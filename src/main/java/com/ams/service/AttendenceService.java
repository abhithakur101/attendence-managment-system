package com.ams.service;

import com.ams.modal.Attendance;
import com.ams.request.AttendanceRequset;
import com.ams.response.AttendaneceResponse;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface AttendenceService {
	
	public List<Attendance> submitAttendence(AttendanceRequset attendanceRequset,AttendaneceResponse response);

}
