package com.student.studentInfo.Entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class StudentsEntity {

    @Id
    @Column(name = "student_Id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentid;

    @Column(name = "student_name", length = 255)
    private String studentname;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    
    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<SubjectEntity> subjects;

    
    // Default constructor (required by JPA)
    public StudentsEntity() {
    }

    
    // Parameterized constructor
    public StudentsEntity(int studentid, String studentname, String email, String password) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.email = email;
        this.password = password;
    }


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StudentsEntity [studentid=" + studentid + ", studentname=" + studentname + ", email=" + email
                + ", password=" + password + "]";
    }
    public Set<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectEntity> subjects) {
        this.subjects = subjects;
    }
}
