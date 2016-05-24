package com.jh.moviemanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Movie {
	
	private long id;
	private String title;
	private String synopsis;
	private String director;

}
