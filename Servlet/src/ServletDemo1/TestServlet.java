package ServletDemo1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet{
	//��ʼ��  ֻ�ڵ�һ�α�����ʱִ��
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("��ʼ��");
	}
	//����  ÿ�η���servlet��ִ��һ��
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("����");
	}
	//����  ��ж��Ӧ�ú�ִ��
	@Override
	public void destroy() {
		System.out.println("����");
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
