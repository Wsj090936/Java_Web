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
 * ����һ��ͼƬ
 * @author wushijia
 *
 */
public class Download extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1���õ��ļ��ľ���·��,����ͨ����·���õ�һ���ֽ�������
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/TomCat.png");//�õ������ļ��ľ���·��
		FileInputStream fis = new FileInputStream(path);
		//2�������ֽ������
		ServletOutputStream sos = resp.getOutputStream();
		//3���õ����ص��ļ���
		String filename = path.substring(path.lastIndexOf("\\")+1);//�õ����ļ���ΪTomCat.png
		//4�������ļ�����
		filename = URLEncoder.encode(filename, "UTF-8");//����ΪUTF-8
		//5����֪�ͻ���(�����)Ҫ�����ļ�
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		resp.setHeader("content-type", "image/png");//�ļ�����
		//6�����
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
