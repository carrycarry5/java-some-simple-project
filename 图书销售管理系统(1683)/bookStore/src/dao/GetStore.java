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

import domain.Store;


public class GetStore {
	//��ȡ���ݿ��е���Ϣ
		 public static ArrayList<Store> storeList= new ArrayList<>();                //�����������ڴ洢market1����
		@Test
		public  static void getStore() throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
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
				conn.setAutoCommit(false);           //����δ�ֶ��ύ
				//�������
				String sql = "select * from store where id=?";
				ps=conn.prepareStatement(sql);
				//��ȡ���ݿ��ֵ
				for(int i=1 ; i <=4 ; i++){
					ps.setInt(1, i);
					Store m = new Store() ;                 //����market1�������ڴ洢���ݿ��ֵ
					//���������
					rs=ps.executeQuery();
					while(rs.next()){
						m.setId(rs.getInt("id"));
						m.setName(rs.getString("name"));
						m.setPrice(rs.getDouble("price"));
						m.setNumber(rs.getInt("number"));
					}
					storeList.add(m);
				}
				conn.commit();                 //�ύ
			} catch (Exception e) {
				try {
					if (conn!=null) {
						conn.rollback();          //�ع�
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				//�ͷ���Դ
				if (conn!= null) {
					try {
						conn.close();
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
				if (rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
}
