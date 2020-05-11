package com.infy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.FlightDTO;
import com.infy.dto.SeatMatrixDTO;
import com.infy.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightApi {
	
	@Autowired
	private FlightService flightService;

	@GetMapping("/get")
	public List<FlightDTO> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@GetMapping("/get/{flightId}/status")
	public FlightDTO getFlightStatus(@PathVariable Integer flightId) {
		return flightService.getStatus(flightId);
	}
	
	@GetMapping("/get/{flightId}/seatMatrix")
	public SeatMatrixDTO getFlightSeatMatrix(@PathVariable Integer flightId) {
		return flightService.getSeatMatrix(flightId);
	}
}
