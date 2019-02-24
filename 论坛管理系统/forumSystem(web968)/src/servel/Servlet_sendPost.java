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
		//获取请求参数
		String message = new String(req.getParameter("message").getBytes("iso-8859-1"),"utf-8");
		String title = new String(req.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String time = GetCurrentTime.getTime();                  //获取当前时间
		ArrayList<Post> postList = new ArrayList<>();
		
		String name = Servlet_login.getName();                 //获取名字
		try {
			jdbc_add.addPost(time, message, name,title);              //存入数据库
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		int id = 0;
		try {
			 id = jdbc_select.getIds().get(jdbc_select.getIds().size()-1);               //获取id
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			postList = jdbc_select.getPostList();         //获取数据库里所有的帖子对象
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("postList", postList);         //将post对象存入session
		
	
		resp.sendRedirect("view/wait/SuccessPost.html");             //页面跳转
	}
	
}
