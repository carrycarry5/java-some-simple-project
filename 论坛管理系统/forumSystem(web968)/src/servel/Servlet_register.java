package servel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc_add;

@WebServlet("/register")
public class Servlet_register extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�������
		String name = new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String sex = new String(req.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		String age = new String(req.getParameter("age").getBytes("iso-8859-1"),"utf-8");
		String job = new String(req.getParameter("job").getBytes("iso-8859-1"),"utf-8");
		String like = new String(req.getParameter("like").getBytes("iso-8859-1"),"utf-8");
		try {
			//�����ݴ������ݿ�
			jdbc_add.add(name, sex, age, job, like);
			//��ת����¼ҳ��
			resp.sendRedirect("/index.html");
		} catch (Exception e) {                 //�����쳣����˵���Ѵ��ڸ��û�
			req.getRequestDispatcher("view/wait/goToLogin.html").forward(req, resp);
		}
	}
	
}
