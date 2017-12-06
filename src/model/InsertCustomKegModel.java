package model;

import javax.xml.bind.annotation.XmlElement;

public class InsertCustomKegModel {
	@XmlElement(name="UserProfileId")

	private String  userProfileId;
	@XmlElement(name="BarId")

	private String barId;
	@XmlElement(name="SectionId")

	private String sectionId;
	@XmlElement(name="LiquorName")

	private String liquorName;
	@XmlElement(name="FullWeight")

	private String fullWeight;
	@XmlElement(name="EmptyWeight")

	private String emptyWeight;
	@XmlElement(name="Category")

	private String category;
	@XmlElement(name="SubCategory")

	private String subCategory;
	@XmlElement(name="ParValue")

	private String parValue;
	@XmlElement(name="DistributorName")

	private String distributorName;
	@XmlElement(name="Price")

	private String  price;
	@XmlElement(name="BinNumber")

	private String binNumber;
	@XmlElement(name="ProductCode")

	private String productcode;
	@XmlElement(name="MinValue")

	private String minValue;
	@XmlElement(name="MaxValue")

	private String maxVaule;
	@XmlElement(name="Shots")

	private String shots;
	@XmlElement(name="Type")

	private String type;
public InsertCustomKegModel(){
	
}
public String getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(String userProfileId) {
	this.userProfileId = userProfileId;
}
public String getBarId() {
	return barId;
}
public void setBarId(String barId) {
	this.barId = barId;
}
public String getSectionId() {
	return sectionId;
}
public void setSectionId(String sectionId) {
	this.sectionId = sectionId;
}
public String getLiquorName() {
	return liquorName;
}
public void setLiquorName(String liquorName) {
	this.liquorName = liquorName;
}
public String getFullWeight() {
	return fullWeight;
}
public void setFullWeight(String fullWeight) {
	this.fullWeight = fullWeight;
}
public String getEmptyWeight() {
	return emptyWeight;
}
public void setEmptyWeight(String emptyWeight) {
	this.emptyWeight = emptyWeight;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getSubCategory() {
	return subCategory;
}
public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}
public String getParValue() {
	return parValue;
}
public void setParValue(String parValue) {
	this.parValue = parValue;
}
public String getDistributorName() {
	return distributorName;
}
public void setDistributorName(String distributorName) {
	this.distributorName = distributorName;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getBinNumber() {
	return binNumber;
}
public void setBinNumber(String binNumber) {
	this.binNumber = binNumber;
}
public String getProductcode() {
	return productcode;
}
public void setProductcode(String productcode) {
	this.productcode = productcode;
}
public String getMinValue() {
	return minValue;
}
public void setMinValue(String minValue) {
	this.minValue = minValue;
}
public String getMaxVaule() {
	return maxVaule;
}
public void setMaxVaule(String maxVaule) {
	this.maxVaule = maxVaule;
}
public String getShots() {
	return shots;
}
public void setShots(String shots) {
	this.shots = shots;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
