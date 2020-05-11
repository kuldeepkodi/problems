package com.infy.utility;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.infy.dto.FlightDTO;
import com.infy.dto.SeatMatrixDTO;
import com.infy.entity.Flight;
import com.infy.entity.SeatMatrix;

@Mapper
public interface FlightMapper {

	@Mapping(target = "seatMatrixDTO", source = "flight.seatMatrix")
	FlightDTO flightToFlightDTO(Flight flight);
	
	@Mapping(target = "seatMatrix", source = "flightDTO.seatMatrixDTO")
	Flight flightDTOToFlight(FlightDTO flightDTO);
	
	SeatMatrixDTO seatMatrixToSearMatrixDTO(SeatMatrix seatMatrix);
	SeatMatrix seatMatrixDTOToSearMatrix(SeatMatrixDTO seatMatrixDTO);
	
}
