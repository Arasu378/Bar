package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/userLogin")
public class LoginAPI {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserFirst loginuser(Loginmodelclass user){
		System.out.println("user value: "+user.getUserEmail()+" / "+user.getPassword());
		return LoginClass.getLogin(user);
	}
}
