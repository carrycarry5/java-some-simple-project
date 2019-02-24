package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import domain.User;

public class RegLog {
	public static void saveLog(User user) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/POPPRO", "root", "root");
			conn.setAutoCommit(false);
			//创建sql语句
			String email=user.getEmail();			
			String sql = "insert into reglog(email,massage) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			String date = new Date().toLocaleString();
			ps.setString(2,"于"+date+"完成注册。");
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
