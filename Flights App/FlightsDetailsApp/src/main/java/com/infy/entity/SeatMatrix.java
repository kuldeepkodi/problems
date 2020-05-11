package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "seat_matrix")
@ToString @Getter @Setter
public class SeatMatrix {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer firstClass;
	private Integer business;
	private Integer economy;
	
	public SeatMatrix(Integer firstClass, Integer business, Integer economy) {
		this.firstClass = firstClass;
		this.business = business;
		this.economy = economy;
	}
	
	public SeatMatrix() {
		
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getFirstClass() {
//		return firstClass;
//	}
//
//	public void setFirstClass(Integer firstClass) {
//		this.firstClass = firstClass;
//	}
//
//	public Integer getBusiness() {
//		return business;
//	}
//
//	public void setBusiness(Integer business) {
//		this.business = business;
//	}
//
//	public Integer getEconomy() {
//		return economy;
//	}
//
//	public void setEconomy(Integer economy) {
//		this.economy = economy;
//	}
	
	
	
}
