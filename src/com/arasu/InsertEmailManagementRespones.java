package com.arasu;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class InsertEmailManagementRespones {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="Model")

	public ArrayList<InsertEmailManagementModel>model=new ArrayList<InsertEmailManagementModel>();
	public InsertEmailManagementRespones(){
		
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
	public ArrayList<InsertEmailManagementModel> getModel() {
		return model;
	}
	public void setModel(ArrayList<InsertEmailManagementModel> model) {
		this.model = model;
	}


}
