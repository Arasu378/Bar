package com.arasu;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.InsertBarModel;

public class FrontBarResponse {
	@XmlElement(name="IsSuccess")

public boolean isSuccess;
	@XmlElement(name="Message")

public String message;
	@XmlElement(name="Model")

public ArrayList<InsertBarModel>model =new ArrayList<InsertBarModel>();
public FrontBarResponse(){
	
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
public void setMessage(String message) {
	this.message = message;
}
public ArrayList<InsertBarModel> getModel() {
	return model;
}
public void setModel(ArrayList<InsertBarModel> model) {
	this.model = model;
}
}
