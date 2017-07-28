package ServletDemo1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletConfig extends HttpServlet{
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;//��������ļ�����
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String encoding = config.getInitParameter("encoding");//��������ļ��е���Ϣ
		System.out.println(encoding);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
