package com.lectures.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lectures.demo.model.Student;

@Repository
public interface StudentRepositry extends JpaRepository<Student, Long>{

}
