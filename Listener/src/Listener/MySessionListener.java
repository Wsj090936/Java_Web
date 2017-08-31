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
		//得到ServletContext对象中的集合list
		ServletContext application = session.getServletContext();
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
		//得到Session对象，将其放入list集合中
		list.add(session);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
