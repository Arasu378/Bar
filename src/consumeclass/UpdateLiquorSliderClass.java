package consumeclass;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.google.common.io.ByteStreams;

import response.GeneralResponse;
import utils.Constants;

public class UpdateLiquorSliderClass {
	public static int proid;
	public static int sectionid;
	public static int barid;
	public static String liquorname;
	public static InputStream inputstream;
	public static byte[] valueinputstream;
	public static void main(String[] args) {
	}
	public static GeneralResponse update_data(String bottleId, String sectionId2, String barId2, InputStream fileInputStream, FormDataContentDisposition cdh,
			String userprofileid1, String liquorname2, String liquorquantitiy, String parvalue, String category,
			String shots, String subcategory, String distributorname, String price, String binnumber, String productcode,
			String minvalue1, String maxvalue1, String type)throws Exception{
		GeneralResponse userfirst=new GeneralResponse();
		inputstream=fileInputStream;
        try{
            valueinputstream= ByteStreams.toByteArray(fileInputStream);

        }catch(Exception e){
        	e.printStackTrace();
        }
        Connection connection=null;
        CallableStatement callstatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 Date date = new Date();
			 System.out.println(dateFormat.format(date)); 
			 String ModifiedOn=dateFormat.format(date);
			 int userprofileid=Integer.parseInt(userprofileid1);
			proid=userprofileid;
			 int barids=Integer.parseInt(barId2);
			barid=barids;
			 	int sectionids=Integer.parseInt(sectionId2);
			 	sectionid=sectionids;
		
			 double minvalue=Double.parseDouble(minvalue1);
			 	double maxvalue=Double.parseDouble(maxvalue1);
			 	String query="{CALL update_liquorslider_bottle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//19 questions marks
				System.out.println("query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				try{
					callstatement = connection.prepareCall(query);
					callstatement.setInt(1,userprofileid );
					callstatement.setInt(2, barid);
					callstatement.setInt(3, sectionid);
					callstatement.setString(4, liquorname2);
					callstatement.setString(5, liquorquantitiy);
					callstatement.setString(6, shots);
					callstatement.setString(7, category);
					callstatement.setString(8, subcategory);
					callstatement.setString(9, parvalue);
					callstatement.setString(10, distributorname);
					callstatement.setString(11, price);
					callstatement.setString(12, binnumber);
					callstatement.setString(13, productcode);
					callstatement.setString(14, ModifiedOn);
					callstatement.setDouble(15, minvalue);
					callstatement.setDouble(16, maxvalue);
					InputStream myInputStream = new ByteArrayInputStream(valueinputstream); 
					callstatement.setString(17, type);

					int bottlId=Integer.parseInt(bottleId);
					callstatement.setInt(18, bottlId);
					callstatement.setBinaryStream(19, myInputStream);
					callstatement.execute();

					System.out.println("Record is inserted into DBUSER table!");
					

				}catch(Exception e){
					e.printStackTrace();
					userfirst.setIsSuccess(false);
					userfirst.setMessage("failed : "+e.getMessage());
					return userfirst;
				}
			 
				userfirst.setIsSuccess(true);
				userfirst.setMessage("Successfully Updated the data!");
				return userfirst;
			
			
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
			if(callstatement!=null){
				try{
					callstatement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return userfirst;
	}
}
