package networking;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import utils.Constants;

public class InsertRawLiquorName {

	public static void main(String[] args) {
		getdata();
		//DeleteFiles();
	}
	private static void getdata(){
		CallableStatement callstatement=null;
        Connection connection=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String folderpath="C:/Users/kyros/Desktop/partender pictures/rename partender pic/PartenderPic";
		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {

	    		String liquorname=listOfFiles[i].getName();
	    		String originalliquorname=listOfFiles[i].getName();
	    		if(liquorname.contains("liquor")){
	    			liquorname=	liquorname.replace("liquor ", "");
	    		}
		        String filename=folderpath+"/"+originalliquorname;
		        byte[] picturebytes=readBytesFromFile(filename);
		        


		     //   System.out.println("Liquor name : " + filename);
		        System.out.println("Files  : " + listOfFiles.length +" of : "+i);

	        try{
		        	//String insertso="{CALL insert_raw_picture_name(?,?)}";
		        	String insertso="{CALL insert_raw_picture_data(?,?)}";
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
					callstatement = connection.prepareCall(insertso);
					InputStream myInputStream = new ByteArrayInputStream(picturebytes);
					callstatement.setBinaryStream(1, myInputStream);
					int finalvalue=i+1;
					callstatement.setInt(2,finalvalue);
							
			//	callstatement.setString(1, liquorname);
			   // callstatement.setString(2, "JPG");
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
		        
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }

	}
	  private static byte[] readBytesFromFile(String filePath) {

	        FileInputStream fileInputStream = null;
	        byte[] bytesArray = null;

	        try {

	            File file = new File(filePath);
	            bytesArray = new byte[(int) file.length()];

	            //read file into bytes[]
	            fileInputStream = new FileInputStream(file);
	            fileInputStream.read(bytesArray);

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (fileInputStream != null) {
	                try {
	                    fileInputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	        }

	        return bytesArray;

	    }
	  public static void DeleteFiles() {
		    File file = new File("C:/Users/kyros/Desktop/partender pictures/rename partender pic/PartenderPic/Thumbs.db");
		    System.out.println("Called deleteFiles");
		    if (file.isDirectory()) {
		        for (File f : file.listFiles()) {
		            DeleteFiles();
				    System.out.println("File Source!");

		        }
		    } else {
		        file.delete();
			    System.out.println("File deleted!");

		    }
		}
}
