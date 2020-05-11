package com.infy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.CustomerBookingRepo;
import com.infy.dto.CustomerDTO;
import com.infy.entity.Booking;
import com.infy.entity.Customer;
import com.infy.utility.CustomerMapper;

@Service
@Transactional
public class CustomerBookingService {
	private CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

	@Autowired
	private CustomerBookingRepo customerBookingRepo;
	
	public void addDefaultData() {
		List<Customer> customersData = new ArrayList<>();
		
		Booking booking1 = new Booking(1);
		Customer customer1 = new Customer("Adam Gilchrist", "adam@test.com", "Adam@123", Arrays.asList(booking1));
		customersData.add(customer1);
		
		Booking booking2 = new Booking(3);
		Customer customer2 = new Customer("Brad Pitt", "brad@test.com", "Brad@123", Arrays.asList(booking2));
		customersData.add(customer2);
		
		Booking booking3 = new Booking(5);
		Customer customer3 = new Customer("Chris Hemsworth", "chris@test.com", "Chris@123", Arrays.asList(booking3));
		customersData.add(customer3);
		
		customerBookingRepo.saveAll(customersData);
	}

}
