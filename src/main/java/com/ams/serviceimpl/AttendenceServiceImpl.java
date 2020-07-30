
package com.ams.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ams.bean.ShiftTime;
import com.ams.enums.AttendanceStatus;
import com.ams.modal.AttandanceLog;
import com.ams.modal.Attendance;
import com.ams.modal.Employee;
import com.ams.repository.AttLogRepo;
import com.ams.repository.AttendanceRepo;
import com.ams.repository.EmployeeRepo;
import com.ams.request.AttendanceRequset;
import com.ams.response.AttendaneceResponse;
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
@CrossOrigin(origins = "*")
@Service
public class AttendenceServiceImpl implements AttendenceService {

	@Autowired
	AttendanceRepo repo;

	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	AttLogRepo logRepo;
	
	List<Attendance> attList =new ArrayList<Attendance>();
	
	Calendar calendar = Calendar.getInstance();

	public String submitAttendence(AttendanceRequset attendanceRequset,AttendaneceResponse response) {
		
		try {
			String empMobile = attendanceRequset.getEmpMobile();
			Employee employee = empRepo.findByEmpMobile(empMobile);
			ShiftTime shiftTime = CommonUtil.getShiftTime(employee.getShift());
			Attendance attendance = repo.getAttendanceByEmpId(employee.getEmpId());
			Double latitude = attendanceRequset.getLatitude();
			Double longitude = attendanceRequset.getLongitude();
			// Out Time logic
			if (null != attendance) {
				Boolean locStatus = CommonUtil.checklocation(latitude, longitude);
				attendance.setUpdateDate(calendar.getTime());
					attendance.setOutTime(new java.util.Date());
				int inTime = CommonUtil.compareTimes(shiftTime.getMinOut(), attendance.getInTime());
				int outime = CommonUtil.compareTimes(shiftTime.getMinOut(), attendance.getOutTime());

				if (inTime >= 0 && outime <= 0) {
					attendance.setStatus(AttendanceStatus.PRESENT);
				}
				attendance.setLatitude(attendanceRequset.getLatitude());
				attendance.setLongitude(attendanceRequset.getLongitude());
				attendance.setCoorectionFlag(false);
				if (locStatus) {
					attendance.setLocationStatus(locStatus);
					Attendance attt = repo.save(attendance);
					attList.add(attt);
					response.setAttendanceList(attList);
					logAttendance(attendanceRequset, employee, locStatus);
				} else {
					logAttendance(attendanceRequset, employee, locStatus);
				}
			} else {
				// Intime Logic
				Boolean locStatus = CommonUtil.checklocation(latitude, longitude);
				System.out.println(locStatus);
				if (locStatus) {
					attendance = new Attendance();
					attendance.setManagerId(employee.getManagerId());
					attendance.setDate(LocalDate.now().toString());
					if (null != attendanceRequset.getInTime()) {
						// TODO pendig parsing date
					} else {
						attendance.setInTime(new java.util.Date());
					}
					attendance.setStatus(AttendanceStatus.ABSENT);
					attendance.setCoorectionFlag(false);
					attendance.setLocationStatus(locStatus);
					attendance.setLatitude(attendanceRequset.getLatitude());
					attendance.setLongitude(attendanceRequset.getLongitude());
					attendance.setEmpId(employee.getEmpId());
					attendance.setEmpMobile(employee.getEmpMobile());
					Attendance attt = repo.save(attendance);
					attList.add(attt);
					response.setAttendanceList(attList);
					logAttendance(attendanceRequset, employee, locStatus);

				} else {
					logAttendance(attendanceRequset, employee, locStatus);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successfully submitted attendence";
	}

	/**
	 * Method for log attendance
	 * 
	 * @param requset
	 * @param employee
	 * @throws ParseException
	 */
	private void logAttendance(AttendanceRequset requset, Employee employee, Boolean locStatus) throws ParseException {
		AttandanceLog attandanceLog = logRepo.getAttendanceByEmpId(employee.getEmpId());
		ShiftTime shiftTime = CommonUtil.getShiftTime(employee.getShift());
		if (null != attandanceLog) {
			// OUT TIME LOGIC
			attandanceLog.setManagerId(employee.getManagerId());
			attandanceLog.setDate(LocalDate.now());
			if (null != requset.getInTime()) {
				// TODO pending date parsing
			} else {
				attandanceLog.setInTime(new java.util.Date());
			}
			if (null != requset.getOutTime()) {
				// TODO pending date parsing
			} else {
				attandanceLog.setOutTime(new java.util.Date());
			}
			int inTime = CommonUtil.compareTimes(shiftTime.getMinOut(), attandanceLog.getInTime());
			int outime = CommonUtil.compareTimes(shiftTime.getMinOut(), attandanceLog.getOutTime());

			if (inTime >= 0 && outime <= 0) {
				attandanceLog.setStatus(AttendanceStatus.PRESENT);
			}
			attandanceLog.setLocationStatus(locStatus);
			attandanceLog.setCoorectionFlag(false);
			attandanceLog.setLatitude(requset.getLatitude());
			attandanceLog.setLongitude(requset.getLongitude());
			attandanceLog.setEmpId(employee.getEmpId());
			attandanceLog.setEmpMobile(employee.getEmpMobile());
			logRepo.save(attandanceLog);
		} else {
			// Intime logic
			attandanceLog = new AttandanceLog();
			attandanceLog.setManagerId(employee.getManagerId());
			attandanceLog.setDate(LocalDate.now());
			if (null != requset.getInTime()) {
				// TODO pending date parsing
			} else {
				attandanceLog.setInTime(new java.util.Date());
			}
			if (null != requset.getOutTime()) {
				// TODO pending date parsing
			} else {
				attandanceLog.setOutTime(new java.util.Date());
			}
			attandanceLog.setLocationStatus(locStatus);
			attandanceLog.setStatus(AttendanceStatus.ABSENT);
			attandanceLog.setCoorectionFlag(false);
			attandanceLog.setLatitude(requset.getLatitude());
			attandanceLog.setLongitude(requset.getLongitude());
			attandanceLog.setEmpId(employee.getEmpId());
			attandanceLog.setEmpMobile(employee.getEmpMobile());
			logRepo.save(attandanceLog);
		}
	}
	
	/**
	 * Method For update status of attendance
	 * 
	 * 
	 * @param request
	 */
	public String applyForCorrection(Long id) {
		
			System.out.println(id);
			Optional<Attendance> findById = repo.findById(id);
			//attendance flow
			if(findById.isPresent()) {
				Attendance att = findById.get();
				System.out.println("ths is done");
				att.setUpdateDate(new Date());
				att.setCoorectionFlag(true);
				repo.save(att);
			}
			//Log Flow
			Optional<AttandanceLog> findByIdlog = logRepo.findById(id);
			if(findByIdlog.isPresent()) {
				AttandanceLog att = findByIdlog.get();
				att.setUpdateDate(new Date());
				att.setCoorectionFlag(true);
				logRepo.save(att);
			}
		
		return "SUCCESSFULLY APPLIED FOR CORRECTION";
	}

	public List<Attendance> getEmployeeAttendence(String empId ,String month) {
		Date date = null;
        try {
            date = new SimpleDateFormat("MMMM").parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        YearMonth yearMonth = YearMonth.of(Integer.parseInt("2020") , cal.get(Calendar.MONTH) + 1);
        LocalDate firstDate = yearMonth.atDay(1);
        LocalDate lastDate = yearMonth.atEndOfMonth();
       List<Attendance> attendanceByMonth = repo.getAttendanceByMonth(empId, firstDate.toString(), lastDate.toString());
        return attendanceByMonth;
	}

	public String updateAttendance(@RequestParam String empId,AttendaneceResponse response) {
		List<Attendance> attendanceList = repo.getAttendanceByCorrectionFlag(empId, true);
		for(Attendance attendance:attendanceList) {
			attendance.setCoorectionFlag(false);
			attendance.setStatus(AttendanceStatus.PRESENT);
			Attendance att = repo.save(attendance);
			attList.add(att);
			response.setAttendanceList(attList);
		}
		return "SUCCESSFULLY UPDATED";
	}

	
}
