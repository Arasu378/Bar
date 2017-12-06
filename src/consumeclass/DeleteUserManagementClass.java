package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import response.UserManagementBarResponse;
import utils.Constants;

public class DeleteUserManagementClass {
	public static UserManagementBarResponse delete_user(String profileid,String id){
		UserManagementBarResponse userfirst=new UserManagementBarResponse();
		 Connection connection=null;
		 PreparedStatement stmt=null;
		 int proid=Integer.parseInt(profileid);
		 int inputid=Integer.parseInt(id);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String usermanagementbar=deleteUserManagementBar(proid);
			if(usermanagementbar.equals("true")){
				String usermanagement=DeleteUserManagement(proid);
				if(usermanagement.equals("true")){
					String setnulltoparentproid=setparenetuserprofileidtonull(inputid);
					if(setnulltoparentproid.equals("true")){
						String query="CALL delete_userprofile("+inputid+");";
						System.out.println("query : "+query);
						connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				         stmt = connection.prepareStatement(query);
				           int i=stmt.executeUpdate();
				           
				           if(i>0){
				        	   userfirst.setIsSuccess(true);
								userfirst.setMessage("Successfully deleted from userprofile");
								return userfirst;
				           }else{
				        	   userfirst.setIsSuccess(false);
								userfirst.setMessage("delete :"+"Could not delete in userprofile");
								return userfirst;

				           }
						
					}else{
						userfirst.setIsSuccess(false);
						userfirst.setMessage("delete :"+setnulltoparentproid);
						return userfirst;
					}
				}else{
					userfirst.setIsSuccess(false);
					userfirst.setMessage("delete :"+usermanagement);
					return userfirst;
				}
			}else{
				userfirst.setIsSuccess(false);
				userfirst.setMessage("delete :"+usermanagementbar);
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
	public static String deleteUserManagementBar(int proid){
		String finalvalue=null;
		 Connection connection=null;
		 PreparedStatement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL delete_usermanagement_bar("+proid+");";
			System.out.println("query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	         stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	        	   finalvalue="true";
	        	   return finalvalue;
	           }else{
	        	   finalvalue="could not deleted usermanagement_bar!";
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
	public static String DeleteUserManagement(int proid){
		String finalvalue=null;
		 Connection connection=null;
		 PreparedStatement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL delete_userManagement("+proid+");";
			System.out.println("query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	         stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	        	   finalvalue="true";
	        	   return finalvalue;
	           }else{
	        	   finalvalue="could not deleted usermanagement!";
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
	public static String setparenetuserprofileidtonull(int proid){
		String finalvalue=null;
		 Connection connection=null;
		 PreparedStatement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL set_parent_userprofileid_toNull("+proid+")";
			System.out.println("query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	         stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	        	   finalvalue="true";
	        	   return finalvalue;
	           }else{
	        	   finalvalue="could not set null value to parent profileid!";
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
