package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.jdbc_utils;

public class jdbc_select {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ArrayList<String> names = new ArrayList<>();      //���ڴ洢��Ʒ����
	private static int num = 0;
	
	public static void select() throws FileNotFoundException, IOException, SQLException{
		int id = 0;
		String name = null;
		int num = 0;
		int outnum = 0;
		String intime = null;
		String outtime = null;
		String category = null;
		//��������
		conn = jdbc_utils.getConnection();
		//�������
		String sql  = "select * from product";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			id = rs.getInt("id");
			name = rs.getString("name");
			num = rs.getInt("num");
			outnum = rs.getInt("outnum");
			intime = rs.getString("intime");
			outtime = rs.getString("outtime");
			category = rs.getString("category");
			System.out.println("id="+id+"  ����"+name +"  ����="+num+"  ��������"+outnum+
					"  ����ʱ��="+intime+"  ����ʱ��="+outtime+"  ��Ʒ���="+category);
			names.add(name);
		}
		//�ͷ���Դ
		jdbc_utils.free(conn, ps, rs);
	}
	
	public static void select_num() throws FileNotFoundException, IOException, SQLException{
		//��������
		conn = jdbc_utils.getConnection();
		//�������
		String sql  = "select * from product";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			num = rs.getInt("num");
		}
		//�ͷ���Դ
		jdbc_utils.free(conn, ps, rs);
	}

	public static ArrayList<String> getNames() throws FileNotFoundException, IOException, SQLException {
		select();                 //ÿ�ε���ʱ�Ȳ�ѯ
		return names;
	}

	//��ȡ��ǰ��Ʒ������
	public static int getNum() throws FileNotFoundException, IOException, SQLException {
		select_num();
		return num;
	}
	
	
	
}
