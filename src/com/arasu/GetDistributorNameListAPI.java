package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import response.DistributorResponse;
import consumeclass.GetDistributorNameListClass;

@Path("/GetDistributorList")

public class GetDistributorNameListAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public DistributorResponse getdistributorlist(@javax.ws.rs.PathParam("userprofileid")String proid){
		return GetDistributorNameListClass.getdistributorlist(proid);
	}
}
