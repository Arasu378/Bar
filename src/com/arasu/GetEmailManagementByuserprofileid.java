package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getEmailbyUserprofileid")
public class GetEmailManagementByuserprofileid {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsertEmailManagementRespones insertemail(@javax.ws.rs.PathParam("userprofileid")String proid){
		return InsertEmailManagementClass.getemailbyuserprofileID(Integer.parseInt(proid));
	}


}
