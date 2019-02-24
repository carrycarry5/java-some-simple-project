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
	//作者信息：包括作者昵称、性别、年龄、职业、爱好等
	public static void add(String name, String sex , String age , String job , String like) throws FileNotFoundException, IOException, SQLException{
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql = "insert into author values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		//sql注入
		ps.setString(1, name);
		ps.setString(2, sex);
		ps.setString(3, age);
		ps.setString(4, job);
		ps.setString(5, like);
		//执行
		ps.executeUpdate();
		
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
	
	public static void addPost(String time , String message , String name) throws FileNotFoundException, IOException, SQLException{
		//建立连接
				conn = jdbc_utils.getConnection();
				//创建语句
				String sql = "insert  into post(posttime,postmessage,name) values(?,?,?)";
				ps = conn.prepareStatement(sql);
				//sql注入
				ps.setString(1, time);
				ps.setString(2, message);
				ps.setString(3, name);
				//执行
				ps.executeUpdate();
				
				//释放资源
				jdbc_utils.free(conn, ps, rs);
	}
	public static void addReply(String replyMessage , String replyAuthor , String time) throws FileNotFoundException, IOException, SQLException{
		//建立连接
				conn = jdbc_utils.getConnection();
				//创建语句
				String sql = "insert  into reply(replymessage,replyauthor,time) values(?,?,?)";
				ps = conn.prepareStatement(sql);
				//sql注入
				ps.setString(1, replyMessage);
				ps.setString(2, replyAuthor);
				ps.setString(3, time);
				//执行
				ps.executeUpdate();
				
				//释放资源
				jdbc_utils.free(conn, ps, rs);
	}
}
