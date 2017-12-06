package model;

import javax.xml.bind.annotation.XmlElement;

public class InsertSectionModel {
	@XmlElement(name="BarId")

	public int barId;
	@XmlElement(name="SectionName")

	public String sectionName;
	@XmlElement(name="SectionId")

	public int sectionId;
	@XmlElement(name="UserProfileId")

	public int userProfileId;
	@XmlElement(name="ModifiedOn")

	public String modifiedOn;
	@XmlElement(name="CreatedOn")

	public String createdOn;
	public InsertSectionModel(){
		
	}
	public int getBarId() {
		return barId;
	}
	public void setBarId(int barId) {
		this.barId = barId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
}
