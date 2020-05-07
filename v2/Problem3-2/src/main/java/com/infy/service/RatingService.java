package com.infy.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.CustomerRepository;
import com.infy.dao.MovieRepository;
import com.infy.dao.RatingRepository;
import com.infy.entity.Customer;
import com.infy.entity.Movie;
import com.infy.entity.Rating;

@Service
@Transactional
public class RatingService {

	@Autowired
	private RatingRepository ratingRepo;

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private MovieRepository movieRepo;

	public String addRating(Integer custId, String name, Integer rating) {
		Customer customer = custRepo.findById(custId).get();

		Movie movie = movieRepo.findByName(name);

		Rating newRating = new Rating(rating);
		ratingRepo.save(newRating);

		customer.getRatings().add(newRating);
		movie.getRatings().add(newRating);

		return "New rating added";
	}

	public String getHighestRatedMovie() {
		List<Movie> movies = movieRepo.findAll();
		
		Map<String, Double> averageRateByMovie = new HashMap<>();		
		movies.forEach(m -> {
			Double average = m.getRatings().stream()
					.mapToInt(Rating::getRating).average().getAsDouble();
			averageRateByMovie.put(m.getName(), average);
		});
		
		Map<String, Double> averageRateByMovieSorted = new LinkedHashMap<>();		
		averageRateByMovie.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(e -> averageRateByMovieSorted.put(e.getKey(), e.getValue()));
		
		return averageRateByMovieSorted.keySet().iterator().next();
	}
	
	public Customer getHighestRatingCustomer() {
		List<Customer> customers = custRepo.findAll();
		
		Map<Customer, Integer> highestRatingByCustomer = new HashMap<>();
		customers.forEach(c-> {
			Integer count = c.getRatings().size();
			highestRatingByCustomer.put(c, count);
		});
		
		Map<Customer, Integer> highestRatingByCustomerSorted = new LinkedHashMap<>();
		highestRatingByCustomer.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEachOrdered(e -> highestRatingByCustomerSorted.put(e.getKey(), e.getValue()));
		
		return highestRatingByCustomerSorted.keySet().iterator().next();
	}
	
	public Double getOverallAverageRating() {
		List<Rating> ratings = ratingRepo.findAll();
		return ratings.stream().mapToInt(Rating::getRating).average().getAsDouble();
	}
	
	public Double getAverageRatingOfCustomer(Integer custId) {
		Customer customer = custRepo.findById(custId).get();
		return customer.getRatings().stream()
				.mapToInt(Rating::getRating).average().getAsDouble();
	}

}
