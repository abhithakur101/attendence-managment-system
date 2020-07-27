package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.modal.Attendance;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 
 * 
 * @author ABHISHEK
 *
 */
@CrossOrigin("*")
@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

}
