package com.ams.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ams.modal.Attendance;

/**
 * 
 * 
 * @author ABHISHEK
 *
 */
@Repository
@Transactional
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

	@Query("select a from Attendance a where a.empId=:empId")
	public Attendance getAttendanceByEmpId(String empId);
}
