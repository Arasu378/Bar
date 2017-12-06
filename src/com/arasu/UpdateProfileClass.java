package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import utils.Constants;

public class UpdateProfileClass {

	 static List<User>userlist= new ArrayList<User>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public  static UserFirst UpdateUser(User user){
		String result=null;
		UserFirst userfirst=new UserFirst();
		 Connection connection=null;
		 List<User>userlist=new ArrayList<User>();
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int profileid=user.getUserProfileId();
			String firstname=user.getUserFirstName();
			firstname='"' + firstname + '"';
			 String lastname=user.getUserLastName();
			 lastname='"'+lastname+'"';
			 String mobile_number=user.getUserMobileNumber();
			 mobile_number='"'+mobile_number+'"';
			 String email=user.getUserEmail();
			 email='"'+email+'"';
			 String venue_name=user.getUserVenueName();
			 venue_name='"'+venue_name+'"';
			 String country=user.getUserCountry();
			 country='"'+country+'"';
			 String Often_inventory=user.getUserOftenInventory();
			 Often_inventory='"'+Often_inventory+'"';
			 int inventorytime=user.getUserInventoryTime();
			 String pass=user.getPassword();
			 byte[] encodedBytes = Base64.encodeBase64(pass.getBytes());
				System.out.println("encodedBytes " + new String(encodedBytes));
				String new_encryptedpassword=new String (encodedBytes);
				new_encryptedpassword='"'+new_encryptedpassword+'"';
			 
			 String createdon=user.getCreatedOn();
			 createdon='"'+createdon+'"';
			 String modifiedon=user.getModifiedOn();
			 modifiedon='"'+modifiedon+'"';
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date)); 
			 String datetime=dateFormat.format(date);
			 datetime='"'+datetime+'"';
		
			String query="CALL update_user("+profileid+","+firstname+","+lastname+","+mobile_number+","+email+","+venue_name+","+
					country+","+Often_inventory+","+inventorytime+","+datetime+","+datetime+","+new_encryptedpassword+");";
			System.out.println("query insert: "+query); 
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	            PreparedStatement stmt = connection.prepareStatement(query);
	            int i=stmt.executeUpdate();
	          Test test=new Test();

		            return test.getItemList(profileid);
		            
//	            if(i>0)
//	            {
//	                  System.out.println("success");
//	                  userfirst.setIsSuccess(true);
//						userfirst.setMessage("User is Added");
//	            }
//	                  else
//	            {
//	                 System.out.println("stuck somewhere");
//	                 userfirst.setIsSuccess(false);
//						userfirst.setMessage("User Not Added");
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
}
