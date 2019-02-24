package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.jdbc_utils;

public class jdbc_update {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	//出货
	public static void update(String name , int outnum , String outtime , int num) throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql  = "update product set outnum=?,outtime=?,num=? where name=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, outnum);
		ps.setString(2, outtime);
		ps.setInt(3, num);
		ps.setString(4, name);
		//提交
		ps.executeUpdate();
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
}
