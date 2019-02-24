package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.jdbc_utils;

public class jdbc_select {
	private static ArrayList<String> names = new ArrayList<>();
	private static ArrayList<Integer> ids = new ArrayList<>();
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static void select() throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql = "select name from author";
		ps = conn.prepareStatement(sql);
		//获取结果集
		rs = ps.executeQuery();
		while(rs.next()){
			String name = rs.getString("name");
			names.add(name);              //把所有name存入集合中
		}
		
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
	
	public static void selectPost() throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql = "select id from post";
		ps = conn.prepareStatement(sql);
		//获取结果集
		rs = ps.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			ids.add(id);              //把所有i存入集合中
		}
		
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
	
	
	public static ArrayList<Integer> getIds() {
		return ids;
	}

	public static ArrayList<String> getNames() {
		return names;
	}

	
	
}
