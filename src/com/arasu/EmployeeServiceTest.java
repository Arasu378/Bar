package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import model.UserFirstTest;
import model.UserTest;
import utils.Constants;


@Path("/userserviceC")

public class EmployeeServiceTest {
	Test test=new Test();
	public static List<UserTest>UserList= new ArrayList<UserTest>();

	@GET
	@Secured
	@Path("/usersC")
	@Produces(MediaType.APPLICATION_JSON)
	
	public UserFirstTest getUsers(){ 
		Connection connection=null;
		  UserList.clear();
		  UserFirstTest userfirst=new UserFirstTest();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
		    connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		   String query="CALL get_allusers();";
		   java.sql.Statement st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   while (rs.next()) {
			   UserTest user=new UserTest();
			   user.setCreatedOn(rs.getString("CreatedOn"));
				user.setId(rs.getInt("Id"));
				user.setUserProfileId(rs.getInt("UserProfileId"));
				user.setUserFirstName(rs.getString("UserFirstName"));
				user.setUserLastName(rs.getString("UserLastName"));
				user.setUserMobileNumber(rs.getString("UserMobileNumber"));
				user.setUserEmail(rs.getString("UserEmail"));
				user.setUserVenueName(rs.getString("UserVenueName"));
				user.setUserCountry(rs.getString("UserCountry"));
				user.setUserOftenInventory(rs.getString("UserOftenInventory"));
				user.setUserInventoryTime(rs.getInt("UserInventoryTime"));
				user.setUserLastLogin(rs.getString("UserLastLogin"));
				user.setIsActive(rs.getBoolean("IsActive"));
				user.setCreatedOn(rs.getString("CreatedOn"));
				user.setPassword(rs.getString("Password"));
				user.setModifiedOn(rs.getString("ModifiedOn"));
				UserList.add(user);
			   
				System.out.println("total size: "+UserList.size());	
		}
		   System.out.println("It is working");
			userfirst.setIsSucess(true);
			userfirst.setMessage("");
			userfirst.setUserList(UserList);
			

		   if(UserList.size()==0){
			   userfirst.setIsSucess(false);
				userfirst.setMessage("No User List");
				userfirst.setUserList(UserList);
		   }
		   return userfirst;
		  
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Error: not working");
	}finally{
		if(connection!=null){
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return userfirst;
	}
}