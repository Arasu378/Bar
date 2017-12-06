package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.InsertSectionModel;
import model.SectionBarResponse;

@Path("/InsertSection")
public class InsertSectionAPI {
	@POST
	@Secured
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public SectionBarResponse insertSection(InsertSectionModel model){
		return InsertSectionClass.insertSection(model);
		
	}

}
