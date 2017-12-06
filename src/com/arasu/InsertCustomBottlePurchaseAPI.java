package com.arasu;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import consumeclass.InsertCustomBottlePurchaseClass;
import response.GeneralResponse;

@Path("/insertCustomBottlePurchase")
public class InsertCustomBottlePurchaseAPI {
	@POST
	@Secured
    @Consumes(value={MediaType.MULTIPART_FORM_DATA})
	@Produces(MediaType.APPLICATION_JSON)
	public static GeneralResponse insertpurchasebottle(  @FormDataParam("image") InputStream fileInputStream,
          //  @FormDataParam("image") FormDataContentDisposition cdh,
            @FormDataParam("userprofileid")String userprofileid1,
            @FormDataParam("liquorname")String liquorname,
            @FormDataParam("liquorquantitiy")String liquorquantitiy,
            @FormDataParam("parvalue")String parvalue,
            @FormDataParam("category")String category,
            @FormDataParam("shots")String shots,
            @FormDataParam("subcategory")String subcategory,
            @FormDataParam("distributorname")String distributorname,
            @FormDataParam("price")String price,
            @FormDataParam("binnumber")String binnumber,
            @FormDataParam("productcode")String productcode,
            @FormDataParam("minvalue")String minvalue1,
            @FormDataParam("maxvalue")String maxvalue1,
            @FormDataParam("type")String type){
		return InsertCustomBottlePurchaseClass.insertpurchaseitem(fileInputStream,userprofileid1,liquorname,liquorquantitiy,
				parvalue,category,shots,subcategory,distributorname,price,binnumber,productcode,minvalue1,maxvalue1,type);
	}

}
