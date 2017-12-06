package com.arasu;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class UserFirst {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="UserList")

	public List<User>userList;
	
public UserFirst(){
	
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

public List<User> getUserList() {
	return userList;
}

public void setUserList(List<User> userList) {
	this.userList = userList;
}


}
