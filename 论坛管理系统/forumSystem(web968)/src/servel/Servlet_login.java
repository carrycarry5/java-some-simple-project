package servel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import dao.jdbc_select;

@WebServlet("/login")
public class Servlet_login extends HttpServlet {
	private static  String name = null;
	private static ArrayList<Post> postList = new ArrayList<>();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		name = new String(req.getParameter("name").getBytes("iso-8859-1") ,"utf-8");         //��ȡ�������
		ArrayList<String > names = new ArrayList<>();
		//��������
		try {
			names = jdbc_select.getNames();            //��ȡ���ݿ���������û���
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			postList = jdbc_select.getPostList();         //��ȡ���ݿ������е����Ӷ���
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("postList", postList);         //������session
		
		if (names.contains(name)) {                 //����û������ڣ�����ת������ҳ��
			req.getSession().setAttribute("userName", name);               //����ǰ�û�������session
			resp.sendRedirect("view/post/post.jsp");
		}else{                                                   //������ת��ע��ҳ��
			req.getRequestDispatcher("view/wait/goToRegister.html").forward(req, resp);
		}
		
	}
	public static String getName() {
		return name;
	}

		
}
