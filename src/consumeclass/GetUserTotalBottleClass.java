package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import response.GetUserTotalBottleResponse;
import utils.Constants;

public class GetUserTotalBottleClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
public static GetUserTotalBottleResponse getTotalBottles(String proid){
	GetUserTotalBottleResponse userfirst=new GetUserTotalBottleResponse();
	 Connection connection=null;
		java.sql.Statement st=null;
		float totalbottlesfinalvalue=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL get_totalbottles("+proid+");";
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		 st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()){
			   float value=rs.getFloat("TotalBottles");
			   if(value!=0){
				  
				   totalbottlesfinalvalue=value+totalbottlesfinalvalue;
			   }
		   }
		   userfirst.setIsSuccess(true);
		   userfirst.setMessage("Total bottles count");
		   userfirst.setTotalBottles(String.valueOf(totalbottlesfinalvalue));
			return userfirst;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception es){
					es.printStackTrace();
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
