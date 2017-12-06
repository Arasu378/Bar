package networking;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import utils.Constants;



public class Updateliquorlistdata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getliquourdata();

	}
	public static void getliquourdata() {
		Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				
				String query="CALL getId_picutureurlfrom_liquorlist()";
				System.out.println("query: "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   System.out.println("Executing........ : "+rs.getRow());
					   int id=rs.getInt("_id");
					   System.out.println("ID : "+id);

					   String url=rs.getString("picture_url");
					  updatepicture(id, url);
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
				}if(st!=null){
					try{
						st.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		
	}
	public static void updatepicture(int id,String url ){
		System.out.println("Id : "+id);
		
		CallableStatement callstatement=null;
        Connection connection=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        try{
        	String insertso="{CALL update_picture_liquorlist(?,?)}";
        	//
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(insertso);
			java.net.URL urlnew = new java.net.URL(url);
			byte[] picturebytes=downloadUrl(urlnew);
			InputStream myInputStream = new ByteArrayInputStream(picturebytes);
			callstatement.setBinaryStream(1, myInputStream);		
	        callstatement.setInt(2, id);
			callstatement.execute();

        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(connection!=null){
        		try{
        			connection.close();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        	}if(callstatement!=null){
        		try{
        			callstatement.close();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        	}
        }
		
	}
	private static byte[] downloadUrl(java.net.URL toDownload) {
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	    try {
	        byte[] chunk = new byte[4096];
	        int bytesRead;
	        InputStream stream = toDownload.openStream();

	        while ((bytesRead = stream.read(chunk)) > 0) {
	            outputStream.write(chunk, 0, bytesRead);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	    return outputStream.toByteArray();
	}

}
