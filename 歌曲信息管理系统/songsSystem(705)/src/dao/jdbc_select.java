package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import bean.Song;
import utils.jdbc_utils;

public class jdbc_select {
	private static ArrayList<Song> list = new ArrayList<>();
	private static ArrayList<String > names = new ArrayList<>();
	private static HashMap< String , Song> map = new HashMap<>();
	private static IdentityHashMap<String , Song> map_author = new IdentityHashMap<>();
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static String name;
	private static String author;
	private static String singer;
	private static String releaseTime;
	private static String albums;
	
	public static void select() throws FileNotFoundException, IOException, SQLException{
		list.clear();             //每次访问这个页面时都先清空list
		map.clear();
		map_author.clear();
		//建立连接
		conn = jdbc_utils.getConnection();
		//建立语句
		String sql = "select * from song";
		ps = conn.prepareStatement(sql);
		//获取结果集
		rs = ps.executeQuery();
		//封装对象
		while(rs.next()){
			name = rs.getString("name");
			author = rs.getString("author");
			singer = rs.getString("singer");
			releaseTime =rs.getString("releasetime");
			albums = rs.getString("albums");
			Song s = new Song(name, author, singer, releaseTime, albums);
			
			list.add(s);
			map.put(s.getName(), s);
			map_author.put(s.getAuthor(), s);
			
			
		}
		
		//释放资源
		jdbc_utils.free(conn, ps, rs);
	}

	public static ArrayList<Song> getList() throws FileNotFoundException, IOException, SQLException {
		select();          //获取list集合之前，先调用方法获取结果集
		return list;
	}

	public static HashMap<String, Song> getMap() {
		return map;
	}

	public static IdentityHashMap<String , Song> getMap_author() {
		return map_author;
	}

}
