package com.infy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.entity.Customer;

@Repository
public interface CustomerBookingRepo extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByEmail(String email);
	
}
