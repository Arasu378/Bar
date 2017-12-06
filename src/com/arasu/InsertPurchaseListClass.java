package com.arasu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utils.Constants;
import utils.PurchaseListTableKey;

public class InsertPurchaseListClass {
	public static InsertUserLiquorResponse insertpurchaselist(InsertUserLiquorModel model){
		InsertUserLiquorResponse userfirst=new InsertUserLiquorResponse();
		Connection connection=null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String  proid1=model.getUserProfileId();
			int proid=Integer.parseInt(proid1);
			String name=model.getLiquorName();
			name="'"+name+"'";
			String capacity=model.getLiquorCapacity();
			capacity="'"+capacity+"'";
			String shots=model.getShots();
			shots="'"+shots+"'";
			String category=model.getCategory();
			category="'"+category+"'";
			String subcategory=model.getSubCategory();
			subcategory="'"+subcategory+"'";
			String parlevel=model.getParLevel();
			parlevel="'"+parlevel+"'";
			String distributorname=model.getDistributorName();
			distributorname="'"+distributorname+"'";
			String priceunit=model.getPrice();
			priceunit="'"+priceunit+"'";
			String binnumber=model.getBinNumber();
			binnumber="'"+binnumber+"'";
			String productcode=model.getProductCode();
			productcode="'"+productcode+"'";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date));
			String createdon=dateFormat.format(date);
			createdon="'"+createdon+"'";
			String query="CALL insert_purchaselist("+proid+","+name+","+capacity+","+shots+","+category+","+subcategory+","+parlevel+","+distributorname+","+priceunit+","+binnumber+","+productcode+","+createdon+");";
			System.out.println("query: "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
	           PreparedStatement stmt = connection.prepareStatement(query);
	           int i=stmt.executeUpdate();
	           
	           if(i>0)
	           {
	        	   System.out.println("success");
						return getpurchaselistbyuserprofilid(proid);   
	           }else{
	        	   System.out.println("stuck somewhere");
	                userfirst.setIsSuccess(false);
				userfirst.setMessage("could  not get the purchase list"); 
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
	public static InsertUserLiquorResponse getpurchaselistbyuserprofilid(int proid){
		InsertUserLiquorResponse userfirst=new InsertUserLiquorResponse();
		ArrayList<InsertUserLiquorModel>model=new ArrayList<InsertUserLiquorModel>();
		model.clear();
		Connection connection=null;
		java.sql.Statement st=null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			String query="CALL get_purchaselist_byuserprofileid("+proid+");";
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		 st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   InsertUserLiquorModel ins=new InsertUserLiquorModel();
				   String Id=rs.getString(PurchaseListTableKey.Id);
				   if(Id==null){
					   Id="";
				   }
				   String UserProfileId=rs.getString(PurchaseListTableKey.UserProfileId);
				   if(UserProfileId==null){
					   UserProfileId="";
				   }
				   String LiquorName=rs.getString(PurchaseListTableKey.LiquorName);
				   if(LiquorName==null){
					   LiquorName="";
				   }
				   String LiquorCapacity=rs.getString(PurchaseListTableKey.LiquorCapacity);
				   if(LiquorCapacity==null){
					   LiquorCapacity="";
				   }
				  String Shots=rs.getString(PurchaseListTableKey.Shots);
				  if(Shots==null){
					  Shots="";
				   }
				  String Category=rs.getString(PurchaseListTableKey.Category);
				  if(Category==null){
					  Category="";
				   }
				  String SubCategory=rs.getString(PurchaseListTableKey.SubCategory);
				  if(SubCategory==null){
					  SubCategory="";
				   }
				   String ParLevel=rs.getString(PurchaseListTableKey.ParLevel);
				   if(ParLevel==null){
					   ParLevel="";
					   }
				   String DistributorName=rs.getString(PurchaseListTableKey.DistributorName);
				   if(DistributorName==null){
					   DistributorName="";
					   }
				   String PriceUnit=rs.getString(PurchaseListTableKey.PriceUnit);
				   if(PriceUnit==null){
					   PriceUnit="";
					   }
				   String BinNumber=rs.getString(PurchaseListTableKey.BinNumber);
				   if(BinNumber==null){
					   BinNumber="";
					   }
				   String ProductCode=rs.getString(PurchaseListTableKey.ProductCode);
				   if(ProductCode==null){
					   ProductCode="";
					   }
				   String CreatedOn=rs.getString(PurchaseListTableKey.CreatedOn);
				   if(CreatedOn==null){
					   CreatedOn="";
					   }
				   String MinValue=rs.getString(PurchaseListTableKey.MinValue);
				   if(MinValue==null){
					   MinValue="";
					   }
				   String MaxValue=rs.getString(PurchaseListTableKey.MaxValue);
				   if(MaxValue==null){
					   MaxValue="";
					   }
				   String Type=rs.getString(PurchaseListTableKey.Type);
				   if(Type==null){
					   Type="";
					   }
				   String FullWeight=rs.getString(PurchaseListTableKey.FullWeight);
				   if(FullWeight==null){
					   FullWeight="";
					   }
				   String EmptyWeight=rs.getString(PurchaseListTableKey.EmptyWeight);
				   if(EmptyWeight==null){
					   EmptyWeight="";
					   }
				   String TotalBottles=rs.getString(PurchaseListTableKey.TotalBottles);
				   if(TotalBottles==null){
					   TotalBottles="";
					   }
				   
				   ins.setId(Id);
				   ins.setUserProfileId(UserProfileId);
				   ins.setLiquorName(LiquorName);
				   ins.setLiquorCapacity(LiquorCapacity);
				   ins.setShots(Shots);
				   ins.setCategory(Category);
				   ins.setSubCategory(SubCategory);
				   ins.setParLevel(ParLevel);
				   ins.setDistributorName(DistributorName);
				   ins.setPrice(PriceUnit);
				   ins.setBinNumber(BinNumber);
				   ins.setProductCode(ProductCode);
				   ins.setCreatedOn(CreatedOn);
				   ins.setMinValue(MinValue);

				   ins.setMaxValue(MaxValue);

				   ins.setType(Type);
				   ins.setFullWeight(FullWeight);

				   ins.setEmptyWeight(EmptyWeight);

				   ins.setTotalBottles(TotalBottles);
				   ins.setPictureURL(Constants.PURCHASE_PICTURE_URL+UserProfileId+"/"+Id);

				   model.add(ins);
				   userfirst.setIsSuccess(true);
					  userfirst.setMessage("success");
					  userfirst.setModel(model);
			   
			   }
			   if(model.size()==0){
					  userfirst.setIsSuccess(false);
					  userfirst.setMessage("could not get the liquor list");
					  userfirst.setModel(null);
				   }
				System.out.println("query: "+query);
			
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
		
		return userfirst;
		
	}

}
