package com.arasu;

import javax.xml.bind.annotation.XmlElement;

public class InsertEmailManagementModel {
	@XmlElement(name="Id")

	public int id;
	@XmlElement(name="UserEmail")

	public String userEmail;
	@XmlElement(name="UserProfileId")

	public int userProfileId;
	@XmlElement(name="CreatedOn")

	public String createdOn;
	@XmlElement(name="ModifiedOn")

	public String modifiedOn;
public InsertEmailManagementModel(){
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
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
}
