package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.codec.binary.Base64;

import utils.Constants;

public class ChangePasswordModel {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static UserFirst ChangePasswordMethod(PasswordClass passwordclass){
		UserFirst userfirst=new UserFirst();
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String oldpassword=passwordclass.getOldpassword();
			String newpassword=passwordclass.getNewpassword();
			int proid=passwordclass.getUserprofileid();
			//CALL update_password(10001,'arasu378');
			
			byte[] encodedBytes = Base64.encodeBase64(newpassword.getBytes());
			System.out.println("encodedBytes " + new String(encodedBytes));
			String new_encryptedpassword=new String (encodedBytes);
			//new_encryptedpassword="'"+new_encryptedpassword+"'";
			String query="CALL update_password("+"'"+proid+"'"+","+"'"+new_encryptedpassword+"'"+")";
			   String passs=getOldpassword(proid);
			   byte[] decodedBytes = Base64.decodeBase64(passs);
				System.out.println("decoded_password : " + new String(decodedBytes));
				String decrypted_password=new String(decodedBytes);
			   	if(!decrypted_password.equals(oldpassword)){
			   		UserFirst as=new UserFirst();
			   		as.setIsSuccess(false);
			   		as.setMessage("old password does not match");
			   		as.setUserList(null);
			   		return as;
			   	}
			System.out.println("query password: "+query); 
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			PreparedStatement stmt = connection.prepareStatement(query);
            int i=stmt.executeUpdate();

            if(i>0){
            	   System.out.println("success");
	                  userfirst.setIsSuccess(true);
						userfirst.setMessage("Password Change Successfully");
            }else{
            	  System.out.println("stuck somewhere");
	                 userfirst.setIsSuccess(false);
						userfirst.setMessage("Password not changed");
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
	public static String  getOldpassword(int proid){
		String result=null;
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL get_userprofile_id("+"'"+proid+"'"+")";
			System.out.println("query getprofileid: "+query); 
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			 java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
            while(rs.next()){
            	 result=rs.getString("password");
            	
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
		
		
		return result;
	}
}
