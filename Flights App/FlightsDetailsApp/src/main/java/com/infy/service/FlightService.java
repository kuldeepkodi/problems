package com.infy.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.FlightRepo;
import com.infy.dto.FlightDTO;
import com.infy.dto.SeatMatrixDTO;
import com.infy.entity.Flight;
import com.infy.entity.SeatMatrix;
import com.infy.utility.FlightMapper;

@Service
@Transactional
public class FlightService {
	
	private	FlightMapper mapper = Mappers.getMapper(FlightMapper.class);

	@Autowired
	private FlightRepo flightRepo;
		
	public List<FlightDTO> getAllFlights() {
		List<Flight> flights = flightRepo.findAll();
		List<FlightDTO> flightDTOs = new ArrayList<>();
		flights.forEach(flight -> {
			FlightDTO flightDTO = mapper.flightToFlightDTO(flight);
			flightDTOs.add(flightDTO);
		});
		return flightDTOs;
	}
	
	public FlightDTO getStatus(Integer flightId) {
		Flight flight = flightRepo.findById(flightId).get();
		return mapper.flightToFlightDTO(flight);
	}
	
	public SeatMatrixDTO getSeatMatrix(Integer flightId) {
		SeatMatrix seatMatrix = flightRepo.findById(flightId).get().getSeatMatrix();
		return mapper.seatMatrixToSearMatrixDTO(seatMatrix);
	}
	
	public void addDefaultData() {
		List<Flight> sampleData = new ArrayList<>();
		
		SeatMatrix seatMatrix1 = new SeatMatrix(40, 20, 15);		
		LocalDateTime departure1 = LocalDateTime.of(2020, 6, 1, 8, 00);
		LocalDateTime arrival1 = LocalDateTime.of(2020, 6, 1, 11, 00);
		Flight flight1 = new Flight("Indigo", "IND-123", "Bengaluru", "Delhi", departure1, arrival1, seatMatrix1, 0, 2500);
		sampleData.add(flight1);
		
		SeatMatrix seatMatrix6 = new SeatMatrix(40, 20, 15);		
		LocalDateTime departure6 = LocalDateTime.of(2020, 6, 1, 13, 00);
		LocalDateTime arrival6 = LocalDateTime.of(2020, 6, 1, 18, 45);
		Flight flight6 = new Flight("Indigo", "IND-789", "Delhi", "Bengaluru", departure6, arrival6, seatMatrix6, 1, 3200);
		sampleData.add(flight6);
		
		SeatMatrix seatMatrix2 = new SeatMatrix(20, 19, 12);		
		LocalDateTime departure2 = LocalDateTime.of(2020, 6, 1, 13, 00);
		LocalDateTime arrival2 = LocalDateTime.of(2020, 6, 1, 14, 15);
		Flight flight2 = new Flight("Go India", "GO-101", "Mumbai", "Kolkata", departure2, arrival2, seatMatrix2, 0, 1800);
		sampleData.add(flight2);
		
		SeatMatrix seatMatrix7 = new SeatMatrix(20, 19, 12);		
		LocalDateTime departure7 = LocalDateTime.of(2020, 6, 2, 6, 00);
		LocalDateTime arrival7 = LocalDateTime.of(2020, 6, 2, 7, 35);
		Flight flight7 = new Flight("Go India", "GO-302", "Kolkata", "Mumbai", departure7, arrival7, seatMatrix7, 1, 2700);
		sampleData.add(flight7);
		
		SeatMatrix seatMatrix3 = new SeatMatrix(32, 10, 9);		
		LocalDateTime departure3 = LocalDateTime.of(2020, 6, 1, 23, 00);
		LocalDateTime arrival3 = LocalDateTime.of(2020, 6, 2, 6, 00);
		Flight flight3 = new Flight("Spice Jet", "SJ-056", "Bengaluru", "Delhi", departure3, arrival3, seatMatrix3, 1, 2850);
		sampleData.add(flight3);
		
		SeatMatrix seatMatrix8 = new SeatMatrix(32, 10, 9);		
		LocalDateTime departure8 = LocalDateTime.of(2020, 6, 2, 15, 00);
		LocalDateTime arrival8 = LocalDateTime.of(2020, 6, 3, 11, 00);
		Flight flight8 = new Flight("Spice Jet", "SJ-981", "Delhi", "Bengaluru", departure8, arrival8, seatMatrix8, 1, 2925);
		sampleData.add(flight8);
		
		SeatMatrix seatMatrix4 = new SeatMatrix(7, 15, 18);		
		LocalDateTime departure4 = LocalDateTime.of(2020, 6, 1, 16, 20);
		LocalDateTime arrival4 = LocalDateTime.of(2020, 6, 1, 17, 00);
		Flight flight4 = new Flight("India Airlines", "IA-456", "Chennai", "Bengaluru", departure4, arrival4, seatMatrix4, 1, 1300);
		sampleData.add(flight4);
		
		SeatMatrix seatMatrix9 = new SeatMatrix(7, 15, 18);		
		LocalDateTime departure9 = LocalDateTime.of(2020, 6, 2, 7, 00);
		LocalDateTime arrival9 = LocalDateTime.of(2020, 6, 1, 10, 10);
		Flight flight9 = new Flight("India Airlines", "IA-021", "Bengaluru", "Chennai", departure9, arrival9, seatMatrix9, 1, 1280);
		sampleData.add(flight9);
		
		SeatMatrix seatMatrix5 = new SeatMatrix(40, 20, 15);		
		LocalDateTime departure5 = LocalDateTime.of(2020, 6, 1, 18, 00);
		LocalDateTime arrival5 = LocalDateTime.of(2020, 6, 2, 9, 45);
		Flight flight5 = new Flight("Air Asia", "AA-007", "Hyderabad", "Varanasi", departure5, arrival5, seatMatrix5, 1, 2250);
		sampleData.add(flight5);
		
		SeatMatrix seatMatrix10 = new SeatMatrix(40, 20, 15);		
		LocalDateTime departure10 = LocalDateTime.of(2020, 6, 2, 14, 00);
		LocalDateTime arrival10 = LocalDateTime.of(2020, 6, 2, 22, 00);
		Flight flight10 = new Flight("Air Asia", "AA-502", "Varanasi", "Hyderabad", departure10, arrival10, seatMatrix10, 0, 1750);
		sampleData.add(flight10);
		
		flightRepo.saveAll(sampleData);
	}
}
