package com.ams.serviceimpl;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.modal.Attendance;
import com.ams.modal.Employee;
import com.ams.repository.AttendanceRepo;
import com.ams.repository.EmployeeRepo;
import com.ams.request.AttendanceRequset;
import com.ams.service.AttendenceService;

/**
 * Service class for Attendance managment
 * 
 * 
 * @author ABHISHEK
 *
 */
@Service
public class AttendenceServiceImpl implements AttendenceService {

	@Autowired
	AttendanceRepo repo;

	@Autowired
	EmployeeRepo empRepo;

	Calendar calendar = Calendar.getInstance();

	public String submitAttendence(AttendanceRequset attendanceRequset) {
		String empMobile = attendanceRequset.getEmpMobile();
		Employee employee = empRepo.findByEmpMobile(empMobile);
		Attendance attendance = repo.getAttendanceByEmpId(employee.getEmpId());
		if (null != attendance) {
			attendance.setUpdateDate(calendar.getTime());
			attendance.setDate(calendar.getTime());
			attendance.setInTime(attendanceRequset.getInTime());
			attendance.setOutTime(attendanceRequset.getOutTime());
			attendance.setStatus("PRESENT");
			attendance.setLatitude(attendanceRequset.getLatitude());
			attendance.setLongitude(attendanceRequset.getLongitude());
			repo.save(attendance);
		} else {
			attendance = new Attendance();
			attendance.setManagerId(employee.getManagerId());
			attendance.setDate(calendar.getTime());
			attendance.setInTime(attendanceRequset.getInTime());
			attendance.setStatus("Absent");
			attendance.setLatitude(attendanceRequset.getLatitude());
			attendance.setLongitude(attendanceRequset.getLongitude());
			attendance.setEmpId(employee.getEmpId());
			attendance.setEmpMobile(employee.getEmpMobile());
			repo.save(attendance);
		}
		return "successfully submitted attendence";
	}

}
