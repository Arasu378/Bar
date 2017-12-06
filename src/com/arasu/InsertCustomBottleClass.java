package com.arasu;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import model.TestImage;
import utils.Constants;

public class InsertCustomBottleClass {
	public static InsertUserLiquorResponse insertcustombottle(InsertUserLiquorModel model){
		InsertUserLiquorResponse userfirst=new InsertUserLiquorResponse();
		 Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 Date date = new Date();
				 System.out.println(dateFormat.format(date)); 
				 String createdon=dateFormat.format(date);
				 createdon="'"+createdon+"'";
				 String  userprofileid1=model.getUserProfileId();
				 int userprofileid=Integer.parseInt(userprofileid1);
				 String  barid1=model.getBarId();
				 int barid=Integer.parseInt(barid1);
				 String  sectionid1=model.getSectionId();
				 	int sectionid=Integer.parseInt(sectionid1);
				 String liquorname=model.getLiquorName();
				 liquorname="'"+liquorname+"'";
				 String liquorquantitiy=model.getLiquorCapacity();
				 liquorquantitiy="'"+liquorquantitiy+"'";
				 String parvalue=model.getParLevel();
				 parvalue="'"+parvalue+"'";
				 String category=model.getCategory();
				 category="'"+category+"'";
				 String shots=model.getShots();
				 shots="'"+shots+"'";
				 String subcategory=model.getSubCategory();
				 subcategory="'"+subcategory+"'";
				 String distributorname=model.getDistributorName();
				 distributorname="'"+distributorname+"'";
				 String price=model.getPrice();
				 price="'"+price+"'";
				 String binnumber=model.getBinNumber();
				 binnumber="'"+binnumber+"'";
				 String productcode=model.getProductCode();
				 productcode="'"+productcode+"'";
				 String  minvalue1=model.getMinValue();
				 double minvalue=Double.parseDouble(minvalue1);
				 String  maxvalue1=model.getMaxValue();
				 	double maxvalue=Double.parseDouble(maxvalue1);
				
//				 byte[] decoded = Base64.getDecoder().decode(pic1.getBytes());
//		            byte[]decodedString= Base64.decode(picture.getBytes(),Base64.DEFAULT);

				
//				 InputStream is = new ByteArrayInputStream(pic1);
				 		CallableStatement callstatement=null;
				 		String insertso="{CALL insert_user_custombottle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				 		
			//	 String query="CALL insert_user_custombottle("+userprofileid+","+barid+","+sectionid+","+liquorname+","+liquorquantitiy+","+shots+","+category+","+subcategory+","+parvalue+","+distributorname+","+price+","+binnumber+","+productcode+","+createdon+","+minvalue+","+maxvalue+","+"'"+is+"'"+");";
				//	System.out.println("query :"+query);
					
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
					try{
						callstatement = connection.prepareCall(insertso);
						callstatement.setInt(1,userprofileid );
						callstatement.setInt(2, barid);
						callstatement.setInt(3, sectionid);
						callstatement.setString(4, liquorname);
						callstatement.setString(5, liquorquantitiy);
						callstatement.setString(6, shots);
						callstatement.setString(7, category);
						callstatement.setString(8, subcategory);
						callstatement.setString(9, parvalue);
						callstatement.setString(10, distributorname);
						callstatement.setString(11, price);
						callstatement.setString(12, binnumber);
						callstatement.setString(13, productcode);
						callstatement.setString(14, createdon);
						callstatement.setDouble(15, minvalue);
						callstatement.setDouble(16, maxvalue);
						//callstatement.setBinaryStream(17, is);


						// execute insertDBUSER store procedure
						callstatement.executeUpdate();

						System.out.println("Record is inserted into DBUSER table!");
						
			 		}catch(Exception e){
			 			e.printStackTrace();
			 		}
//			           PreparedStatement stmt = connection.prepareStatement(query);
//			           int i=stmt.executeUpdate();
//			           if(i>0)
//			           {
//				           	
//			                 System.out.println("success");
//								return InsertUserLiquorClass.getuserliquorlist(userprofileid,sectionid);
//			           }
//			                 else
//			           {
//			                System.out.println("stuck somewhere");
//			                userfirst.setIsSuccess(false);
//						userfirst.setMessage("Liquor not added");
//			           }
				
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
