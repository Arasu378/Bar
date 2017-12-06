package com.arasu;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.TestImage;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.common.io.ByteStreams;

import utils.Constants;

@Path("/insertCustomBottle")

public class InsertCustomBottleAPI {
	public int proid;
	public int sectionid;
	public int barid;
	public String liquorname;
	public static InputStream inputstream;
	public static byte[] valueinputstream;
	public static void main(String[] args) {
}
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public InsertUserLiquorResponse insertcustombottole(InsertUserLiquorModel model){
//		return InsertCustomBottleClass.insertcustombottle(model);
//	}
	@POST
	@Secured
    @Consumes(value={MediaType.MULTIPART_FORM_DATA})
 @Produces(MediaType.APPLICATION_JSON)
    public InsertUserLiquorResponse uploadFileWithData(
            @FormDataParam("image") InputStream fileInputStream,
          //  @FormDataParam("image") FormDataContentDisposition cdh,
            @FormDataParam("userprofileid")String userprofileid1,
            @FormDataParam("barid")String barid1,
            @FormDataParam("sectionid")String sectionid1,
            @FormDataParam("liquorname")String liquorname,
            @FormDataParam("liquorquantitiy")String liquorquantitiy,
            @FormDataParam("parvalue")String parvalue,
            @FormDataParam("category")String category,
            @FormDataParam("shots")String shots,
            @FormDataParam("subcategory")String subcategory,
            @FormDataParam("distributorname")String distributorname,
            @FormDataParam("price")String price,
            @FormDataParam("binnumber")String binnumber,
            @FormDataParam("productcode")String productcode,
            @FormDataParam("minvalue")String minvalue1,
            @FormDataParam("maxvalue")String maxvalue1,
            @FormDataParam("type")String type) throws Exception{
		InsertUserLiquorResponse userfirst=new InsertUserLiquorResponse();
		InsertUserLiquorModel model=new InsertUserLiquorModel();
//        Image img = ImageIO.read(fileInputStream);
//        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
//        
       // System.out.println(cdh.getName());
        inputstream=fileInputStream;
        try{
            valueinputstream= ByteStreams.toByteArray(fileInputStream);

        }catch(Exception e){
        	e.printStackTrace();
        }
//        System.out.println(emp);

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
			// createdon="'"+createdon+"'";
			 int userprofileid=Integer.parseInt(userprofileid1);
			 proid=userprofileid;
			 int barid=Integer.parseInt(barid1);
			this. barid=barid;
			 	int sectionid=Integer.parseInt(sectionid1);
			 	this.sectionid=sectionid;
			 	this.liquorname=liquorname;
			// liquorname="'"+liquorname+"'";
			// liquorquantitiy="'"+liquorquantitiy+"'";
//			 parvalue="'"+parvalue+"'";
//			 category="'"+category+"'";
//			 shots="'"+shots+"'";
//			 subcategory="'"+subcategory+"'";
//			 distributorname="'"+distributorname+"'";
//			 price="'"+price+"'";
//			 binnumber="'"+binnumber+"'";
//			 productcode="'"+productcode+"'";
			 double minvalue=Double.parseDouble(minvalue1);
			 	double maxvalue=Double.parseDouble(maxvalue1);
//			 TestImage  picture=model.getPicture();
//			byte[]  pic1=picture.getImage();
		
			 		CallableStatement callstatement=null;
			 		String insertso="{CALL insert_user_custombottle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			 		
		//	 String query="CALL insert_user_custombottle("+userprofileid+","+barid+","+sectionid+","+liquorname+","+liquorquantitiy+","+shots+","+category+","+subcategory+","+parvalue+","+distributorname+","+price+","+binnumber+","+productcode+","+createdon+","+minvalue+","+maxvalue+","+"'"+is+"'"+");";
			//	System.out.println("query :"+query);
				
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
					InputStream myInputStream = new ByteArrayInputStream(valueinputstream); 

					//callstatement.setBinaryStream(17, myInputStream);
					callstatement.setString(17, type);

					// execute insertDBUSER store procedure
//					callstatement.executeUpdate();
					callstatement.execute();

					System.out.println("Record is inserted into DBUSER table!");
					
					
					
		 		}catch(Exception e){
		 			e.printStackTrace();
		 		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			int bottleid=getIdforPicture(proid, barid, sectionid, liquorname);
			System.out.println("bottle ID: "+bottleid);
			System.out.println("details : "+proid+" / "+barid+" / "+sectionid+" / "+liquorname);

			if(bottleid==0){
				 userfirst.setIsSuccess(false);
					userfirst.setMessage("bottle id could not be detected");
					return userfirst;
			}
			String response=insertuserliquorpicture(bottleid, barid, inputstream, proid, sectionid);
			System.out.println("bottle response: "+response);

			if(response.equals("success")){
				System.out.println("success");
				return InsertUserLiquorClass.getuserliquorlist(proid,sectionid);
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
	public static int  getIdforPicture(int proid, int barid, int sectionid, String name){
		int value=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		 Connection connection=null;
		 try{
			 name="'"+name+"'";
				String query="CALL get_liquor_id_picture_by_details("+proid+","+barid+","+sectionid+","+name+");";
				System.out.println("query : "+query);
				connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
				java.sql.Statement st=connection.createStatement();
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
		 }
		
		return value;
	}
	public static String insertuserliquorpicture(int bottleid, int barid,InputStream filestream,int proid, int sectionid ){
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
//		 updatedon="'"+updatedon+"'";
//		String query="CALL insertliquor_picture("+bottleid+","+barid+","+filestream+","+proid+","+sectionid+","+updatedon+");";
 		String query="{CALL insertliquor_picture(?,?,?,?,?,?)}";
		System.out.println("record: !"+bottleid+" / "+barid+" / "+proid+" / "+sectionid+" / "+createdon);
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
			callstatement.setInt(1,bottleid );
			callstatement.setInt(2, barid);
			InputStream myInputStream = new ByteArrayInputStream(valueinputstream); 
			callstatement.setBinaryStream(3, myInputStream);
			callstatement.setInt(4, proid);
			callstatement.setInt(5, sectionid);
			callstatement.setString(6, createdon);

			
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
