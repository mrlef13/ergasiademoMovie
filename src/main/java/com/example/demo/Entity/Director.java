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
@Table(name="DIRECTOR")
public class Director {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long directorid;
	

	@Column(name="FULLNAME")
	private String name;
	
	
	@ManyToMany
	private Set<Movie> movies=new HashSet<Movie>();

	
	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public Long getDirectorid() {
		return directorid;
	}

	public void setWriterid(Long directorid) {
		this.directorid = directorid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
