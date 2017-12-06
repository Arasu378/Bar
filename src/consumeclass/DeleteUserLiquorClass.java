package consumeclass;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arasu.InsertUserLiquorClass;
import com.arasu.InsertUserLiquorResponse;

import response.GeneralResponse;
import utils.Constants;

public class DeleteUserLiquorClass {
	public static InsertUserLiquorResponse deleteuserliquor(String LiquorId,String secid,String proids){
		GeneralResponse userfirst=new GeneralResponse();
		java.sql.Connection connection=null;
		 PreparedStatement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int barid=Integer.parseInt(LiquorId);
			String picturestream=deletePictureStream(barid);
			if(picturestream.equals("true")){
				String section=deleteUserLiquor(barid);
					if(section.equals("true")){
						userfirst.setIsSuccess(true);
						userfirst.setMessage("Successfully Deleted!");
					//	return userfirst;
					}else{
						userfirst.setIsSuccess(false);
						userfirst.setMessage(picturestream);
						//return userfirst;
					}
				
			}else{
				userfirst.setIsSuccess(false);
				userfirst.setMessage(picturestream);
				//return userfirst;
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
		
		
		return InsertUserLiquorClass.getuserliquorlist(Integer.parseInt(proids), Integer.parseInt(secid));
	}
	public static String  deletePictureStream(int LiquorId ){
		String finalresult=null;
		java.sql.Connection connection=null;
		java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL delete_picturestream_byliquoriD("+LiquorId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			 st=connection.createStatement();
			 boolean ss=st.execute(query);
			   System.out.println("Boolean value : "+ss);
			   if(ss){
				   ResultSet rs=st.executeQuery(query);
				   while(rs.next()){
						   finalresult="true";
							   
				   } 
			   }else{
				   finalresult="true"; 
			   	   
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
		return finalresult;
		
	}
	public static String deleteUserLiquor(int LiquorId){
		String finalresult=null;
		java.sql.Connection connection=null;
		java.sql.Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL deleteuserliquor_byliquorID("+LiquorId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			 boolean ss=st.execute(query);
			   System.out.println("Boolean value : "+ss);
			   if(ss){
				   ResultSet rs=st.executeQuery(query);
				   while(rs.next()){
						   finalresult="true";
							   
				   } 
			   }else{
				   finalresult="true"; 
			   	   
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
		return finalresult;
	}	
	public static boolean isMyResultSetEmpty(ResultSet rs) throws SQLException {
	    return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}
}
