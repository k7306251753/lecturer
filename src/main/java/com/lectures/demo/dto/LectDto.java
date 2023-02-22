package com.lectures.demo.dto;

public class LectDto {
	private String lectid;
	private String lectName;
	private String lectBranch;
	private String lectHireDate;
	private String lectExperience;
	public String getLectid() {
		return lectid;
	}
	public void setLectid(String lectid) {
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
		return "LectDto [lectid=" + lectid + ", lectName=" + lectName + ", lectBranch=" + lectBranch + ", lectHireDate="
				+ lectHireDate + ", lectExperience=" + lectExperience + "]";
	}
	public LectDto(String lectid, String lectName, String lectBranch, String lectHireDate, String lectExperience) {
		super();
		this.lectid = lectid;
		this.lectName = lectName;
		this.lectBranch = lectBranch;
		this.lectHireDate = lectHireDate;
		this.lectExperience = lectExperience;
	}
	public LectDto(String lectName, String lectBranch, String lectHireDate, String lectExperience) {
		super();
		this.lectName = lectName;
		this.lectBranch = lectBranch;
		this.lectHireDate = lectHireDate;
		this.lectExperience = lectExperience;
	}
	public LectDto() {
		super();
	}
	

}
