package ServletDemo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test_Redirect extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A:����С��");
		System.out.println("B:�������⣬�ҿ��Ը����������ģ����Լ�ȥ�Ұ�");
		/*resp.setStatus(302);//����״̬��Ϊ302���߿ͻ������¶�����Դ
		resp.setHeader("location", "/Servlet/redirect1");*/
		resp.sendRedirect("/Servlet/redirect1");
		System.out.println("A:�õģ���֪����");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
