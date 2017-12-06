package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DistributorModel;
import response.DistributorResponse;
import utils.Constants;

public class GetDistributorNameListClass {
public static	ArrayList<DistributorModel>distributorlist=new ArrayList<DistributorModel>();
	public static DistributorResponse getdistributorlist(String proid){
		DistributorResponse userfirst=new DistributorResponse();
		
		distributorlist.clear();
		 Connection connection=null;
		 java.sql.Statement st=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				
				int userprofileid=Integer.parseInt(proid);
				String query="CALL getDistributornamewithprofileid("+userprofileid+");";
				System.out.println("Query: "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				st=connection.createStatement();
				   ResultSet rs=st.executeQuery(query);
				   while(rs.next()){
					   String Id=rs.getString("Id");
					   if(Id==null){
						   Id="0";
					   }
					   String UserProfileId=rs.getString("UserProfileId");
					   if(UserProfileId==null){
						   UserProfileId="0";
					   }
					   String DistributorName=rs.getString("DistributorName");
					   if(DistributorName==null){
						   DistributorName="";
					   }
					   StringBuilder sb = new StringBuilder(DistributorName);
					   for (int index = 0; index < sb.length(); index++) {
					       char c = sb.charAt(index);
					       if (Character.isLowerCase(c)) {
					           sb.setCharAt(index, Character.toUpperCase(c));
					       } else {
					           sb.setCharAt(index, Character.toUpperCase(c));
					       }
					   }
					   	System.out.println("disnameinsmall:  "+sb.toString());
					   
					   		
					   DistributorModel model=new DistributorModel();
					   model.setDistributorName(sb.toString());
					   model.setId(Id);
					   model.setUserProfileId(UserProfileId);
					   distributorlist.add(model);
					   userfirst.setDistributorsList(distributorlist);
					   userfirst.setIsSuccess(true);
					   userfirst.setMessage("Successfully received Distributorlist");
					   
				   }
				   if(distributorlist.size()==0){
						  userfirst.setIsSuccess(false);
						  userfirst.setMessage("could not get the distributors list");
						  userfirst.setDistributorsList(null);
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
