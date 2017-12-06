package com.arasu;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/getBarbyUserProfileId")
public class GetBarByUserprofileIdAPI {
	@GET
	@Secured
	@Path("/{userprofileid}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public FrontBarResponse getbarbyuserprofileid(@javax.ws.rs.PathParam("userprofileid")String proid){
		System.out.println("profileid: "+proid);
	
		return InsertBarClass.getBarbyuserprofileid(Integer.parseInt(proid));
	}

}
