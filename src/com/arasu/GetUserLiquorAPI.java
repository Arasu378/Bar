package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getUserliquorlist")

public class GetUserLiquorAPI {
	@GET
	@Secured
	@Path("/{userprofileid}/{sectionid}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsertUserLiquorResponse getuserliquorlist(@javax.ws.rs.PathParam("userprofileid")String proid,@javax.ws.rs.PathParam("sectionid")String sectionid){
		return InsertUserLiquorClass.getuserliquorlist(Integer.parseInt(proid), Integer.parseInt(sectionid));
	}

}
