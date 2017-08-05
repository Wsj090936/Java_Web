package ServletDemo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test_Redirect extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("A:我找小明");
		System.out.println("B:他不在这，我可以告诉你他在哪，你自己去找吧");
		/*resp.setStatus(302);//设置状态码为302告诉客户端重新定向资源
		resp.setHeader("location", "/Servlet/redirect1");*/
		resp.sendRedirect("/Servlet/redirect1");
		System.out.println("A:好的，我知道了");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
