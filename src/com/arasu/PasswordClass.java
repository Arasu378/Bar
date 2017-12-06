package com.arasu;

import javax.xml.bind.annotation.XmlElement;

public class PasswordClass {
	@XmlElement(name="OldPassword")

	public String oldPassword;
	@XmlElement(name="NewPassword")

	public String newPassword;
	@XmlElement(name="UserProfileId")

	public int userProfileId;
	public PasswordClass(){
		
	}
	public PasswordClass(int userprofileid,String oldpassword,String newpassword){
		this.oldPassword=oldpassword;
		this.newPassword=newpassword;
		this.userProfileId=userprofileid;
	}
	public String getOldpassword() {
		return oldPassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldPassword = oldpassword;
	}
	public String getNewpassword() {
		return newPassword;
	}
	public void setNewpassword(String newpassword) {
		this.newPassword = newpassword;
	}
	public int getUserprofileid() {
		return userProfileId;
	}
	public void setUserprofileid(int userprofileid) {
		this.userProfileId = userprofileid;
	}
	
	

}
