package response;

import javax.xml.bind.annotation.XmlElement;

public class GetUnderParValue {
	@XmlElement(name="IsSuccess")

	public boolean isSuccess;
	@XmlElement(name="Message")

	public String message;
	@XmlElement(name="UnderParValue")

	public String underParValue;
	public GetUnderParValue(){
		
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
	public String getUnderParValue() {
		return underParValue;
	}
	public void setUnderParValue(String underParValue) {
		this.underParValue = underParValue;
	}
	
}
