package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import utils.Constants;

import com.arasu.InsertUserLiquorModel;

import model.SectionBarResponse;

public class InsertUserTotalBottlesClass {
	public static void main(String[] args) {

	}
		public static SectionBarResponse inserttotalbottles(InsertUserLiquorModel model){
			SectionBarResponse userfirst =new SectionBarResponse();
			 Connection connection=null;
			   PreparedStatement stmt =null;
			 try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			 try{
				 String totalbottle=model.getTotalBottles();
				 totalbottle="'"+totalbottle+"'";
				 String userprofileid=model.getUserProfileId();
				 int proid=Integer.parseInt(userprofileid);
				 String barid1=model.getBarId();
				 int barid=Integer.parseInt(barid1);
				 String sectionid1=model.getSectionId();
				 int sectionid=Integer.parseInt(sectionid1);
				 String name=model.getLiquorName();
				 name="'"+name+"'";
				 String query="CALL insert_usertotalbottles("+proid+","+totalbottle+","+barid+","+sectionid+","+name+")";
					System.out.println("query insert: "+query); 
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		             stmt = connection.prepareStatement(query);
		            int i=stmt.executeUpdate();
		            if(i>0){
			                  System.out.println("success");
			                  userfirst.setIsSuccess(true);
								userfirst.setMessage("Liquor total  is inserted");
			            }else{
			                 System.out.println("stuck somewhere");
			                 userfirst.setIsSuccess(false);
								userfirst.setMessage("Liquor Not inserted");
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
			return userfirst;
		}
}
