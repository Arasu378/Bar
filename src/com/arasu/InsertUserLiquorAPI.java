package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/insertUserLiquorlist")
public class InsertUserLiquorAPI {
	@POST
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public InsertUserLiquorResponse insertliquortouser(InsertUserLiquorModel model){
		try{
			System.out.println("input: "+ model.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return InsertUserLiquorClass.insertliquor(model);
	}
	

}
