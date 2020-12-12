package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Movie;


@SuppressWarnings("hiding")
public interface MovieService<Movie> {


			 public List<Movie> retrieveMovies();
			  
			 public Movie  getMovie(Long movieId);
			  
			 public void saveMovie(Movie movie);
			  
			 public void deleteMovie(Long movieId);
			  
			 public void updateMovie(Movie movie); /* den kserw an xreizetai*/
			}

