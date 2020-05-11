package com.infy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.service.FlightService;

@SpringBootApplication
public class FlightsDetailsAppApplication implements CommandLineRunner{

	@Autowired
	FlightService flightService;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightsDetailsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		flightService.addDefaultData();
	}

}
