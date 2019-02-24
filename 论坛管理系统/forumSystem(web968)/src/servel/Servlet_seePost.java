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
		id = req.getParameter("id");           //获取贴子id号
		try {
			post = jdbc_select.selectforSeePost(id);             //获取该id的post对象
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.getSession().setAttribute("seePost", post);
		
		//获取该贴子的全部回复
				try {
					replyList = jdbc_select.getReplyList(id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				req.getSession().setAttribute("replyList", replyList);               //将回复对象全部存入session
		
		//页面跳转
		resp.sendRedirect("/view/post/seePost.jsp");
	}
	public static String getId() {
		return id;
	}

	
}
