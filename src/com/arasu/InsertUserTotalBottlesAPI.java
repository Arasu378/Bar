package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import consumeclass.InsertUserTotalBottlesClass;
import model.SectionBarResponse;

@Path("/InsertUserTotalBottle")
public class InsertUserTotalBottlesAPI {
	@PUT
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static SectionBarResponse inserttotalbottle(InsertUserLiquorModel model){
		return InsertUserTotalBottlesClass.inserttotalbottles(model);
	}

}
