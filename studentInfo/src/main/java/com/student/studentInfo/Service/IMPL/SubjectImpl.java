package com.student.studentInfo.Service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentInfo.Dtos.StudentDto;
import com.student.studentInfo.Dtos.SubjectDto;
import com.student.studentInfo.Entity.StudentsEntity;
import com.student.studentInfo.Entity.SubjectEntity;
import com.student.studentInfo.Repo.SubjectRepository;
import com.student.studentInfo.Service.SubjectService;

@Service
public class SubjectImpl implements SubjectService {
	
	 @Autowired
	 private SubjectRepository subjectRepository;
	 
	 @Override
	    public List<SubjectDto> getAllSubject() {
	        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
	        return subjectEntities.stream().map(subject -> {
	            SubjectDto subjectDto = new SubjectDto();
	            subjectDto.setId(subject.getId());
	            subjectDto.setName(subject.getName());
	            return subjectDto;
	        }).collect(Collectors.toList());
	    }
	
	  @Override
	    public String createSubject(SubjectDto subjectDto) {
	        SubjectEntity subjectEntity = new SubjectEntity(
	        		subjectDto.getId(),
	        		subjectDto.getName()
	        );
	        subjectRepository.save(subjectEntity);
	        return subjectEntity.getName();
	    }

}
