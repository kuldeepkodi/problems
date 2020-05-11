package com.infy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class SeatMatrixDTO {
	private Integer id;
	private Integer firstClass;
	private Integer business;
	private Integer economy;
	
	public SeatMatrixDTO(Integer firstClass, Integer business, Integer economy) {
		this.firstClass = firstClass;
		this.business = business;
		this.economy = economy;
	}
	
	public SeatMatrixDTO() {
		
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
