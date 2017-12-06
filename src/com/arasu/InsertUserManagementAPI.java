package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import consumeclass.InsertUserMangementClass;
import response.UserManagementBarResponse;
import model.UserManagementBarModel;
@Path("/insertUserManagement")
public class InsertUserManagementAPI {
	@POST
	@Secured
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public static UserManagementBarResponse insertdata(UserManagementBarModel model){
		return InsertUserMangementClass.insertusermangement(model);
	}

}
