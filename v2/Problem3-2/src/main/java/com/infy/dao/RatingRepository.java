package com.infy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
