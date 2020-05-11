package com.infy.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "flight")
@Getter @Setter @ToString
public class Flight {

	@Id
	@GeneratedValue
	private Integer flightId;
	private String company;
	private String flightModel;
	private String source;
	private String destination;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	private Integer hops;
	private Integer basePrice;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private SeatMatrix seatMatrix;
	
	public Flight(String company, String flightModel, String source, String destination, LocalDateTime departure, LocalDateTime arrival,
			SeatMatrix seatMatrix, Integer hops, Integer basePrice) {
		this.company = company;
		this.flightModel = flightModel;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
		this.seatMatrix = seatMatrix;
		this.hops = hops;
		this.basePrice = basePrice;
	}
	
	public Flight() {
		
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
//	public SeatMatrix getSeatMatrix() {
//		return seatMatrix;
//	}
//
//	public void setSeatMatrix(SeatMatrix seatMatrix) {
//		this.seatMatrix = seatMatrix;
//	}
}
