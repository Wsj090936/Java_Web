package Test_HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test_HttpServletRequest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求消息行部分
		System.out.println(req.getMethod());//得到请求方式
		System.out.println(req.getRequestURL());//得到客户端请求的完整URL
		System.out.println(req.getRequestURI());//得到请求行中的资源名部分
		System.out.println(req.getContextPath());//得到应用的虚拟目录 Servlet
		System.out.println(req.getQueryString());//得到请求消息行中的参数部分
		//请求消息头部分
		String header = req.getHeader("User-Agent");//得到客户端的信息
		System.out.println(header);
		Enumeration<String> names = req.getHeaderNames();//得到所有请求消息头中的name
		while(names.hasMoreElements()){//得到每一个name对应的值
			String name = names.nextElement();
			System.out.println(name+":"+req.getHeader(name));
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
