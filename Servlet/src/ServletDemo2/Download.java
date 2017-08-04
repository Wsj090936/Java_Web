package ServletDemo2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 下载一张图片
 * @author wushijia
 *
 */
public class Download extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、得到文件的绝对路径,并且通过该路径得到一个字节输入流
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/TomCat.png");//得到下载文件的绝对路径
		FileInputStream fis = new FileInputStream(path);
		//2、创建字节输出流
		ServletOutputStream sos = resp.getOutputStream();
		//3、得到下载的文件名
		String filename = path.substring(path.lastIndexOf("\\")+1);//得到的文件名为TomCat.png
		//4、设置文件编码
		filename = URLEncoder.encode(filename, "UTF-8");//编码为UTF-8
		//5、告知客户端(浏览器)要下载文件
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		resp.setHeader("content-type", "image/png");//文件类型
		//6、输出
		byte[] b = new byte[1024];
		int len = 0;
		while((len=fis.read(b)) != -1){
			sos.write(b, 0, len);
		}
		sos.close();
		fis.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
