package dao;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Test;

import domain.Market1;


public class GetMarket1 {
	//获取数据库中的信息
	 public static ArrayList<Market1> market1List= new ArrayList<>();                //创建集合用于存储market1对象
	@Test
	public  static void getMarket1() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Reader reader = new FileReader("src//user.properties");
		//创建map集合
		Properties pro = new Properties();
		//加载
		pro.load(reader);
		//获取值
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");	
		try {
			//注册驱动
			Class.forName(driver);
			//建立连接
			conn=DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);           //设置未手动提交
			//创建语句
			String sql = "select * from market1 where id=?";
			ps=conn.prepareStatement(sql);
			//获取数据库的值
			for(int i=1 ; i <=4 ; i++){
				ps.setInt(1, i);
				Market1 m = new Market1() ;                 //创建market1对象用于存储数据库的值
				//创建结果集
				rs=ps.executeQuery();                            
				while(rs.next()){
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setPrice(rs.getDouble("price"));
					m.setNumber(rs.getInt("number"));
				}
				market1List.add(m);
			}
			conn.commit();                 //提交
		} catch (Exception e) {
			try {
				if (conn!=null) {
					conn.rollback();          //回滚
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			//释放资源
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if (conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			
		}
	}
}
