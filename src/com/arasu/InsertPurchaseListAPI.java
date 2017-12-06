package com.arasu;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import consumeclass.InsertPurchaseListClassM;
import response.GeneralResponse;

@Path("/insertPurchaseList")
public class InsertPurchaseListAPI {
	@POST
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(value={MediaType.MULTIPART_FORM_DATA})

	public GeneralResponse insertpurchaselist( @FormDataParam("liquorname") String  name,@FormDataParam("liquorcapacity") String qty,@FormDataParam("category") String category,@FormDataParam("subcategory") String subcategory,
			@FormDataParam("shots") 	String shots,@FormDataParam("parlevel") String parlevel,@FormDataParam("distributorname")  String distributorname,@FormDataParam("priceunit")  String priceunit, @FormDataParam("binnumber") String binnumber,
			@FormDataParam("productcode") String productcode, @FormDataParam("image") InputStream picture,@FormDataParam("minvalue") String minvalue,@FormDataParam("maxvalue") String maxvalue,@FormDataParam("type") String type,@FormDataParam("userprofileid") String userproid) throws Exception{
	
		return InsertPurchaseListClassM.insertform(name,qty,category,subcategory,shots,parlevel,distributorname,priceunit,
				binnumber,productcode,picture,minvalue,maxvalue,type,userproid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public InsertUserLiquorResponse insertpurchaselist(InsertUserLiquorModel model){
//		try{
//			System.out.println("model : "+model.toString());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return InsertPurchaseListClass.insertpurchaselist(model);
//	}

}
