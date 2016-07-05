package com.jh;


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
	
	public static void main(String[] args){
		BasicMovieManager basicMovieManager = new BasicMovieManager();
		
		Movie movie = new Movie();
		movie.setDirector("Jon Favreau");
		movie.setSynopsis("After being held captive in an Afghan cave, a billionaire engineer creates a unique weaponized suit of armor to fight evil.");
		movie.setTitle("Iron Man");
		basicMovieManager.persistMovie(movie);
	}

}
