package com.arasu;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.ws.rs.core.Response;

import model.TestImage;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import utils.Constants;

@Path("/multipart")
public class TestingImageMultipart {
	 @POST
		@Secured

//	    @Path("/upload2")
	    @Consumes(value={MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
	 @Produces(MediaType.APPLICATION_JSON)
	    public InsertUserLiquorResponse uploadFileWithData(
	            @FormDataParam("image") InputStream fileInputStream,
	            @FormDataParam("image") FormDataContentDisposition cdh,
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
	            @FormDataParam("maxvalue")String maxvalue1
	    		) throws Exception{
			InsertUserLiquorResponse userfirst=new InsertUserLiquorResponse();
			InsertUserLiquorModel model=new InsertUserLiquorModel();
	        Image img = ImageIO.read(fileInputStream);
	        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
	        System.out.println(cdh.getName());
//	        System.out.println(emp);

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
				 int userprofileid=Integer.parseInt(userprofileid1);
				 int barid=Integer.parseInt(barid1);
				 	int sectionid=Integer.parseInt(sectionid1);
				 liquorname="'"+liquorname+"'";
				 liquorquantitiy="'"+liquorquantitiy+"'";
				 parvalue="'"+parvalue+"'";
				 category="'"+category+"'";
				 shots="'"+shots+"'";
				 subcategory="'"+subcategory+"'";
				 distributorname="'"+distributorname+"'";
				 price="'"+price+"'";
				 binnumber="'"+binnumber+"'";
				 productcode="'"+productcode+"'";
				 double minvalue=Double.parseDouble(minvalue1);
				 	double maxvalue=Double.parseDouble(maxvalue1);
				
			
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
						callstatement.setBinaryStream(17, fileInputStream);


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
