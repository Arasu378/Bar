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

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.arasu.InsertUserLiquorClass;
import com.google.common.io.ByteStreams;

import response.GeneralResponse;
import utils.Constants;

public class InsertPurchaseListClassM {
	public static int proid;
	public int sectionid;
	public int barid;
	public String liquorname;
	public static InputStream inputstream;
	public static byte[] valueinputstream;
	public static GeneralResponse insertform( String name, String qty, String category, String subcategory, String shots, String parlevel, String distributorname, String priceunit, String binnumber, String productcode, InputStream picture, String minvalue, String maxvalue, String type, String userproid)throws Exception{
		GeneralResponse userfirst=new GeneralResponse();
		 inputstream=picture;
	        Connection connection=null;
	        try{
	            valueinputstream= ByteStreams.toByteArray(picture);
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
				 int userprofileid=Integer.parseInt(userproid);
				 proid=userprofileid;
				 double minvalue1=Double.parseDouble(minvalue);
				 	double maxvalue1=Double.parseDouble(maxvalue);
				 	CallableStatement callstatement=null;
			 		String insertquery="{CALL insert_purchaselist(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			 		System.out.println("input query : "+insertquery);
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
						try{
							callstatement = connection.prepareCall(insertquery);
							callstatement.setInt(1,userprofileid );
							callstatement.setString(2, name);
							callstatement.setString(3, qty);
							callstatement.setString(4, shots);
							callstatement.setString(5, category);
							callstatement.setString(6, subcategory);
							callstatement.setString(7, parlevel);
							callstatement.setString(8, distributorname);
							callstatement.setString(9, priceunit);
							callstatement.setString(10, binnumber);
							callstatement.setString(11, productcode);
							callstatement.setString(12, createdon);
							callstatement.setDouble(13, minvalue1);
							callstatement.setDouble(14, maxvalue1);
							InputStream myInputStream = new ByteArrayInputStream(valueinputstream); 
							callstatement.setBinaryStream(15, myInputStream);
							callstatement.setString(16, type);
				
							callstatement.execute();

							System.out.println("Record is inserted into DBUSER table!");

						}catch(Exception e){
							e.printStackTrace();
						}
						try{
							int bottleid=getIdforPicture(userprofileid, name);
							System.out.println("bottle ID: "+bottleid);
							System.out.println("details : "+proid+" / "+name);

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
									
							}else{
								System.out.println("failed");
								 userfirst.setIsSuccess(false);
									userfirst.setMessage("picture cannot be added to the table");
									

							}
							
						}catch(Exception e){
							e.printStackTrace();
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
