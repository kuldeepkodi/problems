package com.infy.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
@NoArgsConstructor
public class FlightDTO {

	private Integer flightId;
	private String company;
	private String flightModel;
	private String source;
	private String destination;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private Integer hops;
	private SeatMatrixDTO seatMatrixDTO;
	private Integer basePrice;
	
	public FlightDTO(String company, String flightModel, String source, String destination, LocalDateTime departure, LocalDateTime arrival,
			SeatMatrixDTO seatMatrixDTO, Integer hops, Integer basePrice) {
		this.company = company;
		this.flightModel = flightModel;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.seatMatrixDTO = seatMatrixDTO;
		this.hops = hops;
		this.basePrice = basePrice;
	}

//	public Integer getFlightId() {
//		return flightId;
//	}
//
//	public void setFlightId(Integer flightId) {
//		this.flightId = flightId;
//	}
//
//	public String getFlightModel() {
//		return flightModel;
//	}
//
//	public void setFlightModel(String flightModel) {
//		this.flightModel = flightModel;
//	}
//
//	public String getSource() {
//		return source;
//	}
//
//	public void setSource(String source) {
//		this.source = source;
//	}
//
//	public String getDestination() {
//		return destination;
//	}
//
//	public void setDestination(String destination) {
//		this.destination = destination;
//	}
//
//	public LocalDateTime getDeparture() {
//		return departure;
//	}
//
//	public void setDeparture(LocalDateTime departure) {
//		this.departure = departure;
//	}
//
//	public LocalDateTime getArrival() {
//		return arrival;
//	}
//
//	public void setArrival(LocalDateTime arrival) {
//		this.arrival = arrival;
//	}
//
//	public Integer getHops() {
//		return hops;
//	}
//
//	public void setHops(Integer hops) {
//		this.hops = hops;
//	}
//
//	public SeatMatrixDTO getSeatMatrixDTO() {
//		return seatMatrixDTO;
//	}
//
//	public void setSeatMatrixDTO(SeatMatrixDTO seatMatrixDTO) {
//		this.seatMatrixDTO = seatMatrixDTO;
//	}
}
