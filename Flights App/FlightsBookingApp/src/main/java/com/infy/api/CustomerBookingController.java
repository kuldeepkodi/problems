package com.infy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.FlightDTO;
import com.infy.dto.SeatMatrixDTO;
import com.infy.service.FlightService;

@RestController
@RequestMapping("/booking")
public class CustomerBookingController {

	@Autowired
	private FlightService service;
	
	@GetMapping("/all")
	public List<FlightDTO> getAllFlights() {
		return service.getAllScheduledFlights();
	}
	
	@GetMapping("/all/sort")
	public List<FlightDTO> getAllFlightsSorted(@RequestParam("sortBy") String sort) {
		List<FlightDTO> flights = service.getAllScheduledFlights();
		return service.getFlightsSorted(flights, sort);
	}
	
	@GetMapping("/sd")
	public List<FlightDTO> getFlightsBySourceAndDestination(@RequestParam("s") String source,
			@RequestParam("d") String destination) {
		return service.getFlightsBySourceAndDestination(source, destination);
	}
	@GetMapping("/sd/sort")
	public List<FlightDTO> getFlightsBySourceAndDestinationSorted(@RequestParam("s") String source,
			@RequestParam("d") String destination, @RequestParam("sortBy") String sort) {
		List<FlightDTO> flights = service.getFlightsBySourceAndDestination(source, destination);
		return service.getFlightsSorted(flights, sort);
	}
	
	@GetMapping("/company")
	public List<FlightDTO> getFlightsByCompanies(@RequestParam("company") String company) {
		return service.getFlightsByCompany(company);
	}
	@GetMapping("/company/sort")
	public List<FlightDTO> getFlightsByCompaniesSorted(@RequestParam("company") String company,
			@RequestParam("sortBy") String sort) {
		List<FlightDTO> flights = service.getFlightsByCompany(company);
		return service.getFlightsSorted(flights, sort);
	}
	
	@GetMapping("/status/{flightId}")
	public FlightDTO getFlightStatus(@PathVariable Integer flightId) {
		return service.getFlightStatus(flightId);
	}
	
	@GetMapping("/seats/{flightId}")
	public SeatMatrixDTO getFlightSeatMatrix(@PathVariable Integer flightId) {
		return service.getFlightSeatMatrix(flightId);
	}
	
}
