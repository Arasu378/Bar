package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import response.GeneralResponse;
import utils.Constants;

import com.arasu.InsertUserLiquorModel;

public class UpdatePurchaseListBottleClass {

	public static GeneralResponse updatepurchaselist(InsertUserLiquorModel model){
		GeneralResponse userfirst=new GeneralResponse();
		String id=model.getId();
		String userprofileid=model.getUserProfileId();
		int proid=Integer.parseInt(userprofileid);
		String liquorname=model.getLiquorName();
		liquorname="'"+liquorname+"'";
		String type=model.getType();
		type="'"+type+"'";
		String shots=model.getShots();
		shots="'"+shots+"'";
		String category=model.getCategory();
		category="'"+category+"'";
		String subcategory=model.getSubCategory();
		subcategory="'"+subcategory+"'";
		String parvalue=model.getParLevel();
		parvalue="'"+parvalue+"'";
		String disname=model.getDistributorName();
		disname="'"+disname+"'";
		String price=model.getPrice();
		price="'"+price+"'";
		String binnumber=model.getBinNumber();
		binnumber="'"+binnumber+"'";
		String productcode=model.getProductCode();
		productcode="'"+productcode+"'";
//		String priceunit=model.getPrice();
//		priceunit="'"+priceunit+"'";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		 String modifiedon=dateFormat.format(date);
		 modifiedon="'"+modifiedon+"'";
		 String minvalue=model.getMinValue();
		 if(minvalue==null){
			 minvalue="0.0";
		 }
		 String maxvalue=model.getMaxValue();
		 if(maxvalue==null){
			 maxvalue="0.0";
		 }
		 String liquorcapacity=model.getLiquorCapacity();
		 liquorcapacity="'"+liquorcapacity+"'";
		 int idinput=Integer.parseInt(id);
		 double minval=Double.parseDouble(minvalue);
		 double maxval=Double.parseDouble(maxvalue);
		 
		 Connection connection=null;
		 PreparedStatement stmt=null;
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
				String query="CALL update_purchase_list_bottle("+idinput+","+proid+","+liquorname+","+liquorcapacity+","+shots+","+category+","+subcategory+","+parvalue+","+disname+","+price+","+binnumber+","+productcode+","+modifiedon+","+minval+","+maxval+","+type+");";
				System.out.println("query: "+query);

				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		             stmt = connection.prepareStatement(query);
		            int i=stmt.executeUpdate();
		            if(i>0){
		            	userfirst.setIsSuccess(true);
		            	userfirst.setMessage("Successfully modified the bottle");
		            	return userfirst;	
		            }           	
		            else{
		            	userfirst.setIsSuccess(false);
		            	userfirst.setMessage("modified the bottle failed");
		            	return userfirst;
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
		 
		 
		 return userfirst;
	}
}
