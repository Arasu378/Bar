package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetUserTotalBottleClass;
import response.GetUserTotalBottleResponse;

@Path("/GetUserTotalBottles")
public class GetUserTotalBottleAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public static GetUserTotalBottleResponse gettotalbottle(@javax.ws.rs.PathParam("userprofileid")String proid){
		return GetUserTotalBottleClass.getTotalBottles(proid);
	}

}
