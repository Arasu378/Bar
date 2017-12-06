package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.InsertCustomKegModel;

public class InsertCustomKegResponse {
	@XmlElement(name="IsSuccess")

private boolean isSuccess;
	@XmlElement(name="Message")

private String message;
	@XmlElement(name="CustomKeg")

private ArrayList<InsertCustomKegModel>customKeg=new ArrayList<InsertCustomKegModel>();
public InsertCustomKegResponse(){
	
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
public ArrayList<InsertCustomKegModel> getCustomKeg() {
	return customKeg;
}
public void setCustomKeg(ArrayList<InsertCustomKegModel> customKeg) {
	this.customKeg = customKeg;
}

}
