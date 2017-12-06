package consumeclass;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.ParseException;








import org.json.JSONArray;
import org.json.JSONObject;

import utils.Constants;

public class SalesCrmTest {
	 private static String URL="jdbc:mysql://127.0.0.1:3306/salescrm";
	public static void main(String[] args) {
		 String FileName="C:/Users/kyros/Videos/currency.json";

		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		 
		 try {
			updatedata(FileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void updatedata(String fileName)throws FileNotFoundException,
     IOException, ParseException {
			CallableStatement callstatement=null;
	        Connection connection=null;
            String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
            	try{
            		JSONArray array=new JSONArray(text);
        			System.out.println("Total size : "+array.length());

            		for(int i=0; i<array.length();i++){
            			JSONObject obj=array.getJSONObject(i);
            			String Code=obj.getString("Code");
            			String CountryName=obj.getString("Country Name");
            		//	System.out.println("code : "+Code+" / "+"Country Name : "+CountryName);
            			
            			   try{
           		        	String insertso="{CALL insert_currency(?,?)}";
           					connection=DriverManager.getConnection(URL,"root","");
           					callstatement = connection.prepareCall(insertso);
           					System.out.println("Inserting : "+array.length()+" of : "+i);
           					callstatement.setString(1, Code);
           					callstatement.setString(2,CountryName);
           					callstatement.execute();

           		        }catch(Exception e){
           		        	e.printStackTrace();
           		        }finally{
           		        	if(connection!=null){
           		        		try{
           		        			connection.close();
           		        		}catch(Exception e){
           		        			e.printStackTrace();
           		        		}
           		        	}if(callstatement!=null){
           		        		try{
           		        			callstatement.close();
           		        		}catch(Exception e){
           		        			e.printStackTrace();
           		        		}
           		        	}
           		        }
            		}
            	}catch(Exception e){
            		e.printStackTrace();
            	}
	        
		  
	 }
	 
}
