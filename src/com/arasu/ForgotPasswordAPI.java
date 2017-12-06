package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/ForgotPassword")
public class ForgotPasswordAPI {
	@POST
//	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static UserFirst sendForgetpassword(User user){
		System.out.println("User email: "+user.getUserEmail());
		return ForgotPasswordClass.getforgetpassclass(user);
	}

}
