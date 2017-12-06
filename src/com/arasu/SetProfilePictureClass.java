package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.Constants;

public class SetProfilePictureClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static UserFirst insertUser(PictureModelClass pic){
		UserFirst userfirst=new UserFirst();
		Connection connection=null;
		String name=pic.getName();
		name='"'+name+'"';
		byte[] data=pic.getData();
		int proid=pic.getUserprofileid();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
		String query="CALL insert_picture("+name+","+data+","+proid+");";
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		 PreparedStatement stmt = connection.prepareStatement(query);
         int i=stmt.executeUpdate();
         if(i>0){
             System.out.println("success");
             userfirst.setIsSuccess(true);
				userfirst.setMessage("Picture is Added");
       }else{
            System.out.println("stuck somewhere");
            userfirst.setIsSuccess(false);
				userfirst.setMessage("Picture Not Added");
       }
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return userfirst;
	}
	public static UserFirst updateUser(PictureModelClass pic){
		UserFirst userfirst=new UserFirst();
		Connection connection=null;
		String name=pic.getName();
		byte[]data=pic.getData();
		int proid=pic.getUserprofileid();
		name='"'+name+'"';
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
		String query="CALL update_picture("+name+","+data+","+proid+");";
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		 PreparedStatement stmt = connection.prepareStatement(query);
         int i=stmt.executeUpdate();
         if(i>0){
             System.out.println("success");
             userfirst.setIsSuccess(true);
				userfirst.setMessage("Picture is Updated");
       }else{
            System.out.println("stuck somewhere");
            userfirst.setIsSuccess(false);
				userfirst.setMessage("Picture Not Updated");
       }
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return userfirst;
	}
}
