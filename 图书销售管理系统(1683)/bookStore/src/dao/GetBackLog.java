package dao;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import domain.BackLog;


public class GetBackLog {
	public static ArrayList<BackLog> BackLogList = new ArrayList<>();                       //定义集合用于存储全部log对象
	
	public static void getBackLog() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Reader reader = new FileReader("src/user.properties");
		Properties pro = new Properties();
		pro.load(reader);
		String driver  = pro.getProperty("driver");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String url = pro.getProperty("url");
		
		try {
			//注册驱动
			Class.forName(driver);
			//建立连接
			conn=DriverManager.getConnection(url, user, password);
			//设置手动提交
			conn.setAutoCommit(false);
			//创建执行对象
			String sql = "select * from backlog";
			ps=conn.prepareStatement(sql);
			//创建结果集
			rs=ps.executeQuery();
			while(rs.next()){
				BackLog log = new BackLog();
				log.setTime(rs.getString("time"));
				log.setNum(rs.getInt("number"));
				log.setContent(rs.getString("content"));
				log.setId(rs.getInt("id"));
				BackLogList.add(log);
			}
			//提交
			conn.commit();
			
		} catch (Exception e) {
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			} 
			if (ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}














