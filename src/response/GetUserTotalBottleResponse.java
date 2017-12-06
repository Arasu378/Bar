package response;

import javax.xml.bind.annotation.XmlElement;

public class GetUserTotalBottleResponse {
	@XmlElement(name="TotalBottles")

public String totalBottles;
	@XmlElement(name="IsSuccess")

public boolean isSuccess;
	@XmlElement(name="Message")

public String message;
public GetUserTotalBottleResponse(){
	
}
public String getTotalBottles() {
	return totalBottles;
}
public void setTotalBottles(String totalBottles) {
	this.totalBottles = totalBottles;
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

}
