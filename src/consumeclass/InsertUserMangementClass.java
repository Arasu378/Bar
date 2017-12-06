package consumeclass;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.arasu.InsertUserProfile;
import com.google.gson.Gson;

import model.InsertUserManagementBarModel;
import model.UserManagementBarModel;
import response.UserManagementBarResponse;
import utils.Constants;
import utils.EmailUtils;

public class InsertUserMangementClass {
	private static int ParentUserProfileIdValue=0;
	private static String transferUserprofileid=null;
	private static int RegisteredUserManagementUserProfileId=0;
	private static String UserManagementIdTransfer=null;
public static UserManagementBarResponse insertusermangement(UserManagementBarModel model){

	UserManagementBarResponse userfirst=new UserManagementBarResponse();
	ArrayList<InsertUserManagementBarModel>barslist=new ArrayList<InsertUserManagementBarModel>();
	 Connection connection=null;
	 java.sql.Statement stmt=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String profileid=model.getUserProfileId();
		transferUserprofileid=model.getUserProfileId();;
//		String BarName=model.getBarName();
//		BarName="'"+BarName+"'";
		String UserName=model.getUserName();
		UserName="'"+UserName+"'";
		String UserEmail=model.getUserEmail();
		//int BarId=model.getBarId();
		UserEmail="'"+UserEmail+"'";
		String UserRole=model.getUserRole();
		UserRole="'"+UserRole+"'";
		String VenueName=model.getVenueName();
		VenueName="'"+VenueName+"'";
		String Country=model.getCountry();
		Country="'"+Country+"'";
		String parentUserProfileId=model.getParentUserProfileId();
		ParentUserProfileIdValue=Integer.parseInt(parentUserProfileId);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		 String CreatedOn=dateFormat.format(date);
		 CreatedOn ="'"+CreatedOn+"'";
		 int proid=Integer.parseInt(profileid);
		 barslist=model.getBarList();
		 try{
	            Gson gson=new Gson();
	            String adapterbaraccessdata=gson.toJson(barslist);
	            System.out.println("barslist data : "+adapterbaraccessdata);
	        }catch (Exception e){
	        }

		 /*use this forloop*/
		
		 String query="CALL insertUserMangement("+ proid+","+UserName+","+UserEmail+","+UserRole+","+CreatedOn+","+ParentUserProfileIdValue+");";
		 System.out.println("Query: "+query);
		 connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		 stmt=connection.createStatement();
		 ResultSet rs=stmt.executeQuery(query);
		  String UserManagementId=null;
		   while(rs.next()){
			    UserManagementId=rs.getString("LAST_INSERT_ID()");
		   }
		   if(UserManagementId!=null){
			   UserManagementIdTransfer=UserManagementId;
			   System.out.println("BarList Size : "+barslist.size());
			   if(barslist!=null && barslist.size()!=0){
				   for(int i=0;i<barslist.size();i++){
						 String barname=barslist.get(i).getBarName();
						 int barid=barslist.get(i).getBarId();
						// int  usermanageid=barslist.get(i).getUserManagementId();
						 System.out.println("managementId : "+UserManagementId+" / BarId : "+barid+" / BarName : "+barname);
						 if(barname!=null && barid!=0){
							 String value=insertusermanagemnetbar(UserManagementId, profileid, barname, barid);
							  if(value.equals("true")){
								  userfirst.setIsSuccess(true);
					        	   userfirst.setMessage("Successfully UserManagement Inserted");
					        	   userfirst.setUserManagementList(null);
							  }else {
								  userfirst.setIsSuccess(false);
								   userfirst.setMessage("insertusermanagementbar value false! : "+value);
					        	   userfirst.setUserManagementList(null);
					        	   return userfirst;

							  } 
						 }else{
							 userfirst.setIsSuccess(false);
							   userfirst.setMessage("Bar Id and Bar name is null");
				        	   userfirst.setUserManagementList(null);
				        	   return userfirst;

						 }
						
						  
					 }  
			   }else{
				   userfirst.setIsSuccess(false);
				   userfirst.setMessage("barlistempty! : ");
	        	   userfirst.setUserManagementList(null);
	        	   return userfirst;

			   }
			
			   String values=insertusermanagement_to_userprofiletable(InsertUserProfile.getlastUserProfileId(),model.getUserName(),model.getUserEmail(),model.getVenueName(),model.getCountry(),RandomPassword(),model.getUserRole());
				 System.out.println("values : "+values);

			   if(values!=null){
				   
				 String valuess=insertparentprofileid(Integer.parseInt(values));
				 System.out.println("valuess : "+valuess);
				 if(valuess.equals("true")){
					
					 String vvalue=InsertUserProfile.updateuserprofileid(Integer.parseInt(values));
					 System.out.println("VValue : "+vvalue);
					 if(vvalue!=null){
						 if(vvalue.equals("true")){
							 String jvalue=updateUserManagementParentUserProfileId();
							 if(jvalue.equals("true")){
								 userfirst.setIsSuccess(true);
								   userfirst.setMessage("Success fully added! ");
					        	   userfirst.setUserManagementList(null);
					        	   return userfirst;
							 }else{
								 userfirst.setIsSuccess(false);
								   userfirst.setMessage("update error: ! "+jvalue);
					        	   userfirst.setUserManagementList(null);
					        	   return userfirst; 
							 }
							
						 }else{
							 userfirst.setIsSuccess(false);
							   userfirst.setMessage("userprofile is not updated ");
				        	   userfirst.setUserManagementList(null);
				        	   return userfirst;
						 } 
					 }else{
						 userfirst.setIsSuccess(false);
						   userfirst.setMessage("vv value is null ");
			        	   userfirst.setUserManagementList(null);
			        	   return userfirst;
					 }
					
					
				 }else{
					 userfirst.setIsSuccess(false);
					   userfirst.setMessage("message! : "+valuess);
		        	   userfirst.setUserManagementList(null);
		        	   return userfirst;
				 }
				 
			   }else{
				   userfirst.setIsSuccess(false);
				   userfirst.setMessage("userprofile value false! : "+values);
	        	   userfirst.setUserManagementList(null);
	        	   return userfirst;

			   }
//			   return insertusermanagemnetbar(UserManagementId,profileid,BarName);
		   }else{
			   userfirst.setIsSuccess(false);
			   userfirst.setMessage("Could not get the UserManagemenId");
        	   userfirst.setUserManagementList(null);
        	   return userfirst;

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
public static String  insertusermanagemnetbar(String Id,String UserProfileId, String Barname,int BarId){
	UserManagementBarResponse userfirst=new UserManagementBarResponse();
	 Connection connection=null;
	  PreparedStatement stmt=null;
	  String finalvalue=null;
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int proid=Integer.parseInt(UserProfileId);
			int usermanagementid=Integer.parseInt(Id);
		String barname=	"'"+Barname+"'";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		 String CreatedOn=dateFormat.format(date);
		 CreatedOn ="'"+CreatedOn+"'";
		 //insertUserManagementBar
		 String query="CALL insertUserManagementBar("+proid+","+barname+","+usermanagementid+","+CreatedOn+","+BarId+","+ParentUserProfileIdValue+");";
		 System.out.println("query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	         stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
//	        	   userfirst.setIsSuccess(true);
//	        	   userfirst.setMessage("Successfully UserManagement Inserted");
//	        	   userfirst.setUserManagementList(null);
	        	   finalvalue="true";
	           }else{
	        	   userfirst.setIsSuccess(false);
	        	   userfirst.setMessage("UserManagement Not Inserted");
	        	   userfirst.setUserManagementList(null);
	        	   finalvalue="UserManagementBar not inserted!";
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
	String frompassword="arasu378";
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
//	Authenticator auth=new Authenticator() {
//		protected PasswordAuthentication getPasswordAuthentication(){
//			return new PasswordAuthentication(fromemail,frompassword);
//		}
//	};
//	
//	
//	Session session=Session.getInstance(props,auth);
	System.out.println("Session created");
	String subject="Welcome to BarApp by Kyros";
	String body="Your Password for login is : "+password;
	EmailUtils.sendEmail(session, email, subject, body);
	
//	 EmailUtils.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
//
//        EmailUtils.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
}
public static String insertusermanagement_to_userprofiletable(int UserProfileId, String UserName, String UserEmail, String VenueName, String Country, String Password,String role){
	String finalvalue=null;
	   sendemail(UserEmail,Password);
	   String uneditedemail=UserEmail;
	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		 String CreatedOn=dateFormat.format(date);
		 CreatedOn="'"+CreatedOn+"'";
		 UserName="'"+UserName+"'";
		 UserEmail="'"+UserEmail+"'";
		 VenueName="'"+VenueName+"'";
		 Country="'"+Country+"'";
		 role="'"+role+"'";
		 Password="'"+Password+"'";
		 Connection connection=null;
		  Statement stmt=null;
		 
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				 boolean emailregistered=InsertUserProfile.checkiftheuseremailexist(uneditedemail);
				 if(emailregistered){
					 finalvalue="email is already registered!";
						return finalvalue;
				 }
				UserProfileId= UserProfileId+1;
				int profileid=InsertUserProfile.getlastUserProfileId();

				String query="CALL insert_user("+profileid+","+UserName+","+null+","+null+","+UserEmail+","+VenueName+","+
						Country+","+null+","+null+","+CreatedOn+","+null+","+Password+","+null+","+role+","+null+");";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				 //  java.sql.Statement st=connection.createStatement();
				 stmt=connection.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
				  String UserProfileId2=null;
				   while(rs.next()){
					   UserProfileId2=rs.getString("LAST_INSERT_ID()");
				   }
		           
		            if(UserProfileId2!=null)
		            {
		            	
		                finalvalue=UserProfileId2;
		                RegisteredUserManagementUserProfileId=Integer.parseInt(UserProfileId2);
		               
		            }
		                  else
		            {
		                finalvalue="user not inserted into userprofile!";

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
				if(stmt!=null){
					try{
						stmt.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			
	
	return finalvalue;
}
public static String insertparentprofileid(int profileid){
	Connection connection=null;
	  PreparedStatement stmt=null;
	  String finalvalue=null;
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int transprofileid=Integer.parseInt(transferUserprofileid);
			String query="CALL insert_parentprofileid("+transprofileid+","+profileid+");";
			System.out.println("Userprofileid: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	         stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	        	   finalvalue="true";
	        	   return finalvalue;
	           }else{
	        	   finalvalue="parent id could not be added!";
	        	   return finalvalue;

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
			if(stmt!=null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
}
public static String updateUserManagementParentUserProfileId(){
	Connection connection=null;
	  PreparedStatement stmt=null;
	  String finalvalue=null;
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			if(UserManagementIdTransfer!=null&&RegisteredUserManagementUserProfileId!=0){
				int uss=Integer.parseInt(UserManagementIdTransfer);
				String query="CALL update_Usermanagement_parentUserProfileId("+RegisteredUserManagementUserProfileId+","+uss+");";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		         stmt = connection.prepareStatement(query);
		           int i=stmt.executeUpdate();
		           
		           if(i>0){
		        	   finalvalue="true";
		        	   return finalvalue;
		           }else{
		        	   finalvalue="parent id could not be added to usermanagement!";
		        	   return finalvalue;

		           }
			}else{
				 finalvalue="UserManagementIdTransfer and RegisteredUserManagementUserProfileId is null and zero!";
	        	   return finalvalue;
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
			if(stmt!=null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
}

}
