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
		//接受请求数据
		String email = req.getParameter("email");
		String password=req.getParameter("password");
		String repassword = req.getParameter("repassword");
		
		if (!password.equals(repassword)) {              //当密码和确认密码不对时，页面跳转回注册页面
			req.setAttribute("PasswordError", -1);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
		//处理请求
		User user = new User(email, password);
		//判断用户是否存在
		HashMap<String , String > massage=SelectUser.selectUser();
		//获取全部用户名
		Set<String > emails = massage.keySet();
		if (emails.contains(email)) {    //如果用户存在，则提示直接登陆
			req.setAttribute("emailExist", -1);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else{                                    //如果用户不存在，则更新数据库,并且跳转到登陆界面
			//将用户信息传入数据库
			try {
				SaveUser.saveUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			//将日志写入数据库
			try {
				RegLog.saveLog(user);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//更新点击量
			try {
				Times.saveTimes();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			//页面跳转
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		}
		
	}
	
}
