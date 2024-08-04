package com.student.studentInfo.Controllers;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.studentInfo.Dtos.SubjectDto;
import com.student.studentInfo.Service.SubjectService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	
	 @GetMapping
	    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
	        List<SubjectDto> subjects = subjectService.getAllSubject();
	        if (!subjects.isEmpty()) {
	            return ResponseEntity.ok(subjects);
	        } else {
	            return ResponseEntity.noContent().build();
	        }
	    }

	   @PostMapping(path = "/register")
	    public String saveSubject(@RequestBody SubjectDto subjectDto)
	    {
	        String id = subjectService.createSubject(subjectDto);
	        return id;
	    }

}
