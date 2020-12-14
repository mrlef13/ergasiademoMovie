package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long movieid;

@Column(name="TITLE")
private String title;

@Column(name="IMDBID")
private String imdbid;
 
@Column(name="WRITER")
private String writer;
 
@Column(name="DIRECTOR")
private String director;

@ManyToMany
private Set<User> users=new HashSet<User>();

     public Long getId() {
	  return movieid;
	 }
	 
	 public void setId(Long id) {
	  this.movieid = id;
	 }
	 
	 public String getTitle() {
	  return title;
	 }
	 
	 public void setTitle(String title) {
	  this.title = title;
	 }
	 
	 public String getImdbid() {
	  return imdbid;
	 }
	 
	 public void setImdbid(String imdbid) {
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
