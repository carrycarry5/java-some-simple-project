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
	
	public static void add(String name , int num , String intime,String category) throws FileNotFoundException, IOException, SQLException{
		//��������
		conn = jdbc_utils.getConnection();
		//�������
		String sql  = "insert into product(name,num,intime,category) values(?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, num);
		ps.setString(3, intime);
		ps.setString(4, category);
		//�ύ
		ps.executeUpdate();
		//�ͷ���Դ
		jdbc_utils.free(conn, ps, rs);
	}
}
