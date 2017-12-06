package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import utils.Constants;

import com.arasu.InsertUserLiquorModel;
import com.arasu.InsertUserLiquorResponse;

public class GetValueOnHandClass {
	public static InsertUserLiquorResponse getValueOnhand(String proid){
		InsertUserLiquorResponse userfirst=new InsertUserLiquorResponse();
		ArrayList<InsertUserLiquorModel>model=new ArrayList<InsertUserLiquorModel>();
		model.clear();
		 Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				
				int userprofileid=Integer.parseInt(proid);
				String query="CALL gettotal_liquorlistby_proid("+userprofileid+")";
				System.out.println("query: "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   
				   while(rs.next()){
					   InsertUserLiquorModel ins=new InsertUserLiquorModel();
					   int Id=rs.getInt("Id");
//					   if(Id==null){
//						   Id="0";
//					   }
					   int UserProfileId=rs.getInt("UserProfileId");
//					   if(UserProfileId==null){
//						   UserProfileId="0";
//					   }
					   int BarId=rs.getInt("BarId");
//					   if(BarId==null){
//						   BarId="0";
//					   }
					   int SectionId=rs.getInt("SectionId");
//					   if(SectionId==null){
//						   SectionId="0";
//					   }
					   String LiquorName=rs.getString("LiquorName");
					   if(LiquorName==null){
						   LiquorName="";
					   }
					   String LiquorCapacity=rs.getString("LiquorCapacity");
					   if(LiquorCapacity==null){
						   LiquorCapacity="";
					   }
					   String Shots=rs.getString("Shots");
					   if(Shots==null){
						   Shots="";
					   }
					   String Category=rs.getString("Category");
					   if(Category==null){
						   Category="";
					   }
					   String SubCategory=rs.getString("SubCategory");
					   if(SubCategory==null){
						   SubCategory="";
					   }
					   String ParLevel=rs.getString("ParLevel");
					   if(ParLevel==null){
						   ParLevel="";
					   }
					   String DistributorName=rs.getString("DistributorName");
					   if(DistributorName==null){
						   DistributorName="";
					   }
					   String PriceUnit=rs.getString("PriceUnit");
					   if(PriceUnit==null){
						   PriceUnit="";
					   }
					   String BinNumber=rs.getString("BinNumber");
					   if(BinNumber==null){
						   BinNumber="";
					   }
					   String ProductCode=rs.getString("ProductCode");
					   if(ProductCode==null){
						   ProductCode="";
					   }
					   String CreatedOn=rs.getString("CreatedOn");
					   if(CreatedOn==null){
						   CreatedOn="";
					   }
					   String ModifiedOn=rs.getString("ModifiedOn");
					   if(ModifiedOn==null){
						   ModifiedOn="";
					   }
					   float MaxValue=rs.getFloat("MaxValue");
//					   if(MaxValue==null){
//						   MaxValue="";
//					   }
					   float MinValue=rs.getFloat("MinValue");
//					   if(MinValue==null){
//						   MinValue="";
//					   }
					   float TotalBottles=rs.getFloat("TotalBottles");
//					   if(TotalBottles==null){
//						   TotalBottles="";
//					   }
					   String Type=rs.getString("Type");
					   if(Type==null){
						   Type="";
					   }
					   String FullWeight=rs.getString("FullWeight");
					   if(FullWeight==null){
						   FullWeight="";
					   }
					   String EmptyWeight=rs.getString("EmptyWeight");
					   if(EmptyWeight==null){
						   EmptyWeight="";
					   }
					   ins.setId(String.valueOf(Id));
					   ins.setUserProfileId(String.valueOf(UserProfileId));
					   ins.setBarId(String.valueOf(BarId));
					   ins.setSectionId(String.valueOf(SectionId));
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
					   ins.setModifiedOn(ModifiedOn);
					   ins.setMaxValue(String.valueOf(MaxValue));
					   ins.setMinValue(String.valueOf(MinValue));
					   ins.setTotalBottles(String.valueOf(TotalBottles));
					   ins.setType(Type);
					   ins.setFullWeight(FullWeight);
					   ins.setEmptyWeight(EmptyWeight);
					   ins.setPictureURL(Constants.PICTURE_URL+rs.getString("UserProfileId")+"/"+rs.getString("BarId")+"/"+rs.getString("SectionId")+"/"+rs.getString("Id"));
					   model.add(ins);
					   userfirst.setIsSuccess(true);
						  userfirst.setMessage("Success");
						  userfirst.setModel(model);
				   }
				   if(model.size()==0){
						  userfirst.setIsSuccess(false);
						  userfirst.setMessage("could not get the liquor list");
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
