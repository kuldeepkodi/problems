package com.infy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class BookingDTO {

	private Integer bookingId;
	private Integer flightId;

	public BookingDTO(Integer flightId) {
		this.flightId = flightId;
	}
	
}
