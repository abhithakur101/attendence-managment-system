package com.ams.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ams.request.AttendanceRequset;
import com.ams.response.AttendaneceResponse;
import com.ams.response.InTimeResponse;
import com.ams.response.OutimeResponse;
import com.ams.serviceimpl.AttendenceServiceImpl;
import com.ams.util.CommonUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/attendence")
public class AttendenceController {

	@Autowired
	AttendenceServiceImpl service;

	@PostMapping("/submit")
	public ResponseEntity<AttendaneceResponse> submitAttendance(@ModelAttribute AttendanceRequset request) {
		String message = null;
		AttendaneceResponse response = new AttendaneceResponse();
		try {
			if (!request.checkNull()) {
				MultipartFile file = request.getMultipartFile();
				CommonUtil.uploadImage(file, request.getEmpId());
				message = service.submitAttendence(request,response);
				response.setMessage(message);
				response.setStatus(HttpStatus.OK.value());
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage(HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/intime")
	public ResponseEntity<InTimeResponse> getInTime() {
		InTimeResponse response = new InTimeResponse();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		String time = dateFormat.format(date);
		response.setStatus(HttpStatus.OK.value());
		response.setIntime(time);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/outtime")
	public ResponseEntity<OutimeResponse> getOutTime() {
		OutimeResponse response = new OutimeResponse();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		String time = dateFormat.format(date);
		response.setStatus(HttpStatus.OK.value());
		response.setOutTime(time);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/*
	 * private String getInTimeString() { ResponseEntity<InTimeResponse> inTime =
	 * getInTime(); InTimeResponse body = inTime.getBody(); return body.getIntime();
	 * }
	 * 
	 * private String getOutTimeString() { ResponseEntity<OutimeResponse> outTime =
	 * getOutTime(); OutimeResponse body = outTime.getBody(); return
	 * body.getOutTime(); }
	 */

	@PostMapping("/updatetimesheet")
	public ResponseEntity<AttendaneceResponse> updateAttendence(@RequestParam String empId) {
		AttendaneceResponse response = new AttendaneceResponse();
		try {
			if (null!=empId) {
				String message = service.updateAttendance(empId,response);
				response.setMessage(message);
				response.setStatus(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage(HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	
	}

	@PostMapping("/correction")
	public ResponseEntity<AttendaneceResponse> applyForCorrection(@RequestParam Long id) {
		AttendaneceResponse response = new AttendaneceResponse();
		try {
			if (null!=id) {
				response.setMessage(service.applyForCorrection(id));
				response.setStatus(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage(HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@GetMapping("/getattendance")
	public ResponseEntity<AttendaneceResponse> getEmployeeAttendence(@RequestParam String empId,
			@RequestParam String month) {
		AttendaneceResponse response = new AttendaneceResponse();
		try {

			if (null != empId && null != month) {
				response.setAttendanceList(service.getEmployeeAttendence(empId, month));
				response.setMessage(HttpStatus.OK.toString());
				response.setStatus(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage(HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
