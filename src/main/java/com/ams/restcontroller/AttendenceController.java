package com.ams.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.request.AttendanceRequset;
import com.ams.serviceimpl.AttendenceServiceImpl;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/attendence")
public class AttendenceController {

	@Autowired
	AttendenceServiceImpl service;

	@PostMapping("/submit")
	public String submitAttendence(@NotNull @RequestBody AttendanceRequset attendanceRequset) {
		String response = null;
		try {
			if (!attendanceRequset.checkNull()) {
				response = service.submitAttendence(attendanceRequset);

			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("tests");

		}
		return response;
	}

	public void attendenceCorrection() {
	}

	public void updateAttendence() {
	}

	public void listAttendence() {
	}

	public void approveAttendence() {
	}
}
