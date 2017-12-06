package response;

import javax.xml.bind.annotation.XmlElement;

public class GeneralResponse {
	@XmlElement(name="IsSuccess")

public boolean isSuccess;
	@XmlElement(name="Message")

public String message;
public GeneralResponse(){
	
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
