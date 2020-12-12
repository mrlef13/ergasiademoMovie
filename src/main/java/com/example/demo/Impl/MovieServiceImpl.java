package com.example.demo.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Movie;
import com.example.demo.Service.MovieService;
import com.example.demo.Repository.MovieRepository;


@Service
public class MovieServiceImpl implements MovieService{
	
@Autowired
	private MovieRepository movieRepository;	

public void setMovieRepository(MovieRepository movieRepository) {
	  this.movieRepository = movieRepository;
	 }
public List<Movie> retrieveMovies() {
	  List<Movie> movies = movieRepository.findAll();
	  return movies;
	 }
	  
	 public Movie getMovie(Long movieId) {
		System.out.println("In getMovie");
	  Optional<Movie> optEmp = movieRepository.findById(movieId);
	  return optEmp.get();
	 }

/*mphkan apo mones tous*/



@Override
public void saveMovie(Movie movie) {
	Movie m= movieRepository.save(movie);
}


public void deleteMovie(Long movieId) {
	System.out.println("In deleteMovie");
	movieRepository.deleteById(movieId);	
}


@Override
public void updateMovie(Object movie) {
	// TODO Auto-generated method stub
	
}

}
