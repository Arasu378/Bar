package com.arasu;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class InsertUserLiquorResponse {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="Model")

	public ArrayList<InsertUserLiquorModel>model=new ArrayList<InsertUserLiquorModel>();
	public InsertUserLiquorResponse(){
		
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
	public ArrayList<InsertUserLiquorModel> getModel() {
		return model;
	}
	public void setModel(ArrayList<InsertUserLiquorModel> model) {
		this.model = model;
	}
	
	

}
