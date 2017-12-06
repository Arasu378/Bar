package com.arasu;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import consumeclass.UpdateLiquorSliderClass;
import response.GeneralResponse;

@Path("/UpdateLiquorSlider")
public class UpdateLiquorSliderAPI {
	@PUT
	@Secured
    @Consumes(value={MediaType.MULTIPART_FORM_DATA})
	@Produces(MediaType.APPLICATION_JSON)
	  public GeneralResponse uploadFileWithData(
			  @FormDataParam("BottleId")String BottleId,
			  @FormDataParam("SectionId") String SectionId,
			  @FormDataParam("BarId") String BarId,
			  @FormDataParam("Image") InputStream fileInputStream,
              @FormDataParam("Image") FormDataContentDisposition cdh,
              @FormDataParam("UserProfileId")String userprofileid1,
              @FormDataParam("LiquorName")String liquorname,
              @FormDataParam("LiquorCapacity")String liquorquantitiy,
              @FormDataParam("ParValue")String parvalue,
              @FormDataParam("Category")String category,
              @FormDataParam("Shots")String shots,
              @FormDataParam("SubCategory")String subcategory,
              @FormDataParam("DistributorName")String distributorname,
              @FormDataParam("Price")String price,
              @FormDataParam("BinNumber")String binnumber,
              @FormDataParam("ProductCode")String productcode,
              @FormDataParam("MinValue")String minvalue1,
              @FormDataParam("MaxValue")String maxvalue1,
              @FormDataParam("Type")String type){		
		try {
			return UpdateLiquorSliderClass.update_data(BottleId,SectionId,BarId,fileInputStream,cdh,userprofileid1,liquorname,liquorquantitiy,parvalue,category,shots,subcategory,distributorname,price,binnumber,productcode,minvalue1,maxvalue1,type);
		} catch (Exception e) {
			e.printStackTrace();
			GeneralResponse userfirst=new GeneralResponse();
			userfirst.setIsSuccess(false);
			userfirst.setMessage("failed: "+e.getMessage());
			return userfirst;
		}
		
	}
	
}
