package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SelectUser;
import domain.User;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//��ȡҳ������
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		System.out.println(email+password);
		//��ȡ���ݿ�����
		HashMap<String , String> massage = SelectUser.selectUser();
		Set<String > emails = massage.keySet();
		for (String string : emails) {
			String ps = massage.get(string);
			if (ps.equals(password) && string.equals(email)) {              //����û��������붼��ȷ������ѭ����������ҳ
				req.getRequestDispatcher("/homepage.html").forward(req, resp);;              //��ҳ
				return ;
			}
		}
		req.setAttribute("wrong", -1);                //���û�ҵ�ƥ����û������룬�����ص�½����
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
}
