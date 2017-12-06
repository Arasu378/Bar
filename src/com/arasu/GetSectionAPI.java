package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.SectionBarResponse;

@Path("/getSectionByUserProfileID")
public class GetSectionAPI {

	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public SectionBarResponse getsectionbyuserprofileid(@javax.ws.rs.PathParam("userprofileid")String proid){
		return InsertSectionClass.getSectionbyuserprofileid(Integer.parseInt(proid));
	}

}
