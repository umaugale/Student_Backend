package com.student.studentInfo.Controllers;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.studentInfo.Dtos.LoginDto;
import com.student.studentInfo.Dtos.StudentDto;
import com.student.studentInfo.Response.LoginResponse;
import com.student.studentInfo.Service.StudentService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	   @PostMapping(path = "/register")
	    public String saveStudent(@RequestBody StudentDto studentDto)
	    {
	        String id = studentService.addStudent(studentDto);
	        return id;
	    }
	   
	   
	   @PostMapping(path = "/login")
	    public ResponseEntity<?> loginStudent(@RequestBody LoginDto LoginDto)
	    {
		   LoginResponse loginResponse = studentService.LoginStudent(LoginDto);
	        return ResponseEntity.ok(loginResponse);
	    }
	   
	   @GetMapping("/{id}")
	    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
	        Optional<StudentDto> student = studentService.getStudentById(id);
	        if (student.isPresent()) {
	            return ResponseEntity.ok(student.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
	        studentService.deleteStudentById(id);
	        return ResponseEntity.noContent().build();
	    }
	   
	   @GetMapping
	    public ResponseEntity<List<StudentDto>> getAllStudents() {
	        List<StudentDto> students = studentService.getAllStudents();
	        if (!students.isEmpty()) {
	            return ResponseEntity.ok(students);
	        } else {
	            return ResponseEntity.noContent().build();
	        }
	    }
	   
	   @PutMapping("/{id}")
	    public ResponseEntity<String> enrollStudentInSubjects(@PathVariable Integer id, @RequestBody Set<Integer> subjectIds) {
	        studentService.enrollStudentInSubjects(id, subjectIds);
	        return ResponseEntity.ok("Student enrolled in subjects");
	    }
}
