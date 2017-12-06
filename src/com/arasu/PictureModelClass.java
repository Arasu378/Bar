package com.arasu;

import javax.xml.bind.annotation.XmlElement;

public class PictureModelClass {
	@XmlElement(name="Name")

public String name;
	@XmlElement(name="Data")

public byte[] data;
	@XmlElement(name="UserProfileId")

public int userProfileId;
public PictureModelClass(){
	
}
public PictureModelClass(String name,byte[]data,int userprofileid){
	this.name=name;
	this.data=data;
	this.userProfileId=userprofileid;
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}
public int getUserprofileid() {
	return userProfileId;
}
public void setUserprofileid(int userprofileid) {
	this.userProfileId = userprofileid;
}
}
