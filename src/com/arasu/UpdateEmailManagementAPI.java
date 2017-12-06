package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateEmailManagementClass;
import response.GeneralResponse;

@Path("/updateEmailManagement")

public class UpdateEmailManagementAPI {
	@PUT
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public GeneralResponse update_data(InsertEmailManagementModel model){
	return UpdateEmailManagementClass.updateemail(model);
}
}
