package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ams.modal.AttandanceLog;

@Repository
public interface AttLogRepo extends JpaRepository<AttandanceLog, Long> {
	@Query("select a from AttandanceLog a where a.empId=:empId")
	public AttandanceLog getAttendanceByEmpId(String empId);
	
}	
