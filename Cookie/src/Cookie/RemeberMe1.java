package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemeberMe1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//��ȡ������
		String username = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String remeber = req.getParameter("remeber");//����ѡ��͵�ѡ��û�б�ѡ��ʱ���䷵��ֵΪnull
		Cookie ck = new Cookie("userName",username);
		ck.setPath("/");//����·��
		//����ҵ���߼�
		//ת���Ͷ���
		if("tom".equals(username) && "123".equals(pwd)){
			if(remeber != null){
				ck.setMaxAge(60*60);//���ñ���һ��Сʱ
			}else{
				ck.setMaxAge(0);//ɾ��Cookie
			}
			resp.addCookie(ck);//��Cookieд�뻺��
			out.write("��½�ɹ���");
		}else{
			out.write("��½ʧ�ܣ����������û����������Ƿ���ȷ");
			//�����������ص�½����
			resp.setHeader("refresh", "2;url="+req.getContextPath()+"/cookie/remeberme");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
