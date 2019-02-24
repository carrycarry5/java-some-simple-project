package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Times {
	public static void saveTimes() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int time=0;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/POPPRO", "root", "root");
			conn.setAutoCommit(false);
			//创建sql语句
			String sql = "select time from times";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				time=rs.getInt(1);
			}
			
			String sql2= "update times set time=?";
			ps=conn.prepareStatement(sql2);
			ps.setInt(1, time+1);
			//执行语句
			ps.executeUpdate();
			//提交
			conn.commit();
			
		} catch (Exception e) {
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}
