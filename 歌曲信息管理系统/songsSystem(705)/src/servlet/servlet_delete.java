package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc_delete;

@WebServlet("/delete")
public class servlet_delete extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");              //获取要删除歌曲的名字
		//执行删除
		try {
			jdbc_delete.delete(name);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//页面跳转
		resp.sendRedirect("/index");
	}
	
}
