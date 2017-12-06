package com.arasu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import utils.Constants;
import utils.DatabaseKey;
@Path("/userservicetest")
@Secured
public class Test {
	
//	public static final String TABLE_NAME="table_1";

	 static List<User>UserList= new ArrayList<User>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
	}
	public UserFirst getItemList(int userprofileid)throws IOException{
		  Connection connection=null;
		 // List<UserFirst>userfirst=new ArrayList<UserFirst>();
		  List<User>newlist=new ArrayList<User>();
		  UserFirst userfirstitem=new UserFirst();
		  UserList.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			//String query="SELECT * FROM userprofile where userprofileid="+userprofileid;
				String query="CALL get_userprofile_id("+userprofileid+");";
			 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			   java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   // if(rs.getInt("userprofileid")==userprofileid){
				   User user=new User();
				   		user.setCreatedOn(rs.getString(DatabaseKey.createdon));
						user.setId(rs.getInt(DatabaseKey.id));
						user.setUserProfileId(rs.getInt(DatabaseKey.userprofileid));
						user.setUserFirstName(rs.getString(DatabaseKey.userfirstname));
						user.setUserLastName(rs.getString(DatabaseKey.userlastname));
						user.setUserMobileNumber(rs.getString(DatabaseKey.usermobilenumber));
						user.setUserEmail(rs.getString(DatabaseKey.useremail));
						user.setUserVenueName(rs.getString(DatabaseKey.uservenuename));
						user.setUserCountry(rs.getString(DatabaseKey.usercountry));
						user.setUserOftenInventory(rs.getString(DatabaseKey.userofteninventory));
						user.setUserInventoryTime(rs.getInt(DatabaseKey.userinventorytime));
						user.setUserLastLogin(rs.getString(DatabaseKey.userlastlogin));
						user.setIsActive(rs.getBoolean(DatabaseKey.isactive));
						user.setCreatedOn(rs.getString(DatabaseKey.createdon));
						user.setPassword(rs.getString(DatabaseKey.password));
						user.setModifiedOn(rs.getString(DatabaseKey.modifiedon));
				   
							newlist.add(user);
					userfirstitem.setIsSuccess(true);
					userfirstitem.setMessage("");
					userfirstitem.setUserList(newlist);
					//userfirst.add(userfirstitem);
					
			   }
			   if(newlist.size()==0){
				   userfirstitem.setIsSuccess(false);
					userfirstitem.setMessage("No Value");
					userfirstitem.setUserList(newlist);
					
			   }
			 
			 
					
				//}
				System.out.println("total sizesecond: "+userfirstitem.toString());

				return userfirstitem;

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	@GET
	@Path("/userstest")
	@Produces(MediaType.APPLICATION_JSON)
	public   UserFirst getTotalList() throws IOException{
		  Connection connection=null;
		  UserList.clear();
		  UserFirst userfirst=new UserFirst();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			    connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			   String query="CALL get_allusers();";

			   //String query="SELECT * FROM "+TABLE_NAME;

			   java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while (rs.next()) {
				   User user=new User();
//				   user.setId(rs.getInt("id"));
//				   user.setName(rs.getString("name"));
//				   user.setLocation(rs.getString("location"));
//				   user.setMobileNumber(rs.getString("mobile"));
				   
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
					
//					
//				   user.setCreatedOn(rs.getString(DatabaseKey.createdon));
//					user.setId(rs.getInt(DatabaseKey.id));
//					user.setUserProfileId(rs.getInt(DatabaseKey.userprofileid));
//					user.setUserFirstName(rs.getString(DatabaseKey.userfirstname));
//					user.setUserLastName(rs.getString(DatabaseKey.userlastname));
//					user.setUserMobileNumber(rs.getString(DatabaseKey.usermobilenumber));
//					user.setUserEmail(rs.getString(DatabaseKey.useremail));
//					user.setUserVenueName(rs.getString(DatabaseKey.uservenuename));
//					user.setUserCountry(rs.getString(DatabaseKey.usercountry));
//					user.setUserOftenInventory(rs.getString(DatabaseKey.userofteninventory));
//					user.setUserInventoryTime(rs.getInt(DatabaseKey.userinventorytime));
//					user.setUserLastLogin(rs.getString(DatabaseKey.userlastlogin));
//					user.setIsActive(rs.getBoolean(DatabaseKey.isactive));
//					user.setPassword(rs.getString(DatabaseKey.password));
//					user.setCreatedOn(rs.getString(DatabaseKey.createdon));
//					user.setModifiedOn(rs.getString(DatabaseKey.modifiedon));
					UserList.add(user);
				   
					System.out.println("total size: "+UserList.size());

//				System.out.println("EmployeeID : "+rs.getInt("id")+
//						" / "+"Name : "+rs.getString("name")+" / "
//						+"Location : "+rs.getString("location")+" / "
//						+"Mobile : "+ rs.getDouble("mobile"));
				
			}
			   System.out.println("It is working");
				userfirst.setIsSuccess(true);
				userfirst.setMessage("");
				userfirst.setUserList(UserList);
				

			   if(UserList.size()==0){
				   userfirst.setIsSuccess(false);
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
		//return  Response.status(200).entity(userfirst).build();
		
	}
}
