package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookdemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//��ȡ�ͻ������ķ���ʱ��
		Cookie[] cookies = req.getCookies();//��ȡ�ͻ�������cookie����
		PrintWriter out = resp.getWriter();
		for (int i = 0;cookies != null && i < cookies.length; i++) {
			if("lastTime".equals(cookies[i].getName())){//�жϵ�ǰcookie�Ƿ�Ϊ��Ҫ�Ķ���
				long time = Long.parseLong(cookies[i].getValue());
				out.write("���������ʱ��Ϊ:"+ new Date(time).toLocaleString());
			}
		}
		out.print("<a href='"+req.getContextPath()+"/cookie/clear'>�������</a>");//���ɾ��Cookie�ı�ǩ
		//��Ӧcookie
		Cookie ck = new Cookie("lastTime", System.currentTimeMillis()+"");
		ck.setPath("/");//���ô洢·��
		ck.setMaxAge(60*10);//���ñ���ʱ��Ϊ10����
		resp.addCookie(ck);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
