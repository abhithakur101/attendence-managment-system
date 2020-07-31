package com.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class AttendenceManagmentSystemV1Application {

	public static void main(String[] args) {
//		String str="-google";
//		System.out.println(str);
		SpringApplication.run(AttendenceManagmentSystemV1Application.class, args);
	}

}
