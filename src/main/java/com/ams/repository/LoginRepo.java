package com.ams.repository;

import com.ams.modal.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface LoginRepo extends JpaRepository<Login, Integer> {
 public Login findByToken(String token);
}
