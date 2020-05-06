package com.infy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infy.entity.Customer;
import com.infy.entity.Movie;
import com.infy.entity.Rating;

@Repository
@Transactional
public class RatingDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addNewRating(Integer custId, Integer movieId, Integer ratingValue) {
		// GET CUSTOMER AND MOVIE ENTITES USING THE PRIMARY KEYS AND PERSIST NEW RATING ENTITY
		Customer customer = entityManager.find(Customer.class, custId);
		Movie movie = entityManager.find(Movie.class, movieId);
		Rating rating = new Rating(customer, movie, ratingValue);
		entityManager.persist(rating);
	}
	
	public String getHighestRatedMovie() {
		// TO FETCH MAXIMUM OF AVERAGE RATING FOR EACH MOVIE
		Query query = entityManager.createQuery("select MAX(AVG(r.rating)) from Rating r GROUP BY r.movie");
		Double maxRating = (Double) query.getResultList().get(0);
		
		// TO FETCH THE MOVIE NAME USING THE ABOVE RESULT
		Query query2 = entityManager.createQuery("select r.movie.name from Rating r GROUP BY r.movie.name HAVING AVG(r.rating) = :max");
		query2.setParameter("max", maxRating);
		String name = (String)query2.getResultList().get(0);
		return name;
	}
	
	public Object[] getCustomer() {
		// TO FETCH OVERALL AVERAGE RATING
		Query query1 = entityManager.createQuery("select AVG(r.rating) from Rating r");
		Double avg = (Double) query1.getResultList().get(0);
		
		// TO FETCH MAXIMUM COUNT OF RATING OF EACH CUSTOMER
		Query query2 = entityManager.createQuery("select MAX(COUNT(r)) from Rating r GROUP BY r.customer");
		Long maxCount = (Long) query2.getResultList().get(0);
		
		// TO FETCH THE CUSTOMER WHO HAS GIVEN RATING MAXIMUM NUMBER OF TIMES
		Query query3 = entityManager.createQuery("select r.customer.id from Rating r GROUP BY r.customer.id HAVING COUNT(r) = :max");
		query3.setParameter("max", maxCount);
		Integer custId = (Integer) query3.getResultList().get(0);
		Customer customer = entityManager.find(Customer.class, custId);
		
		//TO FETCH THE AVERAGE RATING OF ABOVE FETCHED CUSTOMER
		Query query4 = entityManager.createQuery("select AVG(r.rating) from Rating r WHERE r.customer.custId = :custId");
		query4.setParameter("custId", custId);
		Double custAvgRating = (Double) query4.getResultList().get(0);
		return new Object[] {customer, custAvgRating, avg};
	}
	
}
