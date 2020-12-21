package com.example.demo.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Entity.Movie;
import com.example.demo.Entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;	
	
	@Override
	public Long login(String username, String pass) {
	Long userid = null;
		List<User> users=userRepository.findAll();
		boolean flag=false;		
		for (User u : users) {			
			if(u.getUsername().equals(username) && u.getPassword().equals(pass) ) {							
				userid= u.getUserid();
				break;
			}
		}  				
		return userid;
	}
	
	public User retrieveUser(Long userid) {
		 Optional<User> optUser = userRepository.findById(userid);
		  return optUser.get();
	}
	
	public void saveUser(User user) {
		User u= userRepository.save(user);
	}



}
