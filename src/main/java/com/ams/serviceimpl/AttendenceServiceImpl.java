package com.ams.serviceimpl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ams.enums.AttendanceStatus;
import com.ams.modal.AttandanceLog;
import com.ams.modal.Attendance;
import com.ams.modal.Employee;
import com.ams.repository.AttLogRepo;
import com.ams.repository.AttendanceRepo;
import com.ams.repository.EmployeeRepo;
import com.ams.request.AttendanceRequset;
import com.ams.service.AttendenceService;
import com.ams.util.CommonUtil;

/**
 * Service class for Attendance management
 * 
 * 
 * @author ABHISHEK
 *
 *
 */
@CrossOrigin("*")
@Service
public class AttendenceServiceImpl implements AttendenceService {

	@Autowired
	AttendanceRepo repo;

	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	AttLogRepo logRepo;

	Calendar calendar = Calendar.getInstance();

	public String submitAttendence(AttendanceRequset attendanceRequset) {

		String empMobile = attendanceRequset.getEmpMobile();
		Employee employee = empRepo.findByEmpMobile(empMobile);
		Attendance attendance = repo.getAttendanceByEmpId(employee.getEmpId());
		Double latitude = attendanceRequset.getLatitude();
		Double longitude = attendanceRequset.getLongitude();
		// Out Time logic
		if (null != attendance) {
			Boolean locStatus = CommonUtil.checklocation(latitude, longitude);
			attendance.setUpdateDate(calendar.getTime());
			if (null != attendanceRequset.getOutTime()) {
				attendance.setOutTime(attendanceRequset.getOutTime());
			} else {
				attendance.setOutTime(new java.util.Date());
			}
			attendance.setStatus(AttendanceStatus.PRESENT);
			attendance.setLatitude(attendanceRequset.getLatitude());
			attendance.setLongitude(attendanceRequset.getLongitude());
			if (locStatus) {
				attendance.setLocationStatus(locStatus);
				repo.save(attendance);
				logAttendance(attendanceRequset, employee, locStatus);
			} else {
				logAttendance(attendanceRequset, employee, locStatus);
			}
			System.out.println("loc status ---   " + locStatus);
		} else {
			// Intime Logic
			Boolean locStatus = CommonUtil.checklocation(latitude, longitude);
			if (locStatus) {
				attendance = new Attendance();
				attendance.setManagerId(employee.getManagerId());
				attendance.setDate(LocalDate.now());
				if (null != attendanceRequset.getInTime()) {
					attendance.setInTime(attendanceRequset.getInTime());
				} else {
					attendance.setInTime(new java.util.Date());
				}
				attendance.setStatus(AttendanceStatus.ABSENT);
				attendance.setLocationStatus(locStatus);
				attendance.setLatitude(attendanceRequset.getLatitude());
				attendance.setLongitude(attendanceRequset.getLongitude());
				attendance.setEmpId(employee.getEmpId());
				attendance.setEmpMobile(employee.getEmpMobile());
				repo.save(attendance);
				logAttendance(attendanceRequset, employee, locStatus);

			} else {
				logAttendance(attendanceRequset, employee, locStatus);
			}

		}
		return "successfully submitted attendence";
	}

	/**
	 * Method for log attendance
	 * 
	 * @param requset
	 * @param employee
	 */
	private void logAttendance(AttendanceRequset requset, Employee employee, Boolean locStatus) {
		AttandanceLog attandanceLog = logRepo.getAttendanceByEmpId(employee.getEmpId());
		if (null != attandanceLog) {
			attandanceLog.setManagerId(employee.getManagerId());
			attandanceLog.setDate(LocalDate.now());
			if (null != requset.getInTime()) {
				attandanceLog.setInTime(requset.getInTime());
			} else {
				attandanceLog.setInTime(new java.util.Date());
			}
			attandanceLog.setLocationStatus(locStatus);
			attandanceLog.setStatus(AttendanceStatus.ABSENT);
			attandanceLog.setLatitude(requset.getLatitude());
			attandanceLog.setLongitude(requset.getLongitude());
			attandanceLog.setEmpId(employee.getEmpId());
			attandanceLog.setEmpMobile(employee.getEmpMobile());
			logRepo.save(attandanceLog);
		} else {
			attandanceLog = new AttandanceLog();
			attandanceLog.setManagerId(employee.getManagerId());
			attandanceLog.setDate(LocalDate.now());
			if (null != requset.getInTime()) {
				attandanceLog.setInTime(requset.getInTime());
			} else {
				attandanceLog.setInTime(new java.util.Date());
			}
			attandanceLog.setLocationStatus(locStatus);
			attandanceLog.setStatus(AttendanceStatus.ABSENT);
			attandanceLog.setLatitude(requset.getLatitude());
			attandanceLog.setLongitude(requset.getLongitude());
			attandanceLog.setEmpId(employee.getEmpId());
			attandanceLog.setEmpMobile(employee.getEmpMobile());
			logRepo.save(attandanceLog);
		}
	}
	
	public int compareTimes(Date d1, Date d2)
	{
	    int     t1;
	    int     t2;

	    t1 = (int) (d1.getTime() % (24*60*60*1000L));
	    t2 = (int) (d2.getTime() % (24*60*60*1000L));
	    return (t1 - t2);
	}
}
