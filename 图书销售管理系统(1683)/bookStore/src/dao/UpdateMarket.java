package dao;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Properties;
//���¹�Ӧ������
public class UpdateMarket {
	public static void update(String sql,int num ,int id) throws Exception{
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
			ps.setInt(1, num);                            //���ñ䶯
			ps.setInt(2, id);
			ps.executeLargeUpdate();                            //ִ�����
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
