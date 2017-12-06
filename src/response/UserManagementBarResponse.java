package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.UserManagementBarModel;

public class UserManagementBarResponse {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	
	@XmlElement(name="VenueName")
	public String venueName;
	
	@XmlElement(name="Country")
	public String country;
	@XmlElement(name="Password")
	public String password;
	
	@XmlElement(name="UserManagementList")

	public ArrayList<UserManagementBarModel>userManagementList=new ArrayList<UserManagementBarModel>();
	public UserManagementBarResponse(){
		
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
	
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<UserManagementBarModel> getUserManagementList() {
		return userManagementList;
	}
	public void setUserManagementList(
			ArrayList<UserManagementBarModel> userManagementList) {
		this.userManagementList = userManagementList;
	}
	

}
