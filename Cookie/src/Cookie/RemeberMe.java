package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ס�û�������½����
 * @author wushijia
 *
 */
public class RemeberMe extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//��ÿͻ��˱����Cookie
		Cookie[] cookies = req.getCookies();
		String username = "";
		String checked = "";
		for (int i = 0;cookies != null && i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				username = cookies[i].getValue();//��ס���û�����ֵ
				checked = "checked='checked'";
			}
		}
		
		PrintWriter out = resp.getWriter();
		out.write("<form action='"+req.getContextPath()+"/cookie/remeberme1' method='post'>");
		out.write("�û���:<input type='text' name='userName' value='"+username+"'><br/>");
		out.write("����:<input type='password' name='pwd'><br/>");
		out.write("<input type='checkbox' name='remeber'"+checked+">��ס�û���<br/>");
		out.write("<input type='submit' value='��½'><br/>");
		out.write("</form>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
