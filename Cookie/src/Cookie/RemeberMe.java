package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 记住用户名，登陆界面
 * @author wushijia
 *
 */
public class RemeberMe extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//获得客户端保存的Cookie
		Cookie[] cookies = req.getCookies();
		String username = "";
		String checked = "";
		for (int i = 0;cookies != null && i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				username = cookies[i].getValue();//记住的用户名的值
				checked = "checked='checked'";
			}
		}
		
		PrintWriter out = resp.getWriter();
		out.write("<form action='"+req.getContextPath()+"/cookie/remeberme1' method='post'>");
		out.write("用户名:<input type='text' name='userName' value='"+username+"'><br/>");
		out.write("密码:<input type='password' name='pwd'><br/>");
		out.write("<input type='checkbox' name='remeber'"+checked+">记住用户名<br/>");
		out.write("<input type='submit' value='登陆'><br/>");
		out.write("</form>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
