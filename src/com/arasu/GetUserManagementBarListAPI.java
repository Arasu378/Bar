package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import response.GetUserTotalBottleResponse;
import response.UserManagementBarResponse;
import consumeclass.GetUserTotalBottleClass;
import consumeclass.UserManagementBarClass;

@Path("/GetUserManagementBarList")
public class GetUserManagementBarListAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(MediaType.APPLICATION_JSON)
	public static UserManagementBarResponse gettotalbottle(@javax.ws.rs.PathParam("userprofileid")String proid){
		return UserManagementBarClass.getbarsbyuserprofileid(proid);
	}
}
