package com.ams.restcontroller;

import java.util.List;

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

import com.ams.modal.Attendance;
import com.ams.request.AttendanceRequset;
import com.ams.response.AttendaneceResponse;
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
		AttendaneceResponse response = new AttendaneceResponse();
		try {
			
			if (!request.checkNull()) {
				MultipartFile file = request.getMultipartFile();
				CommonUtil.uploadImage(file, request.getEmpId());
				List<Attendance> submitAttendence = service.submitAttendence(request, response);
				if (!submitAttendence.isEmpty()) {
					response.setAttendanceList(submitAttendence);
					response.setStatus(HttpStatus.OK.value());
				} else {
					response.setStatus(HttpStatus.OK.value());
					response.setAttendanceList(submitAttendence);
				}
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
	
	@PostMapping("/updatecorrection")
	public ResponseEntity<AttendaneceResponse> updateAttendence(@RequestParam String mgrId) {
		AttendaneceResponse response = new AttendaneceResponse();
		try {
			if (null != mgrId) {
				List<Attendance> updateAttendance = service.updateAttendance(mgrId, response);
				if(null != updateAttendance) {
				response.setMessage("Successfully Updated Timesheet");
				response.setStatus(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(response);
				}else {
					response.setMessage("NO ONE APPLIED FOR CORRECTION");
					response.setStatus(HttpStatus.OK.value());
					response.setAttendanceList(updateAttendance);
					return ResponseEntity.status(HttpStatus.OK).body(response);
				}
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
			if (null != id) {
				List<Attendance> applyForCorrection = service.applyForCorrection(id);
				if (!applyForCorrection.isEmpty()) {
					response.setStatus(HttpStatus.OK.value());
					response.setAttendanceList(applyForCorrection);
					response.setMessage("Successully applied for Correction");
					return ResponseEntity.status(HttpStatus.OK).body(response);
				} else {
					response.setStatus(HttpStatus.OK.value());
					response.setMessage("Data Not Exist");
					return ResponseEntity.status(HttpStatus.OK).body(response);
				}

			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage(HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@GetMapping("/	")
	public ResponseEntity<AttendaneceResponse> getEmployeeAttendence(@RequestParam String empId,
			@RequestParam String month) {
		AttendaneceResponse response = new AttendaneceResponse();
		try {

			if (null != empId && null != month) {
				List<Attendance> employeeAttendence = service.getEmployeeAttendence(empId, month);
				if (!employeeAttendence.isEmpty()) {
					response.setAttendanceList(employeeAttendence);
					response.setMessage("Complete Attendance for " + month + " Month");
					response.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(response);
				} else {
					response.setAttendanceList(employeeAttendence);
					response.setMessage("Attendance Not marked for " + month + " Month.");
					response.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(response);
				}

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
