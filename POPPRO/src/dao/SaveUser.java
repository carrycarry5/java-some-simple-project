package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.User;

public class SaveUser {
	public static void saveUser(User user) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/POPPRO", "root", "root");
			conn.setAutoCommit(false);
			//����sql���
			String email=user.getEmail();
			String password = user.getPassword();
			String sql = "insert into user(email,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			//ִ�����
			ps.executeUpdate();
			//�ύ
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
