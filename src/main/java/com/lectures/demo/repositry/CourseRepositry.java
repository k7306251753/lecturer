package com.lectures.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lectures.demo.model.Course;

@Repository
public interface CourseRepositry extends JpaRepository<Course, Long>{

}
