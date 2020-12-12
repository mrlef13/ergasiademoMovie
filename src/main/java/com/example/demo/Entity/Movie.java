package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;

@Column(name="TITLE")
private String title;

@Column(name="IMDB_ID")
private int imdbid;
 
@Column(name="WRITER")
private String writer;
 
@Column(name="DIRECTOR")
private String director;

     public Long getId() {
	  return id;
	 }
	 
	 public void setId(Long id) {
	  this.id = id;
	 }
	 
	 public String getTitle() {
	  return title;
	 }
	 
	 public void setTitle(String title) {
	  this.title = title;
	 }
	 
	 public int getImdbID() {
	  return imdbid;
	 }
	 
	 public void setImdbID(int imdbid) {
	  this.imdbid = imdbid;
	 }
	 
	 public String getWriter() {
	  return writer;
	 }
	 
	 public void setWriter(String writer) {
	  this.writer = writer;
	 }
	 
	 public String getDirector() {
	  return director;
		 }
		 
	public void setDirector(String director) {
	 this.director = director;
		 }
}
