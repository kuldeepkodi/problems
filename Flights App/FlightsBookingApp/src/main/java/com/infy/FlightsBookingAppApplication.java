package com.infy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.infy.service.CustomerBookingService;

@SpringBootApplication
public class FlightsBookingAppApplication implements CommandLineRunner {

	@Autowired
	CustomerBookingService service;
	public static void main(String[] args) {
		SpringApplication.run(FlightsBookingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.addDefaultData();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
