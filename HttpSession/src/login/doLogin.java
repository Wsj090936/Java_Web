package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class doLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("userName");//�õ��û���
		String pwd = req.getParameter("pwd");//�õ�����
		String code = req.getParameter("code");//�õ��û���֤���ֵ
		String rcode = (String) req.getSession().getAttribute("rcode");//�õ���ȷ����֤���ֵ
		if("jerry".equals(name) && "123".equals(pwd)){
			if(!rcode.equalsIgnoreCase(code)){//��֤�벻��ȷ
				req.setAttribute("msg", "��֤����������");
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}else{
				out.print("��½�ɹ�");
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
