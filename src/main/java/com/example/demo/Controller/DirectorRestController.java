package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.Director;
import com.example.demo.Service.DirectorService;
import com.example.demo.Service.MovieService;



@RestController
public class DirectorRestController {
	

	@Autowired
	private DirectorService writerService;
	@Autowired
	private MovieService movieService;
		
		@GetMapping("/api/directors")
		public List<Director> getWriters() {
			  List<Director> writers = writerService.retrieveDirectors();
			  return writers;
		}
			  
		@GetMapping("/api/directors/{directorId}")
		   public Director getDirector(@PathVariable(name="directorId")Long directorId) {			
			 return (Director) writerService.getDirector(directorId);
			  }
			  
		@PostMapping("/api/directors")
		public void saveDirector(Director director){
			writerService.saveDirector(director);		 
		}
			  
		@DeleteMapping("/api/directors/{directorId}")
		public void deleteWriter(@PathVariable(name="directorId")Long directorId){			
			DirectorService.deleteDirector(directorId);		 
		}
		 
		@PutMapping("/api/directors/")
		public void updateWriter(@RequestParam(name="directorId")Long directorId, @RequestParam(name="movieId")Long movieId) {
			Director director = (Director) writerService.getDirector(directorId);
			Movie movie =  (Movie) movieService.getMovie(movieId);
			if(movie != null && director != null)
			{
				
			 writerService.updateDirector(director);		
		  }
		}	
	}
	