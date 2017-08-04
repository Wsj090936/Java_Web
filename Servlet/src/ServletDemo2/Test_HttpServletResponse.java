package ServletDemo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test_HttpServletResponse extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  /*Tomcat服务器默认的编码为ISO-8859-1,不支持中文，应当告诉浏览器和服务器，使用UTF-8编码
		方式一
		resp.setCharacterEncoding("UTF-8");//告诉服务器使用什么编码解析文本
		resp.setHeader("content-type", "text/html;charset=UTF-8");//设置响应消息头，告诉浏览器使用什么编码解析
		 */
		//方式二
		resp.setContentType("text/html;charset=UTF-8");//告知服务器使用什么解析，告知浏览器使用什么编码
		PrintWriter out = resp.getWriter();//得到字符输出流
		out.write("你好，世界！");//向客户端浏览器响应文本
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
