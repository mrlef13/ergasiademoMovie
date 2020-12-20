package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Director;
@SuppressWarnings("hiding")
public interface DirectorService<Director>{


				 public List<Director> retrieveDirectors();
				  
				 public Director  getDirector(Long directorid);
				 
				 public static void deleteDirector(Long directorid) {
					// TODO Auto-generated method stub
					
				}
				  
				 public void updateDirector(Director director);

				public void saveDirector(Director director);
				}

