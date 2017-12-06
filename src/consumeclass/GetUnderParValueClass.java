package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import response.GetUnderParValue;
import utils.Constants;

public class GetUnderParValueClass {
	public static GetUnderParValue getparvaluelist(String proid){
		GetUnderParValue userfirst=new GetUnderParValue();
		 Connection connection=null;
			java.sql.Statement st=null;
			float totalbottlesfinalvalue=0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				String query="CALL get_underParvalue("+proid+");";
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			 st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   float value=rs.getFloat("TotalBottles");
				   float parlevel=rs.getFloat("ParLevel");
				   if(value!=0 && parlevel!=0){
					   if(value<=parlevel){
						   totalbottlesfinalvalue++;
   
					   }
					 
				   }
			   }
			   userfirst.setIsSuccess(true);
			   userfirst.setMessage("Total parvalues");
			   userfirst.setUnderParValue(String.valueOf(totalbottlesfinalvalue));
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
