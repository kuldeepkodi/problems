package com.infy.utility;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.infy.dto.BookingDTO;
import com.infy.dto.CustomerDTO;
import com.infy.entity.Booking;
import com.infy.entity.Customer;

@Mapper
public interface CustomerMapper {

	@Mapping(target = "booking", source = "customerDTO.bookingDTO")
	Customer CustomerDTOToCustomer(CustomerDTO customerDTO);
	
	@Mapping(target = "bookingDTO", source = "customer.booking")
	CustomerDTO CustomerToCustomerDTO(Customer customer);
	
	Booking BookingDTOToBooking(BookingDTO bookingDTO);
	BookingDTO BookingToBooking(Booking booking);
}
