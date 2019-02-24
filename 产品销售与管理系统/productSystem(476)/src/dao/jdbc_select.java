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
	private static ArrayList<String> names = new ArrayList<>();      //用于存储产品名称
	private static int num = 0;
	
	public static void select() throws FileNotFoundException, IOException, SQLException{
		int id = 0;
		String name = null;
		int num = 0;
		int outnum = 0;
		String intime = null;
		String outtime = null;
		String category = null;
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
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
			System.out.println("id="+id+"  名称"+name +"  数量="+num+"  出货数量"+outnum+
					"  进货时间="+intime+"  出货时间="+outtime+"  产品类别="+category);
			names.add(name);
		}
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
	
	public static void select_num() throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql  = "select * from product";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			num = rs.getInt("num");
		}
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}

	public static ArrayList<String> getNames() throws FileNotFoundException, IOException, SQLException {
		select();                 //每次调用时先查询
		return names;
	}

	//获取当前产品的数量
	public static int getNum() throws FileNotFoundException, IOException, SQLException {
		select_num();
		return num;
	}
	
	
	
}
