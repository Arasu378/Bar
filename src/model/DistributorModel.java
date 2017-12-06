package model;

import javax.xml.bind.annotation.XmlElement;

public class DistributorModel {
	@XmlElement(name="Id")

	public String id;
	@XmlElement(name="UserProfileId")

	public String userProfileId;
	@XmlElement(name="DistributorName")

	public String distributorName;
	public DistributorModel(){
		
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
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
	

}
