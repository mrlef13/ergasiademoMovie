package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.UserService;


import com.example.demo.Entity.User;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;	

	@PostMapping("/user/login")
	public Long login(User u){
		
		System.out.println("in post "+u.getUsername()+", "+u.getPassword());
	Long userid= userService.login(u.getUsername(),u.getPassword());
	if(userid!=null) {
        return userid;
    }else return null;
	 
	}
	
}
