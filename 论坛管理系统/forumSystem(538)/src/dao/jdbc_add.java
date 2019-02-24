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
	//������Ϣ�����������ǳơ��Ա����䡢ְҵ�����õ�
	public static void add(String name, String sex , String age , String job , String like) throws FileNotFoundException, IOException, SQLException{
		//��������
		conn = jdbc_utils.getConnection();
		//�������
		String sql = "insert into author values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		//sqlע��
		ps.setString(1, name);
		ps.setString(2, sex);
		ps.setString(3, age);
		ps.setString(4, job);
		ps.setString(5, like);
		//ִ��
		ps.executeUpdate();
		
		//�ͷ���Դ
		jdbc_utils.free(conn, ps, rs);
	}
	
	public static void addPost(String time , String message , String name) throws FileNotFoundException, IOException, SQLException{
		//��������
				conn = jdbc_utils.getConnection();
				//�������
				String sql = "insert  into post(posttime,postmessage,name) values(?,?,?)";
				ps = conn.prepareStatement(sql);
				//sqlע��
				ps.setString(1, time);
				ps.setString(2, message);
				ps.setString(3, name);
				//ִ��
				ps.executeUpdate();
				
				//�ͷ���Դ
				jdbc_utils.free(conn, ps, rs);
	}
	public static void addReply(String replyMessage , String replyAuthor , String time) throws FileNotFoundException, IOException, SQLException{
		//��������
				conn = jdbc_utils.getConnection();
				//�������
				String sql = "insert  into reply(replymessage,replyauthor,time) values(?,?,?)";
				ps = conn.prepareStatement(sql);
				//sqlע��
				ps.setString(1, replyMessage);
				ps.setString(2, replyAuthor);
				ps.setString(3, time);
				//ִ��
				ps.executeUpdate();
				
				//�ͷ���Դ
				jdbc_utils.free(conn, ps, rs);
	}
}
