package ServletDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet������ת��
 * @author wushijia
 *
 */
public class TestDispatcher extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�����ø�����");
		System.out.println("�����������������ڱ�������Ұ���ȥȡ");
		this.getServletContext().getRequestDispatcher("/dispatcher1").forward(request, response);
		System.out.println("�����õ���");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
