package service;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegLog;
import dao.SaveUser;
import dao.SelectUser;
import dao.Times;
import domain.User;
@WebServlet("/saveUserServlet")
public class SaveUserServlet extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//������������
		String email = req.getParameter("email");
		String password=req.getParameter("password");
		String repassword = req.getParameter("repassword");
		
		if (!password.equals(repassword)) {              //�������ȷ�����벻��ʱ��ҳ����ת��ע��ҳ��
			req.setAttribute("PasswordError", -1);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
		//��������
		User user = new User(email, password);
		//�ж��û��Ƿ����
		HashMap<String , String > massage=SelectUser.selectUser();
		//��ȡȫ���û���
		Set<String > emails = massage.keySet();
		if (emails.contains(email)) {    //����û����ڣ�����ʾֱ�ӵ�½
			req.setAttribute("emailExist", -1);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else{                                    //����û������ڣ���������ݿ�,������ת����½����
			//���û���Ϣ�������ݿ�
			try {
				SaveUser.saveUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			//����־д�����ݿ�
			try {
				RegLog.saveLog(user);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//���µ����
			try {
				Times.saveTimes();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			//ҳ����ת
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		}
		
	}
	
}
