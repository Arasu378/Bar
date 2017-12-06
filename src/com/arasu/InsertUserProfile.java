package com.arasu;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import utils.Constants;





import utils.DatabaseKey;
import utils.EmailUtils;

import org.apache.commons.codec.binary.Base64;


public class InsertUserProfile {

	public static UserFirst userfirst=new UserFirst();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static UserFirst insertData(User user){
		 Connection connection=null;
		 java.sql.Statement stmt=null;
		 List<User>userlist=new ArrayList<User>();
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int profileid=getlastUserProfileId();
			profileid=profileid+1;
			String firstname=user.getUserFirstName();
			firstname="'" + firstname + "'";
			 String lastname=user.getUserLastName();
			 lastname="'"+lastname+"'";
			 String mobile_number=user.getUserMobileNumber();
			 mobile_number="'"+mobile_number+"'";
			 String email=user.getUserEmail();
			 email="'"+email+"'";
			 String venue_name=user.getUserVenueName();
			 venue_name="'"+venue_name+"'";
			 String country=user.getUserCountry();
			 country="'"+country+"'";
			 String Often_inventory=user.getUserOftenInventory();
			 Often_inventory="'"+Often_inventory+"'";
			 int inventorytime=user.getUserInventoryTime();
			 
			 String createdon=user.getCreatedOn();
			 createdon="'"+createdon+"'";
			 String modifiedon=user.getModifiedOn();
			 modifiedon="'"+modifiedon+"'";
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date)); 
			 String datetime=dateFormat.format(date);
			 datetime="'"+datetime+"'";
			 String pass=RandomPassword();
			 String passtomail=pass;
				byte[] encodedBytes = Base64.encodeBase64(pass.getBytes());
				System.out.println("encoded_Password :  " + new String(encodedBytes));
				 String encrypted_password=new String (encodedBytes);
				 encrypted_password="'"+encrypted_password+"'";
			
			 pass="'"+pass+"'";
			 String role=user.getUserRole();
			 role="'"+role+"'";
			 String auth=AuthorizationKey(user.getUserEmail(), user.getPassword());
			 auth="'"+auth+"'";
			 boolean emailregistered=checkiftheuseremailexist(user.getUserEmail());
			 if(emailregistered){
				 userfirst.setIsSuccess(false);
					userfirst.setMessage("Email is already registered Please try again with new email");
					return userfirst;
			 }
		
			String query="CALL insert_user("+profileid+","+firstname+","+lastname+","+mobile_number+","+email+","+venue_name+","+
					country+","+Often_inventory+","+inventorytime+","+datetime+","+datetime+","+encrypted_password+","+auth+","+role+","+null+");";
			System.out.println("query insert: "+query); 
			sendemail(user.getUserEmail(),passtomail);
			
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			 //  java.sql.Statement st=connection.createStatement();
			 stmt=connection.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			  String userProfileId=null;
			   while(rs.next()){
				   userProfileId=rs.getString("LAST_INSERT_ID()");
			   }
	            
	            if(userProfileId!=null)
	            {
	            	String value=updateuserprofileid(Integer.parseInt(userProfileId));
	            	if(value.equals("true")){
	            		 System.out.println("success");
		                 userfirst.setIsSuccess(true);
							userfirst.setMessage("Email sent to registered email.");
	            	}else{
	            		 System.out.println("userprofileid not inserted");
		                 userfirst.setIsSuccess(false);
					userfirst.setMessage("userprofileid not inserted");
	            	}
	                 
	            }
	                  else
	            {
	                 System.out.println("stuck somewhere");
	                 userfirst.setIsSuccess(false);
				userfirst.setMessage("Email not sent");
//						userfirst.setUserList(userlist);

	            }
	        	//Test test=new Test();

	          //  return test.getItemList(profileid);
	            
	            
	            
			//   ResultSet rs=st.executeQuery(query);
