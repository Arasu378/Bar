package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.InsertUserManagementBarModel;
import model.UserManagementBarModel;
import response.UserManagementBarResponse;
import utils.Constants;

public class GetUserManagementClass {
public static UserManagementBarResponse getusermangement(String proid){
	UserManagementBarResponse userfirst=new UserManagementBarResponse();
	ArrayList<UserManagementBarModel>usermodellist=new ArrayList<UserManagementBarModel>();
	usermodellist.clear();
	 Connection connection=null;
	 java.sql.Statement stmt=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int userprofileid=Integer.parseInt(proid);
		
		String query="CALL getUserManagement("+userprofileid+");";
		System.out.println("query: "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		stmt=connection.createStatement();
		   ResultSet rs=stmt.executeQuery(query);
		   while(rs.next()){
			   String Id =rs.getString("Id");
			   if(Id==null){
				   Id="";
			   }
			   ArrayList<InsertUserManagementBarModel>modellist=getbarnamelist(Integer.parseInt(Id));
			   String UserProfileId=rs.getString("UserProfileId");
			   if(UserProfileId==null){
				   UserProfileId="";
			   }
			   String UserName=rs.getString("UserName");
			   if(UserName==null){
				   UserName="";
			   }
			   String UserEmail=rs.getString("UserEmail");
			   if(UserEmail==null){
				   UserEmail="";
			   }

			   String CreatedOn=rs.getString("CreatedOn");
			   if(CreatedOn==null){
				   CreatedOn="";
			   }
			   String ModifiedOn=rs.getString("ModifiedOn");
			   if(ModifiedOn==null){
				   ModifiedOn="";
			   }
			   String UserRole=rs.getString("UserRole");
			   if(UserRole==null){
				   UserRole="";
			   }
			   String ParentUserProfileId=rs.getString("ParentUserProfileId");
			   if(ParentUserProfileId==null){
				   ParentUserProfileId="0";
			   }
			  
			   UserManagementBarModel model=new UserManagementBarModel();
			   model.setCreatedOn(CreatedOn);
			   model.setModifiedOn(ModifiedOn);
			   model.setUserEmail(UserEmail);
			   model.setUserManagementId(Id);
			   model.setUserEmail(UserEmail);
			   model.setUserName(UserName);
			   model.setUserRole(UserRole);
			   model.setUserProfileId(UserProfileId);
			   model.setBarList(modellist);
			   model.setParentUserProfileId(ParentUserProfileId);
			  
			   
			   usermodellist.add(model);
			   userfirst.setIsSuccess(true);
			   userfirst.setMessage("Successfully returned user management");
			   userfirst.setUserManagementList(usermodellist);
			   
			   
		   }
		   if(usermodellist.size()==0){
			   userfirst.setIsSuccess(false);
			   userfirst.setMessage("Could not able to get the usermanagement");
			   userfirst.setUserManagementList(null);
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
				if(stmt!=null){
					try{
						stmt.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return userfirst;
}
public static ArrayList<InsertUserManagementBarModel> getbarnamelist(int userManagementId){
	ArrayList<InsertUserManagementBarModel> barlist=new ArrayList<InsertUserManagementBarModel>();
	
	barlist.clear();
	 Connection connection=null;
	 java.sql.Statement stmt=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL get_all_usermanagement_bar("+userManagementId+");";
		System.out.println("query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		stmt=connection.createStatement();
		   ResultSet rs=stmt.executeQuery(query);
		   while(rs.next()){
			   int Id=rs.getInt("Id");
			   int UserManagementId=rs.getInt("UserManagementId");
			   String BarName=rs.getString("BarName");
			   String CreatedOn=rs.getString("CreatedOn");
			   String ModifiedOn=rs.getString("ModifiedOn");
			   int UserProfileId=rs.getInt("UserProfileId");
			   int BarId=rs.getInt("BarId");
			   InsertUserManagementBarModel model=new InsertUserManagementBarModel();
			   model.setBarId(BarId);
			   model.setBarName(BarName);
			   model.setCreatedOn(CreatedOn);
			   model.setModifiedOn(ModifiedOn);
			   model.setId(String.valueOf(Id));
			   model.setUserManagementId(UserManagementId);
			   model.setUserProfileId(String.valueOf(UserProfileId));
			   barlist.add(model);
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
	
	return barlist;
}
}
