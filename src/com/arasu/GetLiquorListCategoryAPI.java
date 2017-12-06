package com.arasu;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arasu.LiquorResponse;

import consumeclass.GetLiquourListCategoryClass;

@Path("/getLiquorListCategory")
public class GetLiquorListCategoryAPI {
		@GET
		@Secured
		@Path("/{category}")
		@Produces(MediaType.APPLICATION_JSON)
		public LiquorResponse loginuser(@PathParam("category")String category){
			System.out.println("Category: "+category);
			return GetLiquourListCategoryClass.getLiquor(category);
		}
	
	
}
