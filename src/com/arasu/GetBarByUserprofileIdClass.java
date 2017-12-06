package com.arasu;

import java.sql.Connection;

public class GetBarByUserprofileIdClass {
	public static FrontBarResponse getbarbyuserprofileid(int proid){
		FrontBarResponse userfirst=new FrontBarResponse();
		 Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try{
				return InsertBarClass.getBarbyuserprofileid(proid);
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
