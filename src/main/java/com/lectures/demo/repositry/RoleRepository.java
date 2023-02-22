package com.lectures.demo.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lectures.demo.model.RolesE;



public interface RoleRepository extends JpaRepository<RolesE, Long>{
	 Optional<RolesE> findByName(String name);

}
