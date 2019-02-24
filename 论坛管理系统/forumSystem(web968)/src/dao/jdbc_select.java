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
	private static ArrayList<String> names = new ArrayList<>();             //��ȡȫ���û���
	private static ArrayList<Integer> ids = new ArrayList<>();            //��ȡȫ��id
	private static ArrayList<Post> postList = new ArrayList<>();           //��ȡȫ��post����
	private static ArrayList<Reply> replyList = new ArrayList<>();             //����postid��ȡ�����ӵ����лظ��Ķ���
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static void select() throws FileNotFoundException, IOException, SQLException{
		//��������
		conn = jdbc_utils.getConnection();
		//�������
		String sql = "select name from author";
		ps = conn.prepareStatement(sql);
		//��ȡ�����
		rs = ps.executeQuery();
		while(rs.next()){
			String name = rs.getString("name");
			names.add(name);              //������name���뼯����
		}
		
		//�ͷ���Դ
		jdbc_utils.free(conn, ps, rs);
	}
	
	public static void selectPost() throws FileNotFoundException, IOException, SQLException{
		postList.clear();                //ÿ�β�ѯǰ���Ȱ�list���
		//��������
		conn = jdbc_utils.getConnection();
		//�������
		String sql = "select * from post";
		ps = conn.prepareStatement(sql);
		//��ȡ�����
		rs = ps.executeQuery();
		while(rs.next()){
			String message = rs.getString("postmessage");
			String time = rs.getString("posttime");
			String name = rs.getString("name");
			int id = rs.getInt("id");
			String title = rs.getString("title");
			Post post = new Post(id,title, time, message, name);            //��װ�ɶ���
			postList.add(post);
			ids.add(id);              //������i���뼯����
		}
		
		//�ͷ���Դ
		jdbc_utils.free(conn, ps, rs);
	}
	
	//�˷�������ͨ��id��ѯpost���󲢷���
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
	
	//��������id��ѯ�����ӵ����лظ�
	public static void selectReviewBYPostID(String postID) throws FileNotFoundException, IOException, SQLException{
		replyList.clear();                             //ÿ�β�ѯǰ�����list
		String replyauthor = null;
		String message = null;
		String time = null;
		
		//��������
		conn  = jdbc_utils.getConnection();
		//�������
		String sql = "select * from reply where postid=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(postID));
		//��ȡ�����
		rs = ps.executeQuery();
		while(rs.next()){
			replyauthor = rs.getString("replyauthor");
			message = rs.getString("replymessage");
			time = rs.getString("time");
			Reply reply = new Reply(message, replyauthor, time, postID);
			replyList.add(reply);                //���ظ�����ȫ�����뼯����
		}
	}
	
	public static ArrayList<Integer> getIds() throws FileNotFoundException, IOException, SQLException {
		selectPost();
		return ids;
	}

	public static ArrayList<String> getNames() throws FileNotFoundException, IOException, SQLException {
		select();               //ÿ�λ�ȡname���ϵ�ʱ���Ȳ�ѯһ�����ݿ�
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
