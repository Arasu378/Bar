package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetParValueListClass;

@Path("/GetParValue")
public class GetParValueListToatlAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsertUserLiquorResponse getuserpurchaselist(@javax.ws.rs.PathParam("userprofileid")String proid){
		return GetParValueListClass.GetParValueList(proid);
	}
	
}
