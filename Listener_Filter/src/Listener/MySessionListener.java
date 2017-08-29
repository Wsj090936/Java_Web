package Listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		//�õ�ServletContext�����еļ���list
		ServletContext application = session.getServletContext();
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
		//�õ�Session���󣬽������list������
		list.add(session);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
