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
import bean.Reply;
import dao.jdbc_select;

@WebServlet("/seePost")
public class Servlet_seePost extends HttpServlet {
	
	private static String id = null;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Post post = new Post();
		ArrayList< Reply> replyList = new ArrayList<>();
		id = req.getParameter("id");           //��ȡ����id��
		try {
			post = jdbc_select.selectforSeePost(id);             //��ȡ��id��post����
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.getSession().setAttribute("seePost", post);
		
		//��ȡ�����ӵ�ȫ���ظ�
				try {
					replyList = jdbc_select.getReplyList(id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				req.getSession().setAttribute("replyList", replyList);               //���ظ�����ȫ������session
		
		//ҳ����ת
		resp.sendRedirect("/view/post/seePost.jsp");
	}
	public static String getId() {
		return id;
	}

	
}
