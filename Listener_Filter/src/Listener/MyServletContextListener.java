package Listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//�õ�ServletContext�����
		ServletContext application = sce.getServletContext();
		//����һ���������ڴ洢����Session��
		List<HttpSession> list = Collections.synchronizedList(new ArrayList<>());//�ü��ϱ���Ϊ�̰߳�ȫ�ļ��ϣ�����ᱨ��
		
		//�����Ϸ���application����
		application.setAttribute("sessions", list);
		
		//����һ����ʱ��
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000){//������5s������
						session.invalidate();
//						list.remove(session);
						iterator.remove();
					}
				}
/*				for (HttpSession session : list) {
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000){//������5s������
						session.invalidate();
						list.remove(session);
					}
				}*/
			}
		}, 2000, 5000);//�ӳ������ִ�У�ÿ���5Sִ��һ��
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}
