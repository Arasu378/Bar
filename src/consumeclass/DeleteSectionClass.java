package consumeclass;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SectionBarResponse;

import com.arasu.InsertSectionClass;

import response.GeneralResponse;
import utils.Constants;

public class DeleteSectionClass {
public static SectionBarResponse deleteSection(String BarId,String proid1){
	GeneralResponse userfirst=new GeneralResponse();
	java.sql.Connection connection=null;
	java.sql.Statement st=null;
	int proid=Integer.parseInt(proid1);
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int barid=Integer.parseInt(BarId);
		String picturestream=deletePictureStream(barid);
		if(picturestream.equals("true")){
			String userliquor=deleteUserLiquor(barid);
			if(userliquor.equals("true")){
				String section=delteUsersection(barid);
				if(section.equals("true")){
					userfirst.setIsSuccess(true);
					userfirst.setMessage("Successfully Deleted!");
					//return userfirst;
				}else{
					userfirst.setIsSuccess(false);
					userfirst.setMessage(picturestream);
					//return userfirst;
				}
			}else{
				userfirst.setIsSuccess(false);
				userfirst.setMessage(picturestream);
			//	return userfirst;
			}
		}else{
			userfirst.setIsSuccess(false);
			userfirst.setMessage(picturestream);
		//	return userfirst;
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
	return InsertSectionClass.getSectionbyuserprofileid(proid);
}
public static String  deletePictureStream(int BarId ){
	String finalresult=null;
	java.sql.Connection connection=null;
	java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL Deletepicturestream_bySectionId("+BarId+");";
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
public static String deleteUserLiquor(int BarId){
	String finalresult=null;
	java.sql.Connection connection=null;
	java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL delete_userliquor_bysectionid("+BarId+");";
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
public static String delteUsersection(int BarId){
	String finalresult=null;
	java.sql.Connection connection=null;
	java.sql.Statement st=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL delete_section_bysectiondid("+BarId+");";
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
public static boolean isMyResultSetEmpty(ResultSet rs) throws SQLException {
    return (!rs.isBeforeFirst() && rs.getRow() == 0);
}
}
