package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectUser {

	public static HashMap<String , String> selectUser(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap<String , String > massage  =new HashMap<>();
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			String url="jdbc:mysql://localhost:3306/POPPRO";
			String user="root";
			String password="root";
			conn=DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			//�������
			String sql = "select * from user";
			ps=conn.prepareStatement(sql);
			//���������
			rs=ps.executeQuery();
			while(rs.next()){
				massage.put(rs.getString("email"), rs.getString("password"));
			}
			
			//�ύ
			conn.commit();		
			
		} catch (Exception e) {
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			
		} finally {
			
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		
		return massage;
	}
}
