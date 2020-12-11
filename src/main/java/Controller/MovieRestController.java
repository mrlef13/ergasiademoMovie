package Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Service.MovieService;
import Entity.Movie;

@RestController
public class MovieRestController {
	
@Autowired
private MovieService movieService;

public void setMovieService(MovieService movieService) {
	  this.movieService = movieService;
	 }
@GetMapping("/api/movies")
public List<Movie> getMovies() {
	  List<Movie> movies = movieService.retrieveMovies();
	  return movies;
}
	  
@GetMapping("/api/movies/{movieId}")
   public Movie getMovie(@PathVariable(name="movieId")Long movieId) {
	 return movieService.getMovie(movieId);
	  }
	  
@PostMapping("/api/movies")
public void saveMovie(Movie movie){
	movieService.saveMovie(movie);
 System.out.println("Movie Saved Successfully");
}
	  
@DeleteMapping("/api/movies/{moviesId}")
public void deleteMovie(@PathVariable(name="movieId")Long movieId){
movieService.deleteMovie(movieId);
 System.out.println("Movie Deleted Successfully");
}
 
@PutMapping("/api/movies/{movieId}")
public void updateMovie(@RequestBody Movie movie,
  @PathVariable(name="movieId")Long movieId){
	Movie mov = movieService.getMovie(movieId);
 if(mov != null){
	 movieService.updateMovie(movie);
 }
   }
	  
}
