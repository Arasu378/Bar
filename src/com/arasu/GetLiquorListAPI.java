package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("/getLiquorList")
public class GetLiquorListAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public LiquorResponse loginuser(@QueryParam("page")int page){
		System.out.println("input values are page : "+page);
		return GetLiquorListClass.getLiquor(page);
	}
}
