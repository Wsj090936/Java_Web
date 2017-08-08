package Cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie ck = new Cookie("lastTime","");
		ck.setPath("/");//����·����������ܻ�ɾ����ΪCookie��ͬ����
		ck.setMaxAge(0);//ɾ��Cookie
		resp.addCookie(ck);//��Cookieд�ؿͻ��˻���
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
