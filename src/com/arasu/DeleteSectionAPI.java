package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.SectionBarResponse;
import consumeclass.DeleteSectionClass;
import response.GeneralResponse;

@Path("/DeleteSection")

public class DeleteSectionAPI {
	@Path("/{userprofileid}/{SectionId}")
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public static SectionBarResponse deletesection(@PathParam("SectionId")String BarId,@PathParam("userprofileid")String proid){
		return DeleteSectionClass.deleteSection(BarId,proid);
	}
}
