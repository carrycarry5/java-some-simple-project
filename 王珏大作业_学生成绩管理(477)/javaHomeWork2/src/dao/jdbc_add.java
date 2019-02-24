package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.jdbc_utils;

public class jdbc_add {
	private static  Connection conn = null;
	private static  PreparedStatement ps = null;
	private static  ResultSet rs = null;
	
	public static void add(String id, String name,double pingshi , double kaoshi , String type) throws SQLException{
			//建立连接
			conn = jdbc_utils.getConnection();
			//创建语句
			String sql = "insert into student values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setDouble(3, pingshi);
			ps.setDouble(4, kaoshi);
			ps.setString(5, type);
			ps.executeUpdate();
			
			//释放资源
			jdbc_utils.free(conn, ps, rs);
	}
}
