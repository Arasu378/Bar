package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.arasu.InsertSectionClass;

import model.InsertSectionModel;
import model.SectionBarResponse;
import response.GeneralResponse;
import utils.Constants;

public class UpdateSectionNameClass {
	public static SectionBarResponse updatesection_name(InsertSectionModel model){
		GeneralResponse userfirst=new GeneralResponse();
		
		 Connection connection=null;
		 PreparedStatement stmt=null;
		 int proid=model.getUserProfileId();
		 int barid=model.getBarId();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				int SectionId=model.getSectionId();
				String SectionName=model.getSectionName();
				SectionName="'"+SectionName+"'";
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 Date date = new Date();
				 System.out.println(dateFormat.format(date)); 
				String ModifiedOn=dateFormat.format(date);
				ModifiedOn="'"+ModifiedOn+"'";
				String query="CALL update_section_name("+ModifiedOn+","+SectionName+","+SectionId+");";
				System.out.println("Query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	            stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0){
	                 System.out.println("success"+" / "+"proid : "+proid);
	                userfirst.setIsSuccess(true);
						userfirst.setMessage("Section updated Successfully");
	           }else{
	                System.out.println("stuck somewhere");
	                userfirst.setIsSuccess(false);
				userfirst.setMessage("Section not updated");
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
					if(stmt!=null){
						try{
							stmt.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
			}
		return InsertSectionClass.getSectionbyuserprofileid(barid);
		
	}

}
