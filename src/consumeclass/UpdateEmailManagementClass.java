package consumeclass;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.arasu.InsertEmailManagementModel;

import response.GeneralResponse;
import utils.Constants;

public class UpdateEmailManagementClass {
public static GeneralResponse updateemail(InsertEmailManagementModel model){
	GeneralResponse userfirst=new GeneralResponse();
	java.sql.Connection connection=null;
	 PreparedStatement stmt=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String UserEmail=model.getUserEmail();
		UserEmail="'"+UserEmail+"'";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		String ModifiedOn=dateFormat.format(date);
		ModifiedOn="'"+ModifiedOn+"'";
		int Id=model.getId();
		
		String query="CALL update_email_management("+UserEmail+","+ModifiedOn+","+Id+");";
		System.out.println("Query: "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
         stmt = connection.prepareStatement(query);
        int i=stmt.executeUpdate();
        
        if(i>0){
        	userfirst.setIsSuccess(true);
        	userfirst.setMessage("Successfully updated!");
        
        }else{
        	userfirst.setIsSuccess(false);
        	userfirst.setMessage("Email not updated!");
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
}
