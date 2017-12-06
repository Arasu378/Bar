package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class UserManagementBarModel {
	@XmlElement(name="Id")

public String id;
	@XmlElement(name="BarId")
	public int barId;

	@XmlElement(name="VenueName")
	public String venueName;
	
	@XmlElement(name="Country")
	public String country;
	@XmlElement(name="Password")
	public String password;
	
	@XmlElement(name="UserProfileId")

public String userProfileId;
	@XmlElement(name="BarName")

public String barName;
	@XmlElement(name="CreatedOn")

public String createdOn;
	@XmlElement(name="ModifiedOn")

public String modifiedOn;
	@XmlElement(name="UserManagementId")

public String userManagementId;
	@XmlElement(name="UserName")

public String userName;
	@XmlElement(name="UserEmail")

public String userEmail;
	@XmlElement(name="UserRole")

public String userRole;
	@XmlElement(name="BarList")

public ArrayList<InsertUserManagementBarModel>barList=new ArrayList<InsertUserManagementBarModel>();
	@XmlElement(name="ParentUserProfileId")
	public String parentUserProfileId;
public UserManagementBarModel(){
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(String userProfileId) {
	this.userProfileId = userProfileId;
}
public String getBarName() {
	return barName;
}
public void setBarName(String barName) {
	this.barName = barName;
}
public String getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(String createdOn) {
	this.createdOn = createdOn;
}
public String getModifiedOn() {
	return modifiedOn;
}
public void setModifiedOn(String modifiedOn) {
	this.modifiedOn = modifiedOn;
}
public String getUserManagementId() {
	return userManagementId;
}
public void setUserManagementId(String userManagementId) {
	this.userManagementId = userManagementId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public ArrayList<InsertUserManagementBarModel> getBarList() {
	return barList;
}
public void setBarList(ArrayList<InsertUserManagementBarModel> barList) {
	this.barList = barList;
}
public int getBarId() {
	return barId;
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
public void setBarId(int barId) {
	this.barId = barId;
}
public String getParentUserProfileId() {
	return parentUserProfileId;
}
public void setParentUserProfileId(String parentUserProfileId) {
	this.parentUserProfileId = parentUserProfileId;
}


}
