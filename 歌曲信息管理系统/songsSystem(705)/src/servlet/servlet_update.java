package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Song;
import dao.jdbc_add;
import dao.jdbc_delete;
import dao.jdbc_select;

@WebServlet("/update")
public class servlet_update extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");        //获取参数
		HashMap< String , Song> map = jdbc_select.getMap();       //获取map集合
		System.out.println(map.size());
		Song s = map.get(name);           //通过参数获得对象
		HttpSession session = req.getSession();        //获取session
		session.setAttribute("song", s);        //把歌曲传入session
		System.out.println(s.getAlbums());
		//页面跳转
		resp.sendRedirect("/update.jsp");
		
	}

	
	
}
