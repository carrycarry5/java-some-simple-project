package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Song;
import dao.jdbc_select;

@WebServlet("/group")
public class servlet_group extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String author = req.getParameter("author");        //��ȡ�������
		
		ArrayList<Song > list = new ArrayList<>();    //����һ��map����������ߵĶ���
		
		IdentityHashMap<String , Song> map_author = jdbc_select.getMap_author();   //��ȡmap����
		Set<String > authors = map_author.keySet();
		for (String string : authors) {
			if (string.equals(author)) {
				list.add(map_author.get(string));      //�����������ͬ����浽list
			}
		}
		
		//�����ݴ���session
		HttpSession session = req.getSession();
		session.setAttribute("song_author", list);
		
		//ҳ����ת
		resp.sendRedirect("/groupByAuthor.jsp");
	}
	
}
