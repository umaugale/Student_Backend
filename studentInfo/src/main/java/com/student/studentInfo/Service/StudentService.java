package com.student.studentInfo.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.studentInfo.Dtos.LoginDto;
import com.student.studentInfo.Dtos.StudentDto;
import com.student.studentInfo.Entity.StudentsEntity;
import com.student.studentInfo.Repo.StudentRepository;
import com.student.studentInfo.Response.LoginResponse;

public interface StudentService {
	
	String addStudent(StudentDto studentDto);
	LoginResponse LoginStudent(LoginDto loginDto);  
    Optional<StudentDto> getStudentById(Integer id);
    void deleteStudentById(Integer id);
    List<StudentDto> getAllStudents();
    void enrollStudentInSubjects(Integer studentId, Set<Integer> subjectIds);

}
