package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue
	private Integer bookingId;
	private Integer flightId;
	
	public Booking(Integer flightId) {
		this.flightId = flightId;
	}
	
}
