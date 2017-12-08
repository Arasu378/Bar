/**
 * 
 */
package com.arasu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author kyros
 *
 */
@Path("/getUserProfileByUserProfileId/{UserProfileId}")
public class GetUserProfileByUserProfileIdAPI {
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public  UserFirst getUserProfileByUserProfileId(@PathParam("UserProfileId")int UserProfileId){
		return LoginClass.getUserProfileByUserProfileId(UserProfileId);
	}

}
