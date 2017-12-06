package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.UserManagementBarModel;
import response.UserManagementBarResponse;
import utils.Constants;

public class UserManagementBarClass {
public static UserManagementBarResponse getbarsbyuserprofileid(String userprofileid){
	UserManagementBarResponse userfirst=new UserManagementBarResponse();
	ArrayList<UserManagementBarModel>usermanagementlist=new ArrayList<UserManagementBarModel>();
	usermanagementlist.clear();
	Connection connection=null;
	 java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int proid=Integer.parseInt(userprofileid);
			String query="CALL getBarnamebyuserprofileid("+proid+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   String BarId=rs.getString("Id");
				   if(BarId==null){
					   BarId="";
				   }
				   String UserProfileId=rs.getString("UserProfileId");
				   if(UserProfileId==null){
					   UserProfileId="";
				   }
				   String BarName=rs.getString("BarName");
				   if(BarName==null){
					   BarName="";
				   }
				   String CreatedOn=rs.getString("CreatedOn");
				   if(CreatedOn==null){
					   CreatedOn="";
				   }
				   String ModifiedOn=rs.getString("ModifiedOn");
				   if(ModifiedOn==null){
					   ModifiedOn="";
				   }
				   UserManagementBarModel model=new UserManagementBarModel();
				   model.setBarName(BarName);
				   model.setCreatedOn(CreatedOn);
				   model.setId(BarId);
				   model.setModifiedOn(ModifiedOn);
				   model.setUserProfileId(UserProfileId);
				   usermanagementlist.add(model);
				   userfirst.setIsSuccess(true);
				   userfirst.setMessage("Successfully returned the bar list");
				   userfirst.setUserManagementList(usermanagementlist);
			   }if(usermanagementlist.size()==0){
				   userfirst.setIsSuccess(false);
				   userfirst.setMessage("Could not get the bar list!");
				   userfirst.setUserManagementList(null);
			   }
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
				connection.close();	
				}catch(Exception e){
					e.printStackTrace();
				}
			}if(st!=null){
				try{
					st.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	return userfirst;
}
}
