package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Networking {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//GET METHOD	
String users="http://localhost:8080/BarProject/rest/userservice/users";
//POST METHOD
String manageuser="http://localhost:8080/BarProject/rest/manageUserProfile";
//GET METHOD
String getuserprofileid="http://localhost:8080/BarProject/rest/userservice/getUserProfileId/{userprofileid}";
		
URL url = new URL("http://localhost:8080/BarProject/rest/userservice/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				try{
					JSONObject obj=new JSONObject(output);
					boolean IsSuccess=obj.getBoolean("IsSuccess");
					String message=obj.getString("message");
					JSONArray array=obj.getJSONArray("userList");
					for(int i=0;i<array.length();i++){
						JSONObject first=array.getJSONObject(i);
						int  userprofileid=first.getInt("userprofileid");
						String useruserfirstname=first.getString("userfirstname");
						String userlastname=first.getString("userlastname");
						System.out.println("UserProfile Id: "+userprofileid);
					}
				}catch(Exception i){
					i.printStackTrace();
				}
				
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

	}
}
