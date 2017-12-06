package model;

import javax.xml.bind.annotation.XmlElement;

public class InsertBarModel {
	@XmlElement(name="UserProfileId")

	public int userProfileId;
	@XmlElement(name="BarName")

	public String barName;
	@XmlElement(name="BarId")

	public int barId;
	@XmlElement(name="CreatedOn")

	public String createdOn;
	@XmlElement(name="ModifiedOn")

	public String modifiedOn;
	public InsertBarModel(){
		
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public String getBarName() {
		return barName;
	}
	public void setBarName(String barName) {
		this.barName = barName;
	}
	public int getBarId() {
		return barId;
	}
	public void setBarId(int barId) {
		this.barId = barId;
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
