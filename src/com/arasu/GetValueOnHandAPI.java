package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import consumeclass.GetValueOnHandClass;
import consumeclass.GetVenueSummaryClass;

@Path("/GetValueOnHand")
public class GetValueOnHandAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public InsertUserLiquorResponse getbarbyuserprofileid(@javax.ws.rs.PathParam("userprofileid")String proid){
		System.out.println("profileid: "+proid);
		return GetValueOnHandClass.getValueOnhand(proid);
	}

}
