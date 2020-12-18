package com.example.demo.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.User;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.UserService;

@RestController
public class ProfileRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private  MovieService movieService;
	
	
	
	@GetMapping("/api/profile/")
	public Set<Movie> getMovies(@RequestParam(name="userid")Long userid) {		
		User user=  userService.retrieveUser(userid);
		Set<Movie> movies = user.getMovies();
		  return movies;
	}
	
	@PutMapping("/api/profile/")
	public void saveMovieToProfile(@RequestParam(name="userid")Long userid,@RequestParam(name="movieid")Long movieid) {		
		System.out.println("profile - in put"+userid+" "+movieid);
		User user=  userService.retrieveUser(userid);
		Movie movie=  movieService.getMovie(movieid);
		boolean alreadyExists=false;		
		if (user !=null && movie !=null) {			
			for(Movie m:user.getMovies()) {
				if(m==movie) {
					alreadyExists=true;
					break;
				}				
			}
			if(!alreadyExists) {
				user.addMovie(movie);
				movie.addUser(user);
			}
		}
		userService.saveUser(user);
		movieService.saveMovie(movie);
	}
	
	
}
