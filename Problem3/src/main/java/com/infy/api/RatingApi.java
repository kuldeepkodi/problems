package com.infy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dao.RatingDao;

@RestController
@RequestMapping("/api/rest")
public class RatingApi {
	
	@Autowired
	private RatingDao dao;

	// CUSTOMERS CAN GIVE RATING TO DESIRED MOVIE
	// I'VE NOT SET THE CONSTRAINT FOR RATING TO BE BETWEEN 1 AND 5	
	@PostMapping("/customer/rate/{custId}/{movieId}/{rating}")
	public String addNewRating(@PathVariable Integer custId, 
			@PathVariable Integer movieId, @PathVariable Integer rating) {
		dao.addNewRating(custId, movieId, rating);
		return "Success";
	}
	
	// TO FETCH THE HISHEST RATED MOVIE
	@GetMapping("/bestMovie")
	public String getHighestRatedMovie() {
		return dao.getHighestRatedMovie();
	}
	
	// TO FETCH THE CUSTOMER WHO HAS GIVEN MAXIMUM NUMBER OF RATINGS
	// METHOD RETURNS AN ARRAY OF OBJECT WHICH CONTAINS 
	// THE CUSTOMER OBJECT, CUSTOMER'S AVERAGE RATING AND OVERALL AVERAGE RATING SEQUENTIALLY
	@GetMapping("/getCustomer")
	public Object[] getCustomer() {
		return dao.getCustomer();
	}
	
}
