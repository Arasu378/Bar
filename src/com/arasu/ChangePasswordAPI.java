package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/changePassword")
public class ChangePasswordAPI {
@PUT
@Secured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public static UserFirst getPasswordAPi(PasswordClass passwordclass){
	return ChangePasswordModel.ChangePasswordMethod(passwordclass);
}
}
