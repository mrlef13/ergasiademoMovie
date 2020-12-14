package com.example.Webentity;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="user")
//@XmlRootElement
public class Webuser {
	
	public String username;
	public String pass;
	
	
	public Webuser(String username,String pass) {
		this.username=username;
		this.pass=pass;
	}
}
