package com.student.studentInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class StudentInfoApplication {

	public static void main(String[] args) {
		System.out.println("JAVA PROGRAMMING STARTED");
		SpringApplication.run(StudentInfoApplication.class, args);
	}

}
