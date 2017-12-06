package com.arasu;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class LiquorResponse {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="UserList")

	public List<LiquorDataClass>userList;
	public LiquorResponse(){
		
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<LiquorDataClass> getUserList() {
		return userList;
	}
	public void setUserList(List<LiquorDataClass> userList) {
		this.userList = userList;
	}
	
	
	
	
}
