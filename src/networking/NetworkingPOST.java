package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.omg.CORBA.portable.OutputStream;

public class NetworkingPOST {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		POSTMETHOD();
	}
	public static void POSTMETHOD(){

		 try {
			 //POST METHOD
			 String insertbar="http://localhost:8080/Bar/rest/insertBar";
			 //input
			// {"userprofileid":10002,
			//	 "barname":"LokeshBar"}
			//POST METHOD
			 String manageuser="http://localhost:8080/BarProject/rest/manageUserProfile";
			 //POST METHOD
			 String updateuser="http://localhost:8080/BarProject/rest/updateUserbyProfileId";
			 
			 //POST METHOD
			 String login="http://localhost:8080/BarProject/rest/userLogin";
			 String changepassword="http://localhost:8080/BarProject/rest/changePassword";
			 	String getliquorlist="http://localhost:8080/BarProject/rest/getLiquorList";
//			 {
//			      
//			      "useremail": "9952904912",
//			      "useremail": "v.t.a378@gmail.com"
//			   
//			          
//			}
			 //Content-Type: application/json
			 //INPUT TYPE METHOD
//			 {
//			      "userfirstname": "sannu",
//			      "userlastname": "gisin",
//			      "usermobilenumber": "4567891230",
//			      "useremail": "sannu@gmail.com",
//			      "uservenuename": "Water bar",
//			      "usercountry": "Florida",
//			      "userofteninventory": "monthly",
//			      "userinventorytime": 1
//			          
//			}
				URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

			
          

				String input = "{\"qty\":100,\"name\":\"iPad 4\"}";


				java.io.OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 }

	}
}
