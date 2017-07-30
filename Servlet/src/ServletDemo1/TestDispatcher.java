package ServletDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet的请求转发
 * @author wushijia
 *
 */
public class TestDispatcher extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我想拿个东西");
		System.out.println("这个东西不在我这里，在别人那里，我帮你去取");
		this.getServletContext().getRequestDispatcher("/dispatcher1").forward(request, response);
		System.out.println("东西拿到了");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
