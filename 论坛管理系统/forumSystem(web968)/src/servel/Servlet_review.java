package servel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reply;
import dao.jdbc_add;
import dao.jdbc_select;

@WebServlet("/review")
public class Servlet_review extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = null;
		String time = null;
		String message = null;
		String postID = null;
		ArrayList< Reply> replyList = new ArrayList<>();
		//获取请求参数
		message = new String(req.getParameter("reviewMessage").getBytes("iso-8859-1"),"utf-8");
		name = Servlet_login.getName();                 //获取当前用户的名字
		time  = utils.GetCurrentTime.getTime();        //获取当前时间
		postID = Servlet_seePost.getId();                //获取post的id号
		try {
			jdbc_add.addReply(message, name, time,postID);       //将回复信息添加到数据库
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//获取该贴子的全部回复
		try {
			replyList = jdbc_select.getReplyList(postID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.getSession().setAttribute("replyList", replyList);               //将回复对象全部存入session
		
		//页面跳转
		resp.sendRedirect("view/post/seePost.jsp");
	}
	
}
