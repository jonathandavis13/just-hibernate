package com.jh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.dao.MovieDao;
import com.jh.model.Movie;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	public Movie persist(Movie movie){
		return movieDao.persist(movie);
	}

}
