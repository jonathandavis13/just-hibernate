package com.jh;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.jh.model.Movie;

public class BasicMovieManager {
	private SessionFactory sessionFacotry = null;
	
	public BasicMovieManager (){
		initSessionFacotry();
	}
	
	private void initSessionFacotry(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFacotry = config.buildSessionFactory(serviceRegistry);		
	}
	
	private void persistMovie(Movie movie){
		Session session = sessionFacotry.getCurrentSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
	}
	
	private Movie findMovie(long movieId){
		Session session = sessionFacotry.getCurrentSession();
		session.beginTransaction();
		Movie movie = (Movie) session.load(Movie.class, movieId);
		session.getTransaction().commit();
		return movie;
	}
	
	private List<Movie> findAll(){
		Session session = sessionFacotry.getCurrentSession();
		session.beginTransaction();
		List<Movie> movies = session.createQuery("from movie").list();
		session.getTransaction().commit();
		return movies;
	}
	
	public static void main(String[] args){
		BasicMovieManager basicMovieManager = new BasicMovieManager();
		
		Movie ironMan = new Movie();
		ironMan.setDirector("Jon Favreau");
		ironMan.setSynopsis("After being held captive in an Afghan cave, a billionaire engineer creates a unique weaponized suit of armor to fight evil.");
		ironMan.setTitle("Iron Man");
		basicMovieManager.persistMovie(ironMan);
		
		Movie manOfSteel = new Movie();
		manOfSteel.setDirector("Zach Snyder");
		manOfSteel.setTitle("Man of Steel");
		manOfSteel.setSynopsis("Clark Kent, one of the last of an extinguished race disguised as an unremarkable human, is forced to reveal his identity when Earth is invaded by an army of survivors who threaten to bring the planet to the brink of destruction.");
//		basicMovieManager.persistMovie(manOfSteel);
		
		System.out.println(String.format("MOVIE: %S", basicMovieManager.findMovie(0).getTitle()));
		
	}

}
