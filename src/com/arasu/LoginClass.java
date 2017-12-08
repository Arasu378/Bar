package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

import java.util.List;

import utils.Constants;
import utils.DatabaseKey;

public class LoginClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static UserFirst getLogin(Loginmodelclass user){
		UserFirst userfirst=new UserFirst();
		 Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String password=user.getPassword();
			String email=user.getUserEmail();
			String psss=getPassword(email);
			if(psss!=null){
				System.out.println("password get: pass : "+psss);
				byte[] decodedBytes = Base64.decodeBase64(psss);
				System.out.println("decoded_password : " + new String(decodedBytes));
				String decrypted_password=new String(decodedBytes);
				System.out.println("email :"+email);
				   System.out.println("psss: "+ psss+" input : "+password);

				if(!password.equals(decrypted_password)){
					UserFirst us=new UserFirst();
					us.setIsSuccess(false);
					us.setMessage("Password does not match");
					us.setUserList(null);
					return us;
				}
				byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
				System.out.println("encoded_new_password :  " + new String(encodedBytes));
				password=new String(encodedBytes);

	String query="CALL login_pass("+"'"+password+"'"+")";
				System.out.println("query login: "+query); 
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				 java.sql.Statement st=connection.createStatement();
				
				   ResultSet rs=st.executeQuery(query);
				   while(rs.next()){
					   String emailuser=rs.getString(DatabaseKey.useremail);
					   System.out.println("mobile number da: "+ rs.getString(DatabaseKey.useremail)+" input : "+email);
					   if(emailuser.equals(email)){
						   UserFirst userf=new UserFirst();
						   List<User>userlist=new ArrayList<User>();
						   userlist.clear();
						   User user1=new User();
						   int  Id=rs.getInt(DatabaseKey.id);
						   int UserProfileId=rs.getInt(DatabaseKey.userprofileid);
						   String UserFirstName=rs.getString(DatabaseKey.userfirstname);
						   if(UserFirstName==null){
							   UserFirstName="";
						   }
						   String UserLastName=rs.getString(DatabaseKey.userlastname);
						   if(UserLastName==null){
							   UserLastName="";
						   }
						   String UserMobileNumber=rs.getString(DatabaseKey.usermobilenumber);
						   if(UserMobileNumber==null){
							   UserMobileNumber="";
						   }
						   String UserEmail=rs.getString(DatabaseKey.useremail);
						   if(UserEmail==null){
							   UserEmail="";
						   }
						   String UserVenueName=rs.getString(DatabaseKey.uservenuename);
						   if(UserVenueName==null){
							   UserVenueName="";
						   }
						   String UserCountry=rs.getString(DatabaseKey.usercountry);
						   if(UserCountry==null){
							   UserCountry="";
						   }
						   String UserOftenInventory=rs.getString(DatabaseKey.userofteninventory);
						   if(UserOftenInventory==null){
							   UserOftenInventory="";
						   }
						   int UserInventoryTime=rs.getInt(DatabaseKey.userinventorytime);
						  String UserLastLogin=rs.getString(DatabaseKey.userlastlogin);
						  if(UserLastLogin==null){
							  UserLastLogin="";
						  }
						  boolean IsActive=rs.getBoolean(DatabaseKey.isactive);
						  String CreatedOn=rs.getString(DatabaseKey.createdon);
						  if(CreatedOn==null){
							  CreatedOn="";
						  }
						  String ModifiedOn=rs.getString(DatabaseKey.modifiedon);
						  if(ModifiedOn==null){
							  ModifiedOn="";
						  }
						  String Password=rs.getString(DatabaseKey.password);
						  if(Password==null){
							  Password="";
						  }
						  String UserRole=rs.getString(DatabaseKey.userrole);
						  if(UserRole==null){
							  UserRole="admin";
						  }
						  String ParentUserProfileId=rs.getString(DatabaseKey.parentuserprofileid);
						  if(ParentUserProfileId==null){
							  ParentUserProfileId="null";
						  }
						  String authorizationKey=rs.getString(DatabaseKey.USER_AUTHORIZATION_KEY);
						  if(authorizationKey==null){
							  authorizationKey="";
						  }
						  user1.setAuthorizationKey(authorizationKey);
						   user1.setId(Id);
						   user1.setUserProfileId(UserProfileId);
						   user1.setUserFirstName(UserFirstName);
						   user1.setUserLastName(UserLastName);
						   user1.setUserMobileNumber(UserMobileNumber);
						   user1.setUserEmail(UserEmail);
						   user1.setUserVenueName(UserVenueName);
						   user1.setUserCountry(UserCountry);
						   user1.setUserOftenInventory(UserOftenInventory);
						   user1.setUserInventoryTime(UserInventoryTime);
						   user1.setUserLastLogin(UserLastLogin);
						   user1.setIsActive(IsActive);
						   user1.setCreatedOn(CreatedOn);
						   user1.setModifiedOn(ModifiedOn);
						   user1.setPassword(Password);
						   user1.setUserRole(UserRole);
						   user1.setParentUserProfileId(ParentUserProfileId);
						   userlist.add(user1);
						   userf.setIsSuccess(true);
						   userf.setMessage("");
						   userf.setUserList(userlist);
						   return userf;
					   }
//					   else{
//						   UserFirst userf=new UserFirst();
//						   userf.setIsSuccess(false);
//						   userf.setMessage("Mobile number is does not match");
//						   userf.setUserList(null);
//						   return userf; 
//					   }
				   }
				   UserFirst userf=new UserFirst();
	  			   userf.setIsSuccess(false);
				   userf.setMessage("Mobile number is does not match or incorrect email id");
				   userf.setUserList(null);
				   return userf;
			}else{
				UserFirst userf=new UserFirst();
				   userf.setIsSuccess(false);
				   userf.setMessage("password is not there");
				   userf.setUserList(null);
				   return userf; 
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
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
	public static String getPassword(String mobile){
		String result=null;
		 Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				//CALL get_password_correct(9952904912);
				String query="CALL get_password_correct("+"'"+mobile+"'"+")";
				System.out.println("query login: "+query); 
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				System.out.println(Constants.URL+Constants.USER+Constants.PASSWORD);
				 java.sql.Statement st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   while(rs.next()){
					   result=rs.getString(DatabaseKey.password);
				   }
			}catch(Exception e){
				e.printStackTrace();
			
			}
		
		return result;
	}
	public static UserFirst getUserProfileByUserProfileId(int UserProfileId){
		String query="CALL  `getUserProfileByUserProfielId`("+UserProfileId+");";
		UserFirst response =new UserFirst();
		System.out.println("Query : "+query);
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			 java.sql.Statement st=connection.createStatement();
			   List<User>userlist=new ArrayList<User>();
			   userlist.clear();

			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   User user1=new User();
				   int  Id=rs.getInt(DatabaseKey.id);
				   int userProfileId=rs.getInt(DatabaseKey.userprofileid);
				   String UserFirstName=rs.getString(DatabaseKey.userfirstname);
				   if(UserFirstName==null){
					   UserFirstName="";
				   }
				   String UserLastName=rs.getString(DatabaseKey.userlastname);
				   if(UserLastName==null){
					   UserLastName="";
				   }
				   String UserMobileNumber=rs.getString(DatabaseKey.usermobilenumber);
				   if(UserMobileNumber==null){
					   UserMobileNumber="";
				   }
				   String UserEmail=rs.getString(DatabaseKey.useremail);
				   if(UserEmail==null){
					   UserEmail="";
				   }
				   String UserVenueName=rs.getString(DatabaseKey.uservenuename);
				   if(UserVenueName==null){
					   UserVenueName="";
				   }
				   String UserCountry=rs.getString(DatabaseKey.usercountry);
				   if(UserCountry==null){
					   UserCountry="";
				   }
				   String UserOftenInventory=rs.getString(DatabaseKey.userofteninventory);
				   if(UserOftenInventory==null){
					   UserOftenInventory="";
				   }
				   int UserInventoryTime=rs.getInt(DatabaseKey.userinventorytime);
				  String UserLastLogin=rs.getString(DatabaseKey.userlastlogin);
				  if(UserLastLogin==null){
					  UserLastLogin="";
				  }
				  boolean IsActive=rs.getBoolean(DatabaseKey.isactive);
				  String CreatedOn=rs.getString(DatabaseKey.createdon);
				  if(CreatedOn==null){
					  CreatedOn="";
				  }
				  String ModifiedOn=rs.getString(DatabaseKey.modifiedon);
				  if(ModifiedOn==null){
					  ModifiedOn="";
				  }
				  String Password=rs.getString(DatabaseKey.password);
				  if(Password==null){
					  Password="";
				  }
				  String UserRole=rs.getString(DatabaseKey.userrole);
				  if(UserRole==null){
					  UserRole="admin";
				  }
				  String ParentUserProfileId=rs.getString(DatabaseKey.parentuserprofileid);
				  if(ParentUserProfileId==null){
					  ParentUserProfileId="null";
				  }
				  String authorizationKey=rs.getString(DatabaseKey.USER_AUTHORIZATION_KEY);
				  if(authorizationKey==null){
					  authorizationKey="";
				  }
				  user1.setAuthorizationKey(authorizationKey);
				   user1.setId(Id);
				   user1.setUserProfileId(UserProfileId);
				   user1.setUserFirstName(UserFirstName);
				   user1.setUserLastName(UserLastName);
				   user1.setUserMobileNumber(UserMobileNumber);
				   user1.setUserEmail(UserEmail);
				   user1.setUserVenueName(UserVenueName);
				   user1.setUserCountry(UserCountry);
				   user1.setUserOftenInventory(UserOftenInventory);
				   user1.setUserInventoryTime(UserInventoryTime);
				   user1.setUserLastLogin(UserLastLogin);
				   user1.setIsActive(IsActive);
				   user1.setCreatedOn(CreatedOn);
				   user1.setModifiedOn(ModifiedOn);
				   user1.setPassword(Password);
				   user1.setUserRole(UserRole);
				   user1.setParentUserProfileId(ParentUserProfileId);
				   userlist.add(user1);
				 				   
			   }
			   if(userlist!=null &&userlist.size()!=0){
				   response.setIsSuccess(true);
				   response.setMessage("success");
				   response.setUserList(userlist);
			   }else{
				   response.setIsSuccess(false);
				   response.setMessage("List is empty or null");
				   response.setUserList(null);
			   }
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

}
