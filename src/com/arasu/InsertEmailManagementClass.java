package com.arasu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utils.Constants;

import com.mysql.jdbc.Connection;

public class InsertEmailManagementClass {
	public static InsertEmailManagementRespones insertemail(InsertEmailManagementModel model){
		InsertEmailManagementRespones userfirst=new InsertEmailManagementRespones();
		java.sql.Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String email=model.getUserEmail();
			email="'"+email+"'";
			int proid=model.getUserProfileId();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date)); 
			 String createdon=dateFormat.format(date);
			 createdon="'"+createdon+"'";
			 
			String query="CALL insert_emailmanagement("+email+","+proid+","+createdon+")";
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	        	   System.out.println("success");
	        	   return getemailbyuserprofileID(proid);
	           }else{
	        	   System.out.println("stuck somewhere");
	                userfirst.setIsSuccess(false);
	                userfirst.setMessage("Email not added");
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
	public static InsertEmailManagementRespones getemailbyuserprofileID(int proid){
		InsertEmailManagementRespones userfirst=new InsertEmailManagementRespones();
		java.sql.Connection connection=null;
		ArrayList<InsertEmailManagementModel>model=new ArrayList<InsertEmailManagementModel>();
		model.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL get_emailmanagementbyuserprofileid("+proid+");";
			System.out.println("query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   InsertEmailManagementModel emailmodel=new InsertEmailManagementModel();
				   int Id=rs.getInt("Id");
				   String CreatedOn=rs.getString("CreatedOn");
				   if(CreatedOn==null){
					   CreatedOn="";
				   }
				   String ModifiedOn=rs.getString("ModifiedOn");
				   if(ModifiedOn==null){
					   ModifiedOn="";
				   }
				   String UserEmail=rs.getString("UserEmail");
				   if(UserEmail==null){
					   UserEmail="";
				   }
				  int UserProfileId=rs.getInt("UserProfileId");
				   emailmodel.setId(Id);
				   emailmodel.setCreatedOn(CreatedOn);
				   emailmodel.setModifiedOn(ModifiedOn);
				   emailmodel.setUserEmail(UserEmail);
				   emailmodel.setUserProfileId(UserProfileId);
				   model.add(emailmodel);
				   userfirst.setIsSuccess(true);
				   userfirst.setMessage("");
				   userfirst.setModel(model);
				   
				   
			   }
			   if(model.size()==0){
				   userfirst.setIsSuccess(false);
				   userfirst.setMessage("Email is not there");
				   userfirst.setModel(null);
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

}
