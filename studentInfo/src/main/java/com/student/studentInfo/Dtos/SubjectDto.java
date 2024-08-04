package com.student.studentInfo.Dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SubjectDto {
	
	 
	    private Integer id;
	  
		private String name;

		  public SubjectDto(Integer id, String name) {
				super();
				this.id = id;
				this.name = name;
			}

		public SubjectDto() {
			super();
		}

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

		@Override
		public String toString() {
			return "SubjectDto [id=" + id + ", name=" + name + "]";
		}
		  
}
