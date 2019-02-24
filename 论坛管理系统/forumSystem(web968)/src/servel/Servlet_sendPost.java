package servel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import dao.jdbc_add;
import dao.jdbc_select;
import utils.GetCurrentTime;

@WebServlet("/sendPost")
public class Servlet_sendPost extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�������
		String message = new String(req.getParameter("message").getBytes("iso-8859-1"),"utf-8");
		String title = new String(req.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String time = GetCurrentTime.getTime();                  //��ȡ��ǰʱ��
		ArrayList<Post> postList = new ArrayList<>();
		
		String name = Servlet_login.getName();                 //��ȡ����
		try {
			jdbc_add.addPost(time, message, name,title);              //�������ݿ�
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		int id = 0;
		try {
			 id = jdbc_select.getIds().get(jdbc_select.getIds().size()-1);               //��ȡid
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			postList = jdbc_select.getPostList();         //��ȡ���ݿ������е����Ӷ���
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("postList", postList);         //��post�������session
		
	
		resp.sendRedirect("view/wait/SuccessPost.html");             //ҳ����ת
	}
	
}
