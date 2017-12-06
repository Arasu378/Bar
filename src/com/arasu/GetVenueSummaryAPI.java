package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import consumeclass.GetVenueSummaryClass;

@Path("/GetVenueSummary")
public class GetVenueSummaryAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public InsertUserLiquorResponse getvenuesummary(@javax.ws.rs.PathParam("userprofileid")String proid){
		return GetVenueSummaryClass.GetVenueSummary(proid);
	}

}
