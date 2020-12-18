package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Movie;


@SuppressWarnings("hiding")
public interface MovieService<Movie> {


			 public List<Movie> retrieveMovies();
			  
			 public com.example.demo.Entity.Movie  getMovie(Long movieId);
			 public void deleteMovie(Long movieId);
			  
			 public void updateMovie(Movie movie); /* den kserw an xreizetai*/

			void saveMovie(com.example.demo.Entity.Movie movie);
			}

