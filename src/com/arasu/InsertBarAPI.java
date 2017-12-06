package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.InsertBarModel;

@Path("/insertBar")
public class InsertBarAPI {
	@POST
	@Secured
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public static FrontBarResponse insertBar(InsertBarModel model){
		return InsertBarClass.insertBar(model);
		
	}

}
