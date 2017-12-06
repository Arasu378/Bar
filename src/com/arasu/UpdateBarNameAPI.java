package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateBarNameClass;
import model.InsertBarModel;
import response.GeneralResponse;

@Path("/updateBarName")
public class UpdateBarNameAPI {
	@PUT
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
public static FrontBarResponse update_bar(InsertBarModel model){
	return UpdateBarNameClass.updatebarname(model);
}
}
