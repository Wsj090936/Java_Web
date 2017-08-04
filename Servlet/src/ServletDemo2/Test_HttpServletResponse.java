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
	  /*Tomcat������Ĭ�ϵı���ΪISO-8859-1,��֧�����ģ�Ӧ������������ͷ�������ʹ��UTF-8����
		��ʽһ
		resp.setCharacterEncoding("UTF-8");//���߷�����ʹ��ʲô��������ı�
		resp.setHeader("content-type", "text/html;charset=UTF-8");//������Ӧ��Ϣͷ�����������ʹ��ʲô�������
		 */
		//��ʽ��
		resp.setContentType("text/html;charset=UTF-8");//��֪������ʹ��ʲô��������֪�����ʹ��ʲô����
		PrintWriter out = resp.getWriter();//�õ��ַ������
		out.write("��ã����磡");//��ͻ����������Ӧ�ı�
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
