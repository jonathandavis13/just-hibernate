package com.jh.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jh.model.Movie;


@Repository
public class MovieDao {
	
	@PersistenceContext
	private EntityManager entityManger;
	
	public Movie persist(Movie movie){
		entityManger.persist(movie);
		return movie;
	}
	
	public Movie read(Movie movie){
		Movie instance = entityManger.find(Movie.class, movie.getId());
		return instance;
	}
	
	public void delete(Movie movie){
		entityManger.remove(movie);
	}

}
