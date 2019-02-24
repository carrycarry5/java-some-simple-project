package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Song;
import dao.jdbc_select;

@WebServlet("/index")
public class servlet_index extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Song> list = new ArrayList<>();
		try {
			list = jdbc_select.getList();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}      //获取map
		HttpSession session = req.getSession();     //获取session
		session.setAttribute("list", list);
		resp.sendRedirect("/index.jsp");
	}
	
}
