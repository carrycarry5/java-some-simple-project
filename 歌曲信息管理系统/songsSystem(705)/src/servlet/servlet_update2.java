package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc_add;
import dao.jdbc_delete;

@WebServlet("/update2")
public class servlet_update2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ����
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String singer = req.getParameter("singer");
		String releaseTime = req.getParameter("releaseTime");
		String albums = req.getParameter("albums");
		
		//�޸Ĳ�������ɾ��ԭ��¼���ٰ��޸ĺ�ļ�¼���浽���ݿ�
		try {
			jdbc_delete.delete(name);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			jdbc_add.add(name, author, singer, releaseTime, albums);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//ҳ����ת
		resp.sendRedirect("/index");
	}
	
}
