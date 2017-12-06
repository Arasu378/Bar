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
import model.InsertBarModel;

public class InsertBarClass {
public static FrontBarResponse insertBar(InsertBarModel model){
	FrontBarResponse userfirst=new FrontBarResponse();
	 Connection connection=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		int userproid=model.getUserProfileId();
		String barname=model.getBarName();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		String datecreated=dateFormat.format(date);
		String query="CALL insert_bar("+userproid+","+"'"+barname+"'"+","+"'"+datecreated+"'"+");";
		System.out.println("query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
           PreparedStatement stmt = connection.prepareStatement(query);
           int i=stmt.executeUpdate();
           
           if(i>0)
           {
           	
                 System.out.println("success");
//                userfirst.setIssucess(true);
//					userfirst.setMessage("Bar Added Successfully");
					return getBarbyuserprofileid(userproid);
           }
                 else
           {
                System.out.println("stuck somewhere");
                userfirst.setIsSuccess(false);
			userfirst.setMessage("Bar not Added");
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
public static FrontBarResponse getBarbyuserprofileid(int proid){
	FrontBarResponse userfirst=new FrontBarResponse();
	Connection connection=null;
	ArrayList<InsertBarModel>modelbar=new ArrayList<InsertBarModel>();
	modelbar.clear();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try{
		String query="CALL getbarbyuserprofileid("+proid+");";
		System.out.println("query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		java.sql.Statement st=connection.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   while(rs.next()){
			   InsertBarModel barmodel=new InsertBarModel();
			   barmodel.setBarId(rs.getInt(BarTableKey.id));
			   barmodel.setBarName(rs.getString(BarTableKey.barname));
			   barmodel.setCreatedOn(rs.getString(BarTableKey.datecreated));
		
//			  barmodel.setDateModified(rs.getString(BarTableKey.datemodified));

			   barmodel.setUserProfileId(rs.getInt(BarTableKey.userprofileid));
			   modelbar.add(barmodel);
			   userfirst.setIsSuccess(true);
			   userfirst.setMessage("");
			   userfirst.setModel(modelbar);
			   
			   
		   }
		   
		   if(modelbar.size()==0){
			   userfirst.setIsSuccess(false);
			   userfirst.setMessage("Empty bar");
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
