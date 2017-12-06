package utils;

public class Constants {
	public static final String URL="jdbc:mysql://210.18.177.47:3306/bar";
	//public static final String URL="jdbc:mysql://bardemo.cncsloojkjm3.ap-south-1.rds.amazonaws.com:3306/bar";
	
	
	//below is for testing db connection
	//public static final String URL="jdbc:mysql://demobar.cncsloojkjm3.ap-south-1.rds.amazonaws.com:3306/bar";

	public static final String USER="root";
	//password and user name is same for both testing and production connections
//public static final String USER="kyros";

	public static final String PASSWORD="kyrostechnologies";
//public static final String PASSWORD="kyrostechnologies";

	public static final String DRIVER_CLASS="com.mysql.jdbc.Driver";

	public static final String TABLE_NAME="userprofile";
	
	//public static final String PICTURE_URL="http://kyrosbar.ap-south-1.elasticbeanstalk.com/rest/getLiquorPicture/";
	//below is the testing end url:
		public static final String PICTURE_URL="http://210.18.177.47:1234/Bar/rest/getLiquorPicture/";

	
	
	//public static final String STATIC_URL="http://kyrosbar.ap-south-1.elasticbeanstalk.com/rest";
	
	//BELOW IS THE TESTING END URL;
	
		//public static final String STATIC_URL="http://developmentkyrosbar.ap-south-1.elasticbeanstalk.com/rest";

	
	
	
		

	//	public static final String PURCHASE_PICTURE_URL="http://kyrosbar.ap-south-1.elasticbeanstalk.com/rest/getPurchaseLiquorPicture/";
		//BELOW IS THE TESTING END URL:
		
		
			public static final String PURCHASE_PICTURE_URL="http://210.18.177.47/Bar/rest/getPurchaseLiquorPicture/";

	
}
