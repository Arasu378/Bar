package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.Constants;
import utils.DatabaseKey;

public class ForgotPasswordClass {
	public static UserFirst getforgetpassclass(User user){
		UserFirst userfirst=new UserFirst();
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String email=user.getUserEmail();
			String query="CALL forget_password("+"'"+email+"'"+");";
			System.out.println("query: "+query);
			String passtomail=getpassword(email);
			System.out.println("passton: "+passtomail);

			InsertUserProfile ins=new InsertUserProfile();
			ins.sendemail(user.getUserEmail(),passtomail);
			
//			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
//			PreparedStatement stmt = connection.prepareStatement(query);
//	            int i=stmt.executeUpdate();
	            System.out.println("success");
                userfirst.setIsSuccess(true);
					userfirst.setMessage("Email sent to registered email.");
//	            if(i>0)
//	            {
//	            	
//	                 
//	            }
//	                  else
//	            {
//	                 System.out.println("stuck somewhere");
//	                 userfirst.setIsSuccess(false);
//				userfirst.setMessage("Email not sent");
////						userfirst.setUserList(userlist);
//
//	            }
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
	public static String getpassword(String email){
		 Connection connection=null;
		 String value="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL get_passwordfromemail("+"'"+email+"'"+");";
			 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			   java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				    value=rs.getString(DatabaseKey.password);
					return value;

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
		
		return value;
	}

}
