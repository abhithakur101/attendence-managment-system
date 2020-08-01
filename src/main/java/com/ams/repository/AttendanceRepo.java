package com.ams.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ams.modal.Attendance;

/**
 * 
 * 
 * @author ABHISHEK
 *
 */
@CrossOrigin("*")
@Repository
@Transactional
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

	@Query("select a from Attendance a where a.empId=:empId and date=:date")
	public Attendance getAttendanceByEmpId(String empId,String date);
	
	@Query("select a from Attendance a where a.empId=:empId and date BETWEEN :firstDate AND :lastDate")
	public List <Attendance> getAttendanceByMonth(String empId,String firstDate,String lastDate);
	
	@Query("select a from Attendance a where a.managerId=:empId and a.coorectionFlag=:flag")
	public List <Attendance> getAttendanceByCorrectionFlag(String empId,Boolean flag);
	
	
}
