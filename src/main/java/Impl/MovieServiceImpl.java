package Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import Entity.Movie;
import Service.MovieService;
import Repository.MovieRepository;
/* na valoume-import kai to repository
 */

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
	  Optional<Movie> optEmp = movieRepository.findById(movieId);
	  return optEmp.get();
	 }

/*mphkan apo mones tous*/


@Override
public void saveMovie(Object movie) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteMovie(Long movieId) {
	// TODO Auto-generated method stub
	
}


public void updateMovie(Movie movie) {
	// TODO Auto-generated method stub
	
}
@Override
public void updateMovie(Object movie) {
	// TODO Auto-generated method stub
	
}

}
