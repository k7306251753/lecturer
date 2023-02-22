package com.lectures.demo.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lectures.demo.model.LecturersE;



@Repository
public interface LectUserRepository extends JpaRepository<LecturersE, Long>{
	
    Optional<LecturersE> findByEmail(String email);
    LecturersE findByUserNameOrEmail(String username, String email) ;
    Optional<LecturersE> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
}
