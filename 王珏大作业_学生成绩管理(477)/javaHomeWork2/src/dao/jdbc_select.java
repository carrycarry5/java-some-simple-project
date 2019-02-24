package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.IdentityHashMap;

import bean.Student;
import bean.liujiStudent;
import bean.putonStudent;
import bean.techangStudent;
import utils.jdbc_utils;

public class jdbc_select {
	private static  Connection conn = null;
	private static  PreparedStatement ps = null;
	private static  ResultSet rs = null;
	private static IdentityHashMap<String , Student> map = new IdentityHashMap<>();      //定义map集合用于存对象
	
	public static void select() throws SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql = "select * from student";
		ps = conn.prepareStatement(sql);
		//获取结果集
		rs = ps.executeQuery();
		while(rs.next()){
			String id = rs.getString("id");
			String name = rs.getString("name");
			double pingshi = rs.getDouble("pingshi");
			double kaoshi = rs.getDouble("kaoshi");
			String type = rs.getString("type");
			
			//封装成对象
			switch (type) {
			case "p":{
				putonStudent p = new putonStudent(name, id, pingshi, kaoshi);
				map.put(type, p);
				break;
			}	
			case "l":{
				liujiStudent l = new liujiStudent(name, id, pingshi, kaoshi);
				map.put(type, l);
				break;
			}
			case "t" :{
				techangStudent t = new techangStudent(name, id, pingshi, kaoshi);
				map.put(type, t);
				break;
			}
			default:
				break;
			}
			
		}
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}

	public static IdentityHashMap<String, Student> getMap() throws SQLException {
		select();      //获取map集合之前调用查询方法
		return map;
	}

	
	
}
