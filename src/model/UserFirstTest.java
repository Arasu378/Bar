package model;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserFirstTest {
	@XmlElement(name="IsSucess")
	public boolean isSucess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="UserList")

	public List<UserTest>userList;
	
public UserFirstTest(){
	
}

public boolean getIsSucess() {
	return isSucess;
}

public void setIsSucess(boolean isSucess) {
	this.isSucess = isSucess;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public List<UserTest> getUserList() {
	return userList;
}

public void setUserList(List<UserTest> userList) {
	this.userList = userList;
}

}
