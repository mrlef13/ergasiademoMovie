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
import com.example.demo.Entity.Writer;
import com.example.demo.Service.WriterService;
import com.example.demo.Service.MovieService;



@RestController
public class WriterRestController {
	

	@Autowired
	private WriterService writerService;
	@Autowired
	private MovieService movieService;
		
		@GetMapping("/api/writers")
		public List<Writer> getWriters() {
			  List<Writer> writers = writerService.retrieveWriters();
			  return writers;
		}
			  
		@GetMapping("/api/writers/{writerId}")
		   public Writer getWriter(@PathVariable(name="writerId")Long writerId) {			
			 return (Writer) writerService.getWriter(writerId);
			  }
			  
		@PostMapping("/api/writers")
		public void saveWriter(Writer writer){
			writerService.saveWriter(writer);		 
		}
			  
		@DeleteMapping("/api/writers/{writerId}")
		public void deleteWriter(@PathVariable(name="writerId")Long writerId){			
			WriterService.deleteWriter(writerId);		
		}
		 
		@PutMapping("/api/writers/")
		public void updateWriter(@RequestParam(name="writerId")Long writerId, @RequestParam(name="movieId")Long movieId) {
			Writer writer = (Writer) writerService.getWriter(writerId);
			Movie movie =  (Movie) movieService.getMovie(movieId);
			if(movie != null && writer != null)
			{				
			 writerService.updateWriter(writer);		
		  }
		}	
	}
	