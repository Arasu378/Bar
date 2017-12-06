package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import response.DistributorResponse;
import response.UserManagementBarResponse;
import consumeclass.GetDistributorNameListClass;
import consumeclass.GetUserManagementClass;

@Path("/GetUserManagementByUserProfileId")
public class GetUserManagementAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserManagementBarResponse getdistributorlist(@javax.ws.rs.PathParam("userprofileid")String proid){
		return GetUserManagementClass.getusermangement(proid);
	}

}
