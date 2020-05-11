package com.infy.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class CustomerDTO {

	private Integer custId;
	private String custName;
	private String email;
	private String password;
	private List<BookingDTO> bookingDTO;
	
	public CustomerDTO(String custName, String email, String password, List<BookingDTO> bookingDTO) {
		this.custName = custName;
		this.email = email;
		this.password = password;
		this.bookingDTO = bookingDTO;
	}
	
}
