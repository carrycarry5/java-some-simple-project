package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.Post;
import bean.Reply;
import utils.jdbc_utils;

public class jdbc_select {
	private static ArrayList<String> names = new ArrayList<>();             //获取全部用户名
	private static ArrayList<Integer> ids = new ArrayList<>();            //获取全部id
	private static ArrayList<Post> postList = new ArrayList<>();           //获取全部post对象
	private static ArrayList<Reply> replyList = new ArrayList<>();             //根据postid获取该贴子的所有回复的对象
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
		postList.clear();                //每次查询前，先把list清空
		//建立连接
		conn = jdbc_utils.getConnection();
		//创建语句
		String sql = "select * from post";
		ps = conn.prepareStatement(sql);
		//获取结果集
		rs = ps.executeQuery();
		while(rs.next()){
			String message = rs.getString("postmessage");
			String time = rs.getString("posttime");
			String name = rs.getString("name");
			int id = rs.getInt("id");
			String title = rs.getString("title");
			Post post = new Post(id,title, time, message, name);            //封装成对象
			postList.add(post);
			ids.add(id);              //把所有i存入集合中
		}
		
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}
	
	//此方法用于通过id查询post对象并返回
	public static Post selectforSeePost(String id) throws FileNotFoundException, IOException, SQLException{
		String title = null;
		String time = null;
		String message = null;
		String name = null;
		conn = jdbc_utils.getConnection();
		String sql = "select * from post where id=?";
		ps=  conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		rs = ps.executeQuery();
		while(rs.next()){
			title = rs.getString("title");
			time = rs.getString("posttime");
			message = rs.getString("postmessage");
			name = rs.getString("name");
		}
		Post post = new Post(Integer.parseInt(id), title, time, message, name);
		return post;
	}
	
	//根据贴子id查询该贴子的所有回复
	public static void selectReviewBYPostID(String postID) throws FileNotFoundException, IOException, SQLException{
		replyList.clear();                             //每次查询前先清空list
		String replyauthor = null;
		String message = null;
		String time = null;
		
		//建立连接
		conn  = jdbc_utils.getConnection();
		//创建语句
		String sql = "select * from reply where postid=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(postID));
		//获取结果集
		rs = ps.executeQuery();
		while(rs.next()){
			replyauthor = rs.getString("replyauthor");
			message = rs.getString("replymessage");
			time = rs.getString("time");
			Reply reply = new Reply(message, replyauthor, time, postID);
			replyList.add(reply);                //将回复对象全部存入集合中
		}
	}
	
	public static ArrayList<Integer> getIds() throws FileNotFoundException, IOException, SQLException {
		selectPost();
		return ids;
	}

	public static ArrayList<String> getNames() throws FileNotFoundException, IOException, SQLException {
		select();               //每次获取name集合的时候先查询一遍数据库
		return names;
	}

	public static ArrayList<Post> getPostList() throws FileNotFoundException, IOException, SQLException {
		selectPost();
		return postList;
	}

	public static ArrayList<Reply> getReplyList(String postID) throws FileNotFoundException, IOException, SQLException {
		selectReviewBYPostID(postID);
		return replyList;
	}
	
		
}
