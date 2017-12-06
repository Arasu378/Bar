package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.arasu.FrontBarResponse;
import com.arasu.InsertBarClass;

import model.InsertBarModel;
import response.GeneralResponse;
import utils.Constants;

public class UpdateBarNameClass {
public static FrontBarResponse updatebarname(InsertBarModel model){
	GeneralResponse userfirst=new GeneralResponse();
	 Connection connection=null;
	 PreparedStatement stmt=null;
	 int proid=model.getUserProfileId();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int BarId=model.getBarId();
			String BarName=model.getBarName();
			BarName="'"+BarName+"'";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date)); 
			String ModifiedOn=dateFormat.format(date);
			ModifiedOn="'"+ModifiedOn+"'";
			String query="CALL update_barname("+BarName+","+BarId+","+ModifiedOn+");";
			System.out.println("Query : "+query);
			
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	            stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	                 System.out.println("success");
	                userfirst.setIsSuccess(true);
						userfirst.setMessage("Bar updated Successfully");
	           }else{
	                System.out.println("stuck somewhere");
	                userfirst.setIsSuccess(false);
				userfirst.setMessage("Bar not updated");
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
	
	return InsertBarClass.getBarbyuserprofileid(proid);
}
}
