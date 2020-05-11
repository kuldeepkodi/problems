package com.infy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{

	
	
}
