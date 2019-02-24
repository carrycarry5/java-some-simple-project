package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc_add;

@WebServlet("/add")
public class servlet_add  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取表单参数
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String singer = req.getParameter("singer");
		String releaseTime = req.getParameter("releaseTime");
		String albums = req.getParameter("albums");
		//执行添加操作
		try {
			jdbc_add.add(name, author, singer, releaseTime, albums);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//页面跳转
		resp.sendRedirect("/index");
	}
}
