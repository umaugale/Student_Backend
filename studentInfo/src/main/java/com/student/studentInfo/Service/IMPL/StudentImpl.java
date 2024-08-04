package com.student.studentInfo.Service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.studentInfo.Dtos.LoginDto;
import com.student.studentInfo.Dtos.StudentDto;
import com.student.studentInfo.Entity.StudentsEntity;
import com.student.studentInfo.Entity.SubjectEntity;
import com.student.studentInfo.Repo.StudentRepository;
import com.student.studentInfo.Repo.SubjectRepository;
import com.student.studentInfo.Response.LoginResponse;
import com.student.studentInfo.Service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements StudentService {

	 @Autowired
	    private SubjectRepository subjectRepository;
	 
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addStudent(StudentDto studentDto) {
        StudentsEntity studentsEntity = new StudentsEntity(
                studentDto.getStudentid(),
                studentDto.getStudentname(),
                studentDto.getEmail(),
                passwordEncoder.encode(studentDto.getPassword())
        );
        studentRepository.save(studentsEntity);
        return studentsEntity.getStudentname();
    }

	@Override
	public LoginResponse LoginStudent(LoginDto loginDto) {
		 String msg = "";
		 StudentsEntity StudentsEntity1 = studentRepository.findByEmail(loginDto.getEmail());
	        if (StudentsEntity1 != null) {
	            String password = loginDto.getPassword();
	            String encodedPassword = StudentsEntity1.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<StudentsEntity> student = studentRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
	                if (student.isPresent()) {
	                    return new LoginResponse("Login Success", true);
	                } else {
	                    return new LoginResponse("Login Failed", false);
	                }
	            } else {
	                return new LoginResponse("password Not Match", false);
	            }
	        }else {
	            return new LoginResponse("Email not exits", false);
	        }
	}
	
	@Override
    public Optional<StudentDto> getStudentById(Integer id) {
        Optional<StudentsEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            StudentsEntity entity = studentEntity.get();
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentid(entity.getStudentid());
            studentDto.setStudentname(entity.getStudentname());
            studentDto.setEmail(entity.getEmail());
            return Optional.of(studentDto);
        } else {
            return Optional.empty();
        }
    }
	
	
	 @Override
	    public void deleteStudentById(Integer id) {
	        studentRepository.deleteById(id);
	    }
	 
	 
	 @Override
	    public List<StudentDto> getAllStudents() {
	        List<StudentsEntity> studentEntities = studentRepository.findAll();
	        return studentEntities.stream().map(entity -> {
	            StudentDto studentDto = new StudentDto();
	            studentDto.setStudentid(entity.getStudentid());
	            studentDto.setStudentname(entity.getStudentname());
	            studentDto.setEmail(entity.getEmail());
	            return studentDto;
	        }).collect(Collectors.toList());
	    }
	 
	 
	 @Override
	    public void enrollStudentInSubjects(Integer studentId, Set<Integer> subjectIds) {
	        Optional<StudentsEntity> optionalStudent = studentRepository.findById(studentId);
	        if (optionalStudent.isPresent()) {
	        	StudentsEntity student = optionalStudent.get();
	            Set<SubjectEntity> subjects = subjectRepository.findAllById(subjectIds).stream().collect(Collectors.toSet());
	            student.setSubjects(subjects);
	            studentRepository.save(student);
	        }
	    }
}
