package consumeclass;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import utils.Constants;



public class GetLiquourPictureClass {
	
	public static InputStream getpictureres(String proid,String sectionid,String barid,String bottleid){
		Connection connection=null;
		 Blob blob=null;
		 
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			//CALL get_picturefromstream_byId(10001,4,6,62);
			int proidint=Integer.parseInt(proid);
			int sectionidint=Integer.parseInt(sectionid);
			int baridint=Integer.parseInt(barid);
			int bottleidint=Integer.parseInt(bottleid);
			String query="CALL get_picturefromstream_byId("+proidint+","+baridint+","+sectionidint+","+bottleidint+");";
			System.out.println("query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   if(rs.next()){
				  blob=rs.getBlob("Data");
				  InputStream binarystream=blob.getBinaryStream(1,blob.length());
				  return binarystream;
				  
			   }else {
				  System.out.println("Could not get the blob from data base");
				  
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
		}
		
		return null;
	}
	public static InputStream getpurchasepictureres(String proid,String id){
		Connection connection=null;
		 Blob blob=null;
		 
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			//CALL get_picturefromstream_byId(10001,4,6,62);
			int proidint=Integer.parseInt(proid);
			int id1=Integer.parseInt(id);
		
			String query="CALL get_purchasepicturefromstream("+proidint+","+id+");";
			System.out.println("query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   if(rs.next()){
				  blob=rs.getBlob("Data");
				  if(blob==null){
					  return null;
				  }
				  InputStream binarystream=blob.getBinaryStream(1,blob.length());
				  return binarystream;
				  
			   }else {
				  System.out.println("Could not get the blob from data base");
				  
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
		}
		
		return null;
	}
}
