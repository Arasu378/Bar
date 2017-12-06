package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import consumeclass.DeleteEmailManagementClass;
import response.GeneralResponse;

@Path("/DeleteEmailmanagement")
public class DeleteEmailManagementAPI {
	@Path("/{Id}")
	@GET
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static GeneralResponse delete(@PathParam("Id")String Id){
		return DeleteEmailManagementClass.deleteemailmanagement(Id);
	}
}

