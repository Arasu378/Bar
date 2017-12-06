package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdatePurchaseListKegClass;
import response.GeneralResponse;

@Path("/UpdatePurchaseListKeg")
public class UpdatePurchaseListKegAPI {
	@PUT
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static GeneralResponse update(InsertUserLiquorModel model){
		return UpdatePurchaseListKegClass.updatepurchaselist(model);
	}

}
