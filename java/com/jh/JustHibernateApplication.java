package com.jh;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jh.dao.MovieDao;
import com.jh.model.Movie;

@SpringBootApplication
public class JustHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustHibernateApplication.class, args);
		System.out.println("what¯\\_(ツ)_/¯¯");
		testCreate();
	}
	
	public static void testCreate() {
		MovieDao movieDao = new MovieDao();
		Movie movie = new Movie();
		movie.setDirector("George Roy Hill");
		movie.setTitle("Butch Cassidy and the Sundance Kid");
		movie.setSynopsis("Should need no introduction");
		Movie instance = movieDao.persist(movie);
		System.out.println(instance.getTitle());
	}
}
