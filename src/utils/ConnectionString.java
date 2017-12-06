package utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionString {
	public static java.sql.Connection  connection=null;
	 public static PreparedStatement stmt=null;
	public static java.sql.Statement st=null;

	public static void main(String[] args) {

	}
	public static int openPreparedStatementConnection(String query) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			System.out.println("Query  : "+query);
	        stmt = connection.prepareStatement(query);
	       i=stmt.executeUpdate();
	       return i;
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
		
		return i;
	}


}
