package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Writer;
@SuppressWarnings("hiding")
public interface WriterService<Writer>{


				 public List<Writer> retrieveWriters();
				  
				 public Writer  getWriter(Long writerid);
				 
				 public static void deleteWriter(Long writerid) {
					// TODO Auto-generated method stub
					
				}
				  
				 public void updateWriter(Writer writer);

				public void saveWriter(Writer writer);
				}

