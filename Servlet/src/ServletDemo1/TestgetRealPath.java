package ServletDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestgetRealPath
 */

public class TestgetRealPath extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/path.properties");//注意，要以/开头表示当前项目下(在部署的服务器上寻找)
		//获取文件内容
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		String name = pro.getProperty("name");
		System.out.println(name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
