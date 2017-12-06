package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.log.Log;

@Path("/userservice")
public class EmployeeService {
	Test test=new Test();
	@GET
	@Path("/users")
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	//@HeaderParam("authorization") String authString
	public UserFirst getUsers(){ 
		try{
//			 if(!isUserAuthenticated(authString)){
//				 UserFirst userfirstitem =new UserFirst();
//				 userfirstitem.setIsSuccess(false);
//					userfirstitem.setMessage("Authorization is not valid!");
//					userfirstitem.setUserList(null);
//		            return userfirstitem;
//		        }
			System.out.println("first one is executing");
			return test.getTotalList();
//			return null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	private boolean isUserAuthenticated(String authString) {
		
		
		// TODO Auto-generated method stub
		return false;
	}
	@GET
	@Path("/getUserProfileId/{userprofileid}")
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public UserFirst getUseritem(@PathParam("userprofileid")int userprofileid){ 
		
		try{
			return test.getItemList(userprofileid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}