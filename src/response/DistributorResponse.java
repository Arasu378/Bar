package response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import model.DistributorModel;

public class DistributorResponse {
	@XmlElement(name="IsSuccess")

public boolean isSuccess;
	@XmlElement(name="Message")

public String message;
	@XmlElement(name="DistributorsList")

public ArrayList<DistributorModel>distributorsList=new ArrayList<DistributorModel>();
public DistributorResponse(){
	
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
public ArrayList<DistributorModel> getDistributorsList() {
	return distributorsList;
}
public void setDistributorsList(ArrayList<DistributorModel> distributorsList) {
	this.distributorsList = distributorsList;
}

}
