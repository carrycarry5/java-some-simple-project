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
		name = new String(req.getParameter("name").getBytes("iso-8859-1") ,"utf-8");         //获取请求参数
		ArrayList<String > names = new ArrayList<>();
		//处理事务
		try {
			names = jdbc_select.getNames();            //获取数据库里的所有用户名
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			postList = jdbc_select.getPostList();         //获取数据库里所有的帖子对象
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("postList", postList);         //将存入session
		
		if (names.contains(name)) {                 //如果用户名存在，则跳转至发帖页面
			req.getSession().setAttribute("userName", name);               //将当前用户名存入session
			resp.sendRedirect("view/post/post.jsp");
		}else{                                                   //否则跳转至注册页面
			req.getRequestDispatcher("view/wait/goToRegister.html").forward(req, resp);
		}
		
	}
	public static String getName() {
		return name;
	}

		
}
