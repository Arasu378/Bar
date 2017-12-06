package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getUserPurchaseList")
public class GetPurchaseListAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsertUserLiquorResponse getuserpurchaselist(@javax.ws.rs.PathParam("userprofileid")String proid){
		return InsertPurchaseListClass.getpurchaselistbyuserprofilid(Integer.parseInt(proid));
	}
	

}
