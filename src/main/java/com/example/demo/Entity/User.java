package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userid;
	@Column(name="USERNAME")
	private String username;
	@Column(name="USERPASS")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinColumn(name="movieid")
	private Set<Movie> movies=new HashSet<Movie>();
	
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {}
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void removeMovie(Movie movie) {		
		for(Movie m:movies) {
			if(m==movie) {
				movies.remove(movie);
				break;
			}			
		}		
	}
	
}
