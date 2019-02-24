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
		String name = req.getParameter("name");        //��ȡ����
		HashMap< String , Song> map = jdbc_select.getMap();       //��ȡmap����
		System.out.println(map.size());
		Song s = map.get(name);           //ͨ��������ö���
		HttpSession session = req.getSession();        //��ȡsession
		session.setAttribute("song", s);        //�Ѹ�������session
		System.out.println(s.getAlbums());
		//ҳ����ת
		resp.sendRedirect("/update.jsp");
		
	}

	
	
}
