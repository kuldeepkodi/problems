package com.infy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Customer;
import com.infy.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatngApi {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/rate/{custId}/{rating}")
	public String rateMovie(@PathVariable Integer custId, @PathVariable Integer rating,
			@RequestBody String name) {
		return ratingService.addRating(custId, name, rating);
	}

	@GetMapping("/highestRatedMovie")
	public String getAllRatings() {
		return ratingService.getHighestRatedMovie();
	}
	
	@GetMapping("/highestRatingCustomer")
	public Object[] getHighestRatingCustomer() {
		Customer customer = ratingService.getHighestRatingCustomer();
		Double customerAverageRating = ratingService
				.getAverageRatingOfCustomer(customer.getCustId());
		Double overallAverageRating = ratingService.getOverallAverageRating();
		return new Object[] {customer, customerAverageRating, overallAverageRating};
	}
	
}
