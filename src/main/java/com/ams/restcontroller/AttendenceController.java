package com.ams.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.request.AttendanceRequset;
import com.ams.response.AttendaneceResponse;
import com.ams.serviceimpl.AttendenceServiceImpl;

@RestController
@RequestMapping("/attendence")
public class AttendenceController {

	@Autowired
	AttendenceServiceImpl service;

	@PostMapping("/submit")
	public ResponseEntity<AttendaneceResponse> submitAttendance(@RequestBody AttendanceRequset request) {
		String message = null;
		AttendaneceResponse response =  new AttendaneceResponse();
		try {
			if (!request.checkNull()) {
				message = service.submitAttendence(request);
				response.setMessage(message);;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage(HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
	
	@GetMapping("/intime")
	public String getInTime() {
		return null;
	}

	public void updateAttendence() {
	}

}
