package com.lectures.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
	@Table(name = "student")
	public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;

	    @ManyToMany()//mappedBy ="Student"
	    @JoinTable(name = "student_course",
	               joinColumns = @JoinColumn(name = "student_id"),
	               inverseJoinColumns = @JoinColumn(name = "course_id"))
	    private List<Course> courses = new ArrayList<>();

	    // Getters and setters
	}

	
