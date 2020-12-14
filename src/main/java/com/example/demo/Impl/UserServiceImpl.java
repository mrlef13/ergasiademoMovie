package com.example.demo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;	
	
	@Override
	public boolean login(String username, String pass) {
		List<User> users=userRepository.findAll();
		boolean flag=false;
		System.out.println("in login "+username+", "+pass);
		for (User u : users) {
			System.out.println("in loop "+u.getUsername()+", "+u.getPassword());
			if(u.getUsername().equals(username) && u.getPassword().equals(pass) ) {			
				System.out.println("in if "+u.getUsername()+", "+u.getPassword());
				flag=true;
				break;
			}
		}  				
		return flag;
	}


	

}
