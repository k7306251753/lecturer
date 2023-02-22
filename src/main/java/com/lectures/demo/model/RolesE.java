package com.lectures.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolesE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rId;
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "lecturer_roles", 
	joinColumns = @JoinColumn(name = "rId", referencedColumnName = "rId"),
	inverseJoinColumns = @JoinColumn(name = "lid", referencedColumnName = "lid"))
	private Set<LecturersE> lectures;

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<LecturersE> getSbiUsers() {
		return lectures;
	}

	public RolesE(Long rId, String name, Set<LecturersE> sbiUsers) {
		super();
		this.rId = rId;
		this.name = name;
		this.lectures = sbiUsers;
	}

	public RolesE(String name, Set<LecturersE> sbiUsers) {
		super();
		this.name = name;
		this.lectures = sbiUsers;
	}

	public void setSbiUsers(Set<LecturersE> sbiUsers) {
		this.lectures = sbiUsers;
	}

	public RolesE(String name) {
		super();
		this.name = name;
	}

	public RolesE() {

	}

}