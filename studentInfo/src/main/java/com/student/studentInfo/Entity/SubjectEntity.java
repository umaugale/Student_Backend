package com.student.studentInfo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "subjects")
    private Set<StudentsEntity> students;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentsEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentsEntity> students) {
        this.students = students;
    }

	public SubjectEntity(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SubjectEntity() {
		super();
	}
	
    
}
