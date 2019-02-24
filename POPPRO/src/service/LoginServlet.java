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
		//获取页面数据
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		System.out.println(email+password);
		//获取数据库数据
		HashMap<String , String> massage = SelectUser.selectUser();
		Set<String > emails = massage.keySet();
		for (String string : emails) {
			String ps = massage.get(string);
			if (ps.equals(password) && string.equals(email)) {              //如果用户名和密码都正确，结束循环，进入主页
				req.getRequestDispatcher("/homepage.html").forward(req, resp);;              //主页
				return ;
			}
		}
		req.setAttribute("wrong", -1);                //如果没找到匹配的用户名密码，则跳回登陆界面
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
}
