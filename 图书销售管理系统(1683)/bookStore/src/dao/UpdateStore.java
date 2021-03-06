package dao;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import domain.Store;

public class UpdateStore {
	public static void  update(String sql,int num,int id) throws Exception{ //sql语句，变化数量，库存，id
		Connection conn = null;
		PreparedStatement ps = null;
		
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
			conn.setAutoCommit(false);              //设置手动提交
			//创建语句
			ArrayList<Store> list =GetStore.storeList;
			int amount=list.get(id-1).getNumber();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num+amount);                            //设置变动
			ps.setInt(2, id);
			ps.executeLargeUpdate();                            //执行语句
			conn.commit();                                          //提交
		} catch (Exception e) {
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();		
		}finally {
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
