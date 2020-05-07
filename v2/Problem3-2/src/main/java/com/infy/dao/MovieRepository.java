package com.infy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	public Movie findByName(String name);
}
