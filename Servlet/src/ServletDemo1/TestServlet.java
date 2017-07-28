package ServletDemo1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet{
	//初始化  只在第一次被访问时执行
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化");
	}
	//服务  每次访问servlet就执行一次
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("服务");
	}
	//销毁  在卸载应用后执行
	@Override
	public void destroy() {
		System.out.println("销毁");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}


}
