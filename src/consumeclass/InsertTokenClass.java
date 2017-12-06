/**
 * 
 */
package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.Constants;
import utils.DatabaseKey;

/**
 * @author kyros
 *
 */

public class InsertTokenClass {

	public static boolean findTokenIfExist(String Token){
		boolean value=false;
		Connection connection=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Token="'"+Token+"'";
			String query="CALL getToken("+Token+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				
				String token=rs.getString(DatabaseKey.userauthorizationkey);
			
				if (token!=null){
					return value=true;
					
				}
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
			if(st!=null){
				try{
					st.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}

