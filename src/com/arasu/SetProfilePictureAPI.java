package com.arasu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ProfilePicture")
public class SetProfilePictureAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@POST
	@Secured
	@Path("/insertPicture")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static UserFirst setPicture(PictureModelClass pic){
		System.out.println("update picture: "+pic.getName()+" / "+pic.getUserprofileid());
		return SetProfilePictureClass.insertUser(pic);
		
	}
	@PUT
	@Secured
	@Path("/updatePicture")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static UserFirst updatePicture(PictureModelClass pic){
		System.out.println("update picture: "+pic.getName()+" / "+pic.getUserprofileid());
		return SetProfilePictureClass.updateUser(pic);
	}

}
