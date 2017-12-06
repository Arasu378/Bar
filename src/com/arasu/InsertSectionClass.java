package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utils.BarTableKey;
import utils.Constants;
import utils.SectionTableKey;
import model.InsertBarModel;
import model.InsertSectionModel;
import model.SectionBarResponse;

public class InsertSectionClass {
	public static SectionBarResponse insertSection(InsertSectionModel model){
		SectionBarResponse userfirst=new SectionBarResponse();
		 Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			int userproid=model.getUserProfileId();
			String sectionname=model.getSectionName();
			int barid=model.getBarId();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date)); 
			String datecreated=dateFormat.format(date);
			String query="CALL insert_section("+userproid+","+barid+","+"'"+datecreated+"'"+","+"'"+sectionname+"'"+");";
			System.out.println("query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0)
	           {
	           	
	                 System.out.println("success");
//	                userfirst.setIssucess(true);
//						userfirst.setMessage("Bar Added Successfully");
						return getSectionbyuserprofileid(barid);
	           }
	                 else
	           {
	                System.out.println("stuck somewhere");
	                userfirst.setIsSuccess(false);
				userfirst.setMessage("Section not Added");
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
		return userfirst;
	}
	public static SectionBarResponse getSectionbyuserprofileid(int proid){
		SectionBarResponse userfirst=new SectionBarResponse();
		Connection connection=null;
		ArrayList<InsertSectionModel>modelbar=new ArrayList<InsertSectionModel>();
		modelbar.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL getsectionbybarid("+proid+");";
			System.out.println("query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			java.sql.Statement st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   InsertSectionModel barmodel=new InsertSectionModel();
				   int BarId=rs.getInt(SectionTableKey.barid);
				   String SectionName=rs.getString(SectionTableKey.sectionname);
				   String CreatedOn=rs.getString(SectionTableKey.datecreated);
				   int SectionId=rs.getInt(SectionTableKey.id);
				   int UserProfileId=rs.getInt(SectionTableKey.userprofileid);
				   barmodel.setBarId(BarId);
				   barmodel.setSectionName(SectionName);
				   barmodel.setCreatedOn(CreatedOn);
				   barmodel.setSectionId(SectionId);
				   barmodel.setUserProfileId(UserProfileId);
			
//				  barmodel.setDateModified(rs.getString(BarTableKey.datemodified));

				   modelbar.add(barmodel);
				   userfirst.setIsSuccess(true);
				   userfirst.setMessage("");
				   userfirst.setModel(modelbar);
				   
				   
			   }
			   
			   if(modelbar.size()==0){
				   userfirst.setIsSuccess(false);
				   userfirst.setMessage("Empty section");
				   userfirst.setModel(null); 
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
		return userfirst;
	}


}
