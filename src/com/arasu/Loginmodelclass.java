package com.arasu;

import javax.xml.bind.annotation.XmlElement;

public class Loginmodelclass {
	@XmlElement(name="UserEmail")

	public String userEmail;
	@XmlElement(name="Password")

	public String password;
	public Loginmodelclass(){
		
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
