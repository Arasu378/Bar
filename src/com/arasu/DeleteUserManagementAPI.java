package com.arasu;

import javax.annotation.Generated;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import response.UserManagementBarResponse;
import consumeclass.DeleteUserManagementClass;

@Path("/deleteUserManagement")
public class DeleteUserManagementAPI {
	@GET
	@Secured
	@Path("/{userProfileId}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
public UserManagementBarResponse deleteusermanagement(@PathParam("userProfileId")String proid,@PathParam("id")String id){
	return DeleteUserManagementClass.delete_user(proid,id);
}
}
