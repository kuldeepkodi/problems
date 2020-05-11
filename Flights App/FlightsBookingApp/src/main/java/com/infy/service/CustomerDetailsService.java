package com.infy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infy.dao.CustomerBookingRepo;
import com.infy.entity.Customer;

@Service
public class CustomerDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerBookingRepo repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = repo.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		return new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
	}

}
