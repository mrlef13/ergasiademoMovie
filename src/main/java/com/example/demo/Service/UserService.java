package com.example.demo.Service;


@SuppressWarnings("hiding")
public interface UserService<User> {
	
	public boolean login(String username,String pass);
	public com.example.demo.Entity.User retrieveUser(Long userid);
	public void saveUser(com.example.demo.Entity.User user);

}
