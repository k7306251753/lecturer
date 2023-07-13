package com.lectures.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class CovidDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	private String ID;
	private String Country;
	private String CountryCode;
	private String Slug;
	private Integer NewConfirmed;
	private Integer TotalConfirmed;







	//i am editing the code online
	private Integer NewDeaths;
	private Integer TotalDeaths;
	private Integer NewRecovered;
	private Integer TotalRecovered;
	private String Date;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getSlug() {
		return Slug;
	}
	public void setSlug(String slug) {
		Slug = slug;
	}
	public Integer getNewConfirmed() {
		return NewConfirmed;
	}
	public void setNewConfirmed(Integer newConfirmed) {
		NewConfirmed = newConfirmed;
	}
	public Integer getTotalConfirmed() {
		return TotalConfirmed;
	}
	public void setTotalConfirmed(Integer totalConfirmed) {
		TotalConfirmed = totalConfirmed;
	}
	public Integer getNewDeaths() {
		return NewDeaths;
	}
	public void setNewDeaths(Integer newDeaths) {
		NewDeaths = newDeaths;
	}
	public Integer getTotalDeaths() {
		return TotalDeaths;
	}
	public void setTotalDeaths(Integer totalDeaths) {
		TotalDeaths = totalDeaths;
	}
	public Integer getNewRecovered() {
		return NewRecovered;
	}
	public void setNewRecovered(Integer newRecovered) {
		NewRecovered = newRecovered;
	}
	public Integer getTotalRecovered() {
		return TotalRecovered;
	}
	public void setTotalRecovered(Integer totalRecovered) {
		TotalRecovered = totalRecovered;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public CovidDataEntity(String iD, String country, String countryCode, String slug, Integer newConfirmed,
			Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered,
			Integer totalRecovered, String date) {
		super();
		ID = iD;
		Country = country;
		CountryCode = countryCode;
		Slug = slug;
		NewConfirmed = newConfirmed;
		TotalConfirmed = totalConfirmed;
		NewDeaths = newDeaths;
		TotalDeaths = totalDeaths;
		NewRecovered = newRecovered;
		TotalRecovered = totalRecovered;
		Date = date;
	}
	public CovidDataEntity() {
		super();
	}
	

}
