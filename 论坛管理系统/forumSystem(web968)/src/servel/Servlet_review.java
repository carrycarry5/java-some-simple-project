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
		//��ȡ�������
		message = new String(req.getParameter("reviewMessage").getBytes("iso-8859-1"),"utf-8");
		name = Servlet_login.getName();                 //��ȡ��ǰ�û�������
		time  = utils.GetCurrentTime.getTime();        //��ȡ��ǰʱ��
		postID = Servlet_seePost.getId();                //��ȡpost��id��
		try {
			jdbc_add.addReply(message, name, time,postID);       //���ظ���Ϣ��ӵ����ݿ�
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//��ȡ�����ӵ�ȫ���ظ�
		try {
			replyList = jdbc_select.getReplyList(postID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		req.getSession().setAttribute("replyList", replyList);               //���ظ�����ȫ������session
		
		//ҳ����ת
		resp.sendRedirect("view/post/seePost.jsp");
	}
	
}
