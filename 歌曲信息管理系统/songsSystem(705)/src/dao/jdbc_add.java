package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.jdbc_utils;

public class jdbc_add {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static void add(String name, String author,String singer , String releaseTime , String albums) throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql = "insert into song values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		//sql注入
		ps.setString(1, name);
		ps.setString(2, author);
		ps.setString(3, singer);
		ps.setString(4, releaseTime);
		ps.setString(5, albums);
		//执行语句
		ps.executeUpdate();
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
}



