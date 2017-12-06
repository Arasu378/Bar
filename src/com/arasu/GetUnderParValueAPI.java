package com.arasu;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.GetUnderParValueClass;
import response.GetUnderParValue;

@Path("/GetUnderParValue")
public class GetUnderParValueAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userprofileid}")
public static GetUnderParValue getparlist(@javax.ws.rs.PathParam("userprofileid")String proid){
		return GetUnderParValueClass.getparvaluelist(proid);
	}
}
