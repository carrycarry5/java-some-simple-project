package dao;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class UpdateLog {
	public static void update(String sql , String date, String content,int num) throws Exception{
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
			ps=conn.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, content);
			ps.setInt(3, num);
			ps.executeUpdate();                            //执行语句
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
