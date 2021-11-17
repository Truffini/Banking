//package trevor.RAP.bank;
//
//import java.sql.Connection; 
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.io.InputStream;
//import java.util.Properties;
//import java.io.IOException;
//
//
//public class utilities {
//	
//	private static String CONNECTION_PASSWORD;
//	private static String CONNECTION_USERNAME;
//	private static String CONNECTION_URL;
//	private static Connection connection;
//	
//	
//	static {
//		try {
//			InputStream input = ClassLoader.getSystemResourceAsStream("App.properties");
//			Properties properties = new Properties();
//			properties.load(input);
//			
//			String SYSTEM_VARIABLE_USERNAME = properties.getProperty("USERNAME_PROPERTY");
//			String SYSTEM_VARIABLE_PASSWORD = properties.getProperty("PASSWORD_PROPERTY");
//			String SYSTEM_VARIABLE_URL = properties.getProperty("URL_PROPERTY");
//			
//			CONNECTION_USERNAME = System.getenv(SYSTEM_VARIABLE_USERNAME);
//			CONNECTION_PASSWORD = System.getenv(SYSTEM_VARIABLE_PASSWORD);
//			CONNECTION_URL = System.getenv(SYSTEM_VARIABLE_URL);
//			
//			input.close();
//			
//		}catch(IOException ex){
//			ex.printStackTrace();
//		}
//	}
//	
//	
//	public static void main(String[] args) {
//		
//		try {
//			Class.forName("org.postgresql.Driver");
//		}catch(ClassNotFoundException ex) {
//			System.out.println("no driver");
//			ex.printStackTrace();
//		}
//		
//		try {
//			Connection connection = DriverManager.getConnection(CONNECTION_URL,CONNECTION_USERNAME, CONNECTION_PASSWORD);
//			System.out.println("good " + connection.isValid(5));
//		}catch(SQLException ex) {
//			System.out.println("fail");
//			ex.printStackTrace();
//			
//		}
//	}
//	
//	public static Connection getConnection() throws SQLException{
//		
//		try {
//			Class.forName("org.postgresql.Driver");
//		}catch(ClassNotFoundException ex) {
//			System.out.println("no driver");
//			ex.printStackTrace();
//		}
//		
//		if (connection == null || connection.isClosed()) {
//			connection = DriverManager.getConnection(CONNECTION_URL,CONNECTION_USERNAME, CONNECTION_PASSWORD);
//		}
//		
//		return connection;
//	}
//
//}
package trevor.RAP.bank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class utilities {
	
	private static String CONNECTION_USERNAME;
	private static String CONNECTION_PASSWORD;
	private static String CONNECTION_URL;
	private static Connection connection;
	
	static {
		try {
			// save properties (key/value pairs) into an object
			InputStream input = ClassLoader.getSystemResourceAsStream("App.properties");
			Properties properties = new Properties();
			properties.load(input);		
			
			// get the system variable name from the properties file
			String SYSTEM_VARIABLE_USERNAME = properties.getProperty("USERNAME_PROPERTY");
			String SYSTEM_VARIABLE_PASSWORD = properties.getProperty("PASSWORD_PROPERTY");
			String SYSTEM_VARIABLE_URL = properties.getProperty("URL_PROPERTY");
			
			// get the value from the system variable
			CONNECTION_USERNAME = System.getenv(SYSTEM_VARIABLE_USERNAME);
			CONNECTION_PASSWORD = System.getenv(SYSTEM_VARIABLE_PASSWORD);
			CONNECTION_URL = System.getenv(SYSTEM_VARIABLE_URL);
			
			input.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// not necessary if it can be found in classpath
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Could not register driver!");
			ex.printStackTrace();
		}
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		return connection;
	}
}