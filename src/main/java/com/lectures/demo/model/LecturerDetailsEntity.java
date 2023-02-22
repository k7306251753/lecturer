package com.lectures.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="fistprocedure",procedureName = "getAllLectures"),
		@NamedStoredProcedureQuery(name="second",procedureName ="getLecturerById",parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name="tlectid",type = Integer.class)} )})
public class LecturerDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lectid;
	@NotBlank(message = "must fill this data lectName")
	@Column(updatable = false, unique = true)
	private String lectName;
	@NotBlank(message = "must fill this data lectBranch")
	private String lectBranch;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private String lectHireDate;
	@NotBlank(message = "must fill this data lectExperience")
	private String lectExperience;

	public long getLectid() {
		return lectid;
	}

	public void setLectid(long lectid) {
		this.lectid = lectid;
	}

	public String getLectName() {
		return lectName;
	}

	public void setLectName(String lectName) {
		this.lectName = lectName;
	}

	public String getLectBranch() {
		return lectBranch;
	}

	public void setLectBranch(String lectBranch) {
		this.lectBranch = lectBranch;
	}

	public String getLectHireDate() {
		return lectHireDate;
	}

	public void setLectHireDate(String lectHireDate) {
		this.lectHireDate = lectHireDate;
	}

	public String getLectExperience() {
		return lectExperience;
	}

	public void setLectExperience(String lectExperience) {
		this.lectExperience = lectExperience;
	}

	@Override
	public String toString() {
		return "LecturerDetailsEntity [lectid=" + lectid + ", lectName=" + lectName + ", lectBranch=" + lectBranch
				+ ", lectHireDate=" + lectHireDate + ", lectExperience=" + lectExperience + "]";
	}

	public LecturerDetailsEntity(String lectName, String lectBranch, String lectHireDate, String lectExperience) {
		super();
		this.lectName = lectName;
		this.lectBranch = lectBranch;
		this.lectHireDate = lectHireDate;
		this.lectExperience = lectExperience;
	}

	public LecturerDetailsEntity(long lectid, String lectName, String lectBranch, String lectHireDate,
			String lectExperience) {
		super();
		this.lectid = lectid;
		this.lectName = lectName;
		this.lectBranch = lectBranch;
		this.lectHireDate = lectHireDate;
		this.lectExperience = lectExperience;
	}

	public LecturerDetailsEntity() {
		super();
	}
	/*
	 * @PrePersist protected void onCreate(){ this.lectHireDate = new Date(); }
	 */
	
}
