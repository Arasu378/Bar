package consumeclass;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.ByteStreams;

import response.GeneralResponse;
import utils.Constants;

public class InsertCustomKegPurchaseClass {
	public static int proid;
	public int sectionid;
	public int barid;
	public String liquorname;
	public static InputStream inputstream;
	public static byte[] valueinputstream;
	public static void main(String[] args) {
	
	}
	public static GeneralResponse inserkegresponse(InputStream fileInputStream, String userprofileid1, String liquorname, String fullweight, String emptyweight, String parvalue, String category, String shots, String subcategory, String distributorname, String price, String binnumber, String productcode, String minvalue1, String maxvalue1, String type){
		GeneralResponse userfirst=new GeneralResponse();
		 inputstream=fileInputStream;
	        Connection connection=null;
	        try{
	            valueinputstream= ByteStreams.toByteArray(fileInputStream);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
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
				 int userprofileid=Integer.parseInt(userprofileid1);
				 proid=userprofileid;
				
				 
				 	
		
				 double minvalue=Double.parseDouble(minvalue1);
				 	double maxvalue=Double.parseDouble(maxvalue1);
//			
			
				 		CallableStatement callstatement=null;
				 		String insertso="{CALL insertpurchaselistkeg(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
					try{
						callstatement = connection.prepareCall(insertso);
						try{
							System.out.println("test : "+callstatement.toString());
						}catch(Exception e){
							e.printStackTrace();
							System.out.println("catch executing : ");

						}
						callstatement.setInt(1,userprofileid );
						callstatement.setString(2, liquorname);
						callstatement.setString(3, shots);
						callstatement.setString(4, category);
						callstatement.setString(5, subcategory);
						callstatement.setString(6, parvalue);
						callstatement.setString(7, distributorname);
						callstatement.setString(8, price);
						callstatement.setString(9, binnumber);
						callstatement.setString(10, productcode);
						callstatement.setString(11, createdon);
						callstatement.setDouble(12, minvalue);
						callstatement.setDouble(13, maxvalue);
						InputStream myInputStream = new ByteArrayInputStream(valueinputstream); 
						callstatement.setBinaryStream(14, myInputStream);
						callstatement.setString(15, type);
						callstatement.setString(16, fullweight);
						callstatement.setString(17, emptyweight);
						callstatement.execute();

						System.out.println("Record is inserted into DBUSER table!");
						
						
						
			 		}catch(Exception e){
			 			e.printStackTrace();
			 		}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				int bottleid=getIdforPicture(proid, liquorname);
				System.out.println("bottle ID: "+bottleid);

				if(bottleid==0){
					 userfirst.setIsSuccess(false);
						userfirst.setMessage("bottle id could not be detected");
						return userfirst;
				}
				String response=insertuserliquorpicture(proid, bottleid);
				System.out.println("bottle response: "+response);

				if(response.equals("success")){
					System.out.println("success");
					userfirst.setIsSuccess(true);
					userfirst.setMessage("picture added to the table");
					return userfirst;
				}else{
					System.out.println("failed");
					 userfirst.setIsSuccess(false);
						userfirst.setMessage("picture cannot be added to the table");
						return userfirst;

				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
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

public static int  getIdforPicture(int proid , String name){
	int value=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	 Connection connection=null;
	 java.sql.Statement st=null;
	 try{
		 name="'"+name+"'";
			String query="CALL get_purchaselist_byId("+proid+","+name+");";
			System.out.println("query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next()){
				   value=rs.getInt("Id");
				   
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
		 if(st!=null){
			 try{
				 st.close();
			 }catch(Exception e){
				 e.printStackTrace();
			
			 }
		 }
	 }
	
	return value;
}
public static String insertuserliquorpicture(int proid, int purchaselistid ){
	String value=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	Connection connection=null;
	try{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date)); 
		 String createdon=dateFormat.format(date);
 		String query="{CALL insertpicture_topurchasestream(?,?,?,?)}";
		System.out.println("query123 : "+query);
		CallableStatement callstatement=null;
		try{
			System.out.println("data: "+inputstream.available());

		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			callstatement = connection.prepareCall(query);
			callstatement.setInt(1,proid );
			callstatement.setInt(2, purchaselistid);
			InputStream myInputStream = new ByteArrayInputStream(valueinputstream); 
			callstatement.setBinaryStream(3, myInputStream);
			callstatement.setString(4, createdon);
			callstatement.execute();

			System.out.println("Record is inserted into picturestream table!");
			value="success";
			
 		}catch(Exception e){
 			e.printStackTrace();
 			value="failed";
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
	return value;
	}


}
