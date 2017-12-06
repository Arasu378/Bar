package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class SectionBarResponse {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="Model")

	public ArrayList<InsertSectionModel>model =new ArrayList<InsertSectionModel>();
	public SectionBarResponse(){
		
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
	public ArrayList<InsertSectionModel> getModel() {
		return model;
	}
	public void setModel(ArrayList<InsertSectionModel> model) {
		this.model = model;
	}
	
	
}
