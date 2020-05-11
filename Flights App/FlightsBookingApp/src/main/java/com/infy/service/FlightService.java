package com.infy.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.dto.FlightDTO;
import com.infy.dto.SeatMatrixDTO;

@Service
public class FlightService {
	
	@Autowired
	Environment environment;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<FlightDTO> getAllScheduledFlights() {
		
		String url = environment.getProperty("flight_details") + "/get";
		FlightDTO[] flights = restTemplate.getForObject(url, FlightDTO[].class);
		return Arrays.asList(flights);
		
	}
	
	public List<FlightDTO> getFlightsBySourceAndDestination(String source, String destination) {
		
		List<FlightDTO> flights = getAllScheduledFlights();
		
		return flights.stream()
				.filter(f -> f.getSource().equals(source) && f.getDestination().equals(destination))
				.sorted((f1, f2) -> f1.getBasePrice().compareTo(f2.getBasePrice()))
				.collect(Collectors.toList());
	}
	
	public List<FlightDTO> getFlightsByCompany(String company) {
		
		List<FlightDTO> flights = getAllScheduledFlights();
		
		List<String> companyList = Arrays.stream(company.split(","))
			.collect(Collectors.toList());
		
		return flights.stream()
			.filter(f -> companyList.contains(f.getCompany()))
			.collect(Collectors.toList());
	}
	
	public List<FlightDTO> getFlightsSorted(List<FlightDTO> flights, String sort) {
		
		List<String> sortList = Arrays.stream(sort.split(","))
				.collect(Collectors.toList());
		
		Comparator<FlightDTO> priceComarator = Comparator.comparing(f -> f.getBasePrice());
		Comparator<FlightDTO> hopsComarator = Comparator.comparing(f -> f.getHops());
		
		if(sortList.contains("price")) {
			flights.sort(priceComarator);
		}
		if(sortList.contains("hops")) {
			flights.sort(hopsComarator);
		}		
		
		return flights;
	}
	
	public FlightDTO getFlightStatus(Integer flightId) {
		String url = environment.getProperty("flight_details") + "/get/" + flightId + "/status";
		return restTemplate.getForObject(url, FlightDTO.class);
	}
	
	public SeatMatrixDTO getFlightSeatMatrix(Integer flightId) {
		String url = environment.getProperty("flight_details") + "/get/" + flightId + "/seatMatrix";
		return restTemplate.getForObject(url, SeatMatrixDTO.class);
	}
	
	// extras
	
//	public List<FlightDTO> getFlightsByPriceSorted(List<FlightDTO> flights, Integer price) {
//		
//		return flights.stream()
//					.filter(f -> f.getBasePrice() <= price)
//					.sorted((f1, f2) -> f1.getBasePrice().compareTo(f2.getBasePrice()))
//					.collect(Collectors.toList());
//	}
//	
//	public List<FlightDTO> getFlightsByHopsSorted(List<FlightDTO> flights, Integer hops) {
//		
//		return flights.stream()
//					.filter(f -> f.getHops() <= hops)
//					.sorted((f1, f2) -> f1.getHops().compareTo(f2.getHops()))
//					.collect(Collectors.toList());
//	}
//	
//	public List<FlightDTO> getFlightsFiltered(String company, Integer price, Integer hops) {
//		
//		List<FlightDTO> flights = getAllScheduledFlights();
//		
//		if(!company.isEmpty()) flights = getFlightsByCompany(company);
//		if(price != null) flights = getFlightsByPriceSorted(flights, price);
//		if(hops != null) flights = getFlightsByHopsSorted(flights, price);
//		
//		return flights;
//	}
	
}
