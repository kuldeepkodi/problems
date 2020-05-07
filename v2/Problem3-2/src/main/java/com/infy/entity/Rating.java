package com.infy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Kuldeep Kodi
 *
 */
@Entity
public class Rating implements Serializable{

	@Id
	@GeneratedValue
	private Integer id;
	private Integer rating;
	
	public Rating(Integer rating) {
		this.rating = rating;
	}
	
	public Rating() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
