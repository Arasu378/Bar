 package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/updateUserbyProfileId")
public class UpdateUser {
	@PUT
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserFirst updateUser(User user){
		System.out.println("user value: "+user.getUserMobileNumber()+" / "+user.getUserEmail());
		UserFirst userfirst=UpdateProfileClass.UpdateUser(user);
		
		return userfirst;
	}
}
