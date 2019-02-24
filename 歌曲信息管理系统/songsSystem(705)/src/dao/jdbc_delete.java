package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.jdbc_utils;

public class jdbc_delete {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static void delete(String name) throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//建立语句
		String sql = "delete from song where name=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		//执行
		ps.executeUpdate();
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
}
