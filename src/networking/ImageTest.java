package networking;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class ImageTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bar";
		String userName = "root";
		String password = "arasu378";
		Connection con = null;
		try{
		   Class.forName(driverName);
		   con = DriverManager.getConnection(url+dbName,userName,password);
		   Statement st = con.createStatement();
		   File imgfile = new File("C:/cat.jpg");
		  
		  FileInputStream fin = new FileInputStream(imgfile);
		   PreparedStatement pre =
		   con.prepareStatement("insert into picture_stream values(?,?,?,?)");
		 
		   pre.setInt(1,3);
		   pre.setString(2,"Test");
		   pre.setBinaryStream(3,(InputStream)fin,(int)imgfile.length());
		   pre.setInt(4,300);
		   pre.executeUpdate();
		   System.out.println("Successfully inserted the file into the database!");

		   pre.close();
		   con.close(); 
		}catch (Exception e1){
			System.out.println(e1.getMessage());
		}
	}
	}


