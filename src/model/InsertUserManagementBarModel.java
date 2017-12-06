package model;

import javax.xml.bind.annotation.XmlElement;

public class InsertUserManagementBarModel {
	@XmlElement(name="Id")

	public String id;
	@XmlElement(name="UserManagementId")

	public int userManagementId;
	@XmlElement(name="BarName")
 String barName;
	@XmlElement(name="CreatedOn")

	public String createdOn;
	@XmlElement(name="ModifiedOn")

	public String modifiedOn;
	@XmlElement(name="UserProfileId")

	public String userProfileId;
	@XmlElement(name="BarId")

	public int barId;
	public InsertUserManagementBarModel(){
		
	}
	public String getId() {
		return id;
	}
	
	public int getUserManagementId() {
		return userManagementId;
	}
	public void setUserManagementId(int userManagementId) {
		this.userManagementId = userManagementId;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public int getBarId() {
		return barId;
	}
	public void setBarId(int barId) {
		this.barId = barId;
	}
	public String getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
	}
	

}
