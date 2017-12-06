package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import consumeclass.DeleteBarClass;
import response.GeneralResponse;

@Path("/DeleteBar")
public class DeleteBarAPI {
	@Path("/{userprofileid}/{BarId}")
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public static FrontBarResponse delete(@PathParam("BarId")String BarId,@PathParam("userprofileid")String proid){
		return DeleteBarClass.deleteBar(BarId,proid);
	}
}
