package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc_utils {
	private static String url ;
	private static  String password;
	private static  String user;
	
	//×¢²áÇý¶¯
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException{
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("src/jdbc.properties")));
		url = properties.getProperty("url");
		user = properties.getProperty("user");
	    password = properties.getProperty("password");
	    
	    return DriverManager.getConnection(url, user, password);
	}
	
	public static void  free(Connection conn , PreparedStatement ps , ResultSet rs) throws SQLException{
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			if (conn!=null) {
				conn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (conn!=null) {
				conn.close();
			}
			if (rs!=null) {
				rs.close();
			}
		}
	}
}
