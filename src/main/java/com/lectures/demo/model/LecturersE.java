package com.lectures.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lecturers")
public class LecturersE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lid;
	private String lName;
	@Column(unique =true)
	private String userName;
	@Column(unique =true)
	private String email;
	private String password;
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinTable(name = "lecturer_roles",
     joinColumns = @JoinColumn(name = "lid", referencedColumnName = "lid"),
     inverseJoinColumns = @JoinColumn(name = "rId", referencedColumnName = "rId"))
	 private Set<RolesE> roles;
	


}
