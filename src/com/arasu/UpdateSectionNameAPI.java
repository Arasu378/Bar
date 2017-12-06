package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.UpdateSectionNameClass;
import model.InsertSectionModel;
import model.SectionBarResponse;
import response.GeneralResponse;

@Path("/updateSectionBottles")
public class UpdateSectionNameAPI {
	@PUT
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static SectionBarResponse updatesection(InsertSectionModel model){
		return UpdateSectionNameClass.updatesection_name(model);
	}

}
