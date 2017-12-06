package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import consumeclass.DeleteUserLiquorClass;
import response.GeneralResponse;

@Path("/DeleteUserLiquor")
public class DeleteUserLiquorAPI {
	@Path("/{LiquorId}/{userprofileid}/{SectionId}")
	@GET
@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public static InsertUserLiquorResponse delete(@PathParam("LiquorId")String BarId,@PathParam("SectionId")String secid,@PathParam("userprofileid")String proid){
		return DeleteUserLiquorClass.deleteuserliquor(BarId,secid,proid);
	}
}
