package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
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
@JoinColumn(name="userid")
private Set<User> users=new HashSet<User>();
//private User user=new User();
@ManyToMany
private Set<Writer> writers=new HashSet<Writer>();
@ManyToMany
private Set<Director> diretctors=new HashSet<Director>();

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

	public void addUser(User user) {
		users.add(user);		
		//this.user=user;
	}

	public Set<Director> getDiretctors() {
		return diretctors;
	}

	public void setDiretctors(Set<Director> diretctors) {
		this.diretctors = diretctors;
	}
	
	
}