//			   while(rs.next()){
//				   User userk=new User();
//				   userk.setCreatedon(rs.getString("createdon"));
//				   userk.setId(rs.getInt("id"));
//				   userk.setUserprofileid(rs.getInt("userprofileid"));
//				   userk.setUserfirstname(rs.getString("userfirstname"));
//				   userk.setUserlastname(rs.getString("userlastname"));
//				   userk.setUsermobilenumber(rs.getString("usermobilenumber"));
//				   userk.setUseremail(rs.getString("useremail"));
//				   userk.setUservenuename(rs.getString("uservenuename"));
//				   userk.setUsercountry(rs.getString("usercountry"));
//				   userk.setUserofteninventory(rs.getString("userofteninventory"));
//				   userk.setUserinventorytime(rs.getInt("userinventorytime"));
//				   userk.setUserlastlogin(rs.getString("userlastlogin"));
//				   userk.setIsactive(rs.getBoolean("isactive"));
//				   userk.setCreatedon(rs.getString("createdon"));
//				   userk.setModifiedon(rs.getString("modifiedon"));
//				   userlist.add(user);
//				   
//					System.out.println("It is working");
//					userfirst.setIsSuccess(true);
//					userfirst.setMessage("");
//					userfirst.setUserList(userlist);
//				   
//			   }if(userlist.size()==0){
//				   userfirst.setIsSuccess(false);
//					userfirst.setMessage("No user list");
//					userfirst.setUserList(userlist);
//			   }
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}if(stmt!=null){
				try{
				stmt.close();	
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return userfirst;
		
	}
	public static int getlastUserProfileId(){
		int userprofileid=0;
		 Connection connection=null;
		 
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		try{
			String query="CALL get_userprofile_lastrow()";
			 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			   java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while (rs.next()) {
				   int profileid=rs.getInt("Id");
				   System.out.println("Last User profile id: "+String.valueOf(profileid));
				   return profileid;
			   }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection !=null){
				try{
					connection.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		return userprofileid;
	}
	public static String AuthorizationKey(String email,String password){
		String key=null;
		try{
			String tobeconvert=email+":"+password;
			// encrypt data on your side using BASE64
			
			byte[] encodedBytes = Base64.encodeBase64(tobeconvert.getBytes());
			System.out.println("encodedBytes " + new String(encodedBytes));
			key=new String (encodedBytes);
			//byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
			//System.out.println("decodedBytes " + new String(decodedBytes));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}
	public static String RandomPassword(){
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		String ranpass=null;
		 StringBuilder sb = new StringBuilder( 5 );
		   for( int i = 0; i < 5; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   ranpass= sb.toString();
		
		return ranpass;
	}
	public static void sendemail(String email,String password){
		//using ssl email connections
		String fromemail="thirunavukkarasuv@kyrostechnologies.com";
		String frompassword="arasu37831";
		System.out.println("SSL Email Start");
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(fromemail, frompassword);
		    }
		});
//		Authenticator auth=new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication(){
//				return new PasswordAuthentication(fromemail,frompassword);
//			}
//		};
//		
//		
//		Session session=Session.getInstance(props,auth);
		System.out.println("Session created");
		String subject="Welcome to BarApp by Kyros";
		String body="Your Password for login is : "+password;
		EmailUtils.sendEmail(session, email, subject, body);
//		 EmailUtils.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
//
//	        EmailUtils.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
	}
public static boolean checkiftheuseremailexist(String email){
	 Connection connection=null;
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	try{
		String query="CALL get_allUsers()";
		 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		   java.sql.Statement st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   while (rs.next()){
			   String useremail=rs.getString(DatabaseKey.useremail);
			   if(useremail.equals(email)){
				   return true;
			   }
		   }
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection !=null){
			try{
				connection.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	return false;
}
public static String updateuserprofileid(int id){
	String finalvalue=null;
	 Connection connection=null;
	 PreparedStatement stmt=null;
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL update_userProfileId("+id+");";
			System.out.println("query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			 //  java.sql.Statement st=connection.createStatement();
	             stmt = connection.prepareStatement(query);
	            int i=stmt.executeUpdate();
	            
	            if(i>0){
	            	finalvalue="true";
	            }else{
	            	finalvalue="cannot update the userprofileid";
	            }
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection !=null){
				try{
					connection.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}if(stmt!=null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	return finalvalue;
}
	
}


