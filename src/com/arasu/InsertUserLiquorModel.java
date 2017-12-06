package com.arasu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.annotation.XmlElement;

import model.TestImage;

public class InsertUserLiquorModel {
	@XmlElement(name="Id")

	public String id;
	@XmlElement(name="UserProfileId")

	public String userProfileId;
	@XmlElement(name="BarId")

	public String barId;
	@XmlElement(name="SectionId")

	public String sectionId;
	@XmlElement(name="LiquorName")

	public String liquorName;
	@XmlElement(name="LiquorCapacity")

	public String liquorCapacity;
	@XmlElement(name="Shots")

	public String shots;
	@XmlElement(name="Category")

	public String category;
	@XmlElement(name="SubCategory")

	public String subCategory;
	@XmlElement(name="ParLevel")

	public String parLevel;
	@XmlElement(name="DistributorName")

	public String distributorName;
	@XmlElement(name="Price")

	public String price;
	@XmlElement(name="BinNumber")

	public String binNumber;
	@XmlElement(name="ProductCode")

	public String productCode;
	@XmlElement(name="CreatedOn")

	public String createdOn;
	@XmlElement(name="ModifiedOn")

	public String modifiedOn;
	@XmlElement(name="MinValue")

	public String minValue;
	@XmlElement(name="MaxValue")

	public String maxValue;
	@XmlElement(name="PictureURL")

	public String pictureURL="";
	@XmlElement(name="TotalBottles")

	public String totalBottles;
	@XmlElement(name="Type")

	public String type;
	@XmlElement(name="FullWeight")

	public String fullWeight;
	@XmlElement(name="EmptyWeight")

	public String emptyWeight;
	public InsertUserLiquorModel(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getLiquorCapacity() {
		return liquorCapacity;
	}
	public void setLiquorCapacity(String liquorCapacity) {
		this.liquorCapacity = liquorCapacity;
	}
	public String getShots() {
		return shots;
	}
	public void setShots(String shots) {
		this.shots = shots;
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
	public String getParLevel() {
		return parLevel;
	}
	public void setParLevel(String parLevel) {
		this.parLevel = parLevel;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public String getTotalBottles() {
		return totalBottles;
	}
	public void setTotalBottles(String totalBottles) {
		this.totalBottles = totalBottles;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	
	
}
