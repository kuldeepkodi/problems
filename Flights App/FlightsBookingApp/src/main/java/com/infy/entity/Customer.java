package com.infy.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue
	private Integer custId;
	private String custName;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Booking> booking;
	
	public Customer(String custName, String email, String password, List<Booking> booking) {
		this.custName = custName;
		this.email = email;
		this.password = password;
		this.booking = booking;
	}
	
	
}
