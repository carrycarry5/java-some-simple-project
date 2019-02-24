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
		//����map����
		Properties pro = new Properties();
		//����
		pro.load(reader);
		//��ȡֵ
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");	
		
		try {
			//ע������
			Class.forName(driver);
			//��������
			conn=DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);              //�����ֶ��ύ
			//�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, content);
			ps.setInt(3, num);
			ps.executeUpdate();                            //ִ�����
			conn.commit();                                          //�ύ
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
