package com.userapp.java.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRequestDto {
	
	@NotEmpty(message="username cannot be empty")
	private String userName;
	
	@NotEmpty(message="phone number cannot be empty")
	@Size(min=10,max=10,message="phone num should be 10 digits")
	private String phoneNumber;
	
	@Email(message="email entered is wrong")
	private String emailId;	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
