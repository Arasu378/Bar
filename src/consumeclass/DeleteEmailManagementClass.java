package consumeclass;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.arasu.InsertEmailManagementModel;

import response.GeneralResponse;
import utils.Constants;

public class DeleteEmailManagementClass {
	public static GeneralResponse deleteemailmanagement(String id){
		GeneralResponse userfirst=new GeneralResponse();
		java.sql.Connection connection=null;
		 PreparedStatement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int Id=Integer.valueOf(id);
			String query="CALL delete_emailmanagement("+Id+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	         stmt = connection.prepareStatement(query);
	        int i=stmt.executeUpdate();
	        
	        if(i>0){
	        	userfirst.setIsSuccess(true);
	        	userfirst.setMessage("Successfully Deleted!");
	        
	        }else{
	        	userfirst.setIsSuccess(false);
	        	userfirst.setMessage("Email is not Deleted!");
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
		return userfirst;
	}

}
