package com.eprakash.learn.microservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value={"userName","address"})
public class StaticFilteredBean {
	
	private String userName;
	@JsonIgnore
	private String password;
	private String email;
	private String address;
	
	
	public StaticFilteredBean(String userName, String password, String email, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
