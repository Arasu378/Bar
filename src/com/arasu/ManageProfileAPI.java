package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/manageUserProfile")
public class ManageProfileAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserFirst insertUser(User user){
		System.out.println("user value: "+user.getUserMobileNumber()+" / "+user.getUserEmail());
		UserFirst userfirst=InsertUserProfile.insertData(user);
		
		return userfirst;
	}

}
