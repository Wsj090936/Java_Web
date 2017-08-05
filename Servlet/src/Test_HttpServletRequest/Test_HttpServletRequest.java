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
		//������Ϣ�в���
		System.out.println(req.getMethod());//�õ�����ʽ
		System.out.println(req.getRequestURL());//�õ��ͻ������������URL
		System.out.println(req.getRequestURI());//�õ��������е���Դ������
		System.out.println(req.getContextPath());//�õ�Ӧ�õ�����Ŀ¼ Servlet
		System.out.println(req.getQueryString());//�õ�������Ϣ���еĲ�������
		//������Ϣͷ����
		String header = req.getHeader("User-Agent");//�õ��ͻ��˵���Ϣ
		System.out.println(header);
		Enumeration<String> names = req.getHeaderNames();//�õ�����������Ϣͷ�е�name
		while(names.hasMoreElements()){//�õ�ÿһ��name��Ӧ��ֵ
			String name = names.nextElement();
			System.out.println(name+":"+req.getHeader(name));
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
