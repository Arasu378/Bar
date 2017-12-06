/**
 * 
 */
package com.arasu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;












import org.apache.tomcat.util.bcel.classfile.Constant;

import utils.Constants;
import utils.DatabaseKey;
import consumeclass.InsertTokenClass;

/**
 * @author kyros
 *
 */

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter  {

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		String authorizationHeader=
				requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if(authorizationHeader==null){
			throw new NotAuthorizedException("Authorization header must be provided");
			
		}
		String token=authorizationHeader.substring("Kyros".length()).trim();
		System.out.println("System Token : "+token);
		int UserProfileId=getUserProfileId(authorizationHeader);
		String headerToken=getToken(authorizationHeader);
		System.out.println("System Token : "+headerToken);
		try{
			validateTokenWithUserProfileId(UserProfileId,headerToken);
		}catch(Exception e){
			e.printStackTrace();
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			
		}
		
	}
	private void validateToken(String token)throws Exception{
		boolean value=InsertTokenClass.findTokenIfExist(token);
		System.out.println("Authentication value : "+value);
		if(!value){
			throw new NotAuthorizedException("Invalid Token!");
		}
		
	}
	private static void validateTokenWithUserProfileId(int userProfileId,String token)throws Exception{
		String orginalToken=getOriginalToken(userProfileId);
		System.out.println("Authentication value : "+orginalToken);
		if(!orginalToken.equals(token)){
			throw new NotAuthorizedException("Invalid Token!");	
		}
		
	}
	private static String getOriginalToken(int UserProfileId){
		Connection connection=null;
		Statement statement=null;
		String token=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `getTokenByUserProfileId`("+UserProfileId+");";
		
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				 token=rs.getString(DatabaseKey.USER_AUTHORIZATION_KEY);
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
			if(statement!=null){
				try{
					statement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return token;
	}
	
	private static int getUserProfileId(String token){
		StringTokenizer stringTokenizer=new StringTokenizer(token);
		String firstOne=stringTokenizer.nextToken("|");
		String secondOne=stringTokenizer.nextToken();
		return Integer.parseInt(firstOne);
	}
	private static String getToken(String token){
		StringTokenizer stringTokenizer=new StringTokenizer(token);
		String firstOne=stringTokenizer.nextToken("|");
		return stringTokenizer.nextToken();
	}

}
