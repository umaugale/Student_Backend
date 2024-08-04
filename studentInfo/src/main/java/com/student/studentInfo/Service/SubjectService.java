package com.student.studentInfo.Service;

import java.util.List;

import com.student.studentInfo.Dtos.StudentDto;
import com.student.studentInfo.Dtos.SubjectDto;

public interface SubjectService {
	
    List<SubjectDto> getAllSubject();

	String createSubject(SubjectDto subjectDto);

}
