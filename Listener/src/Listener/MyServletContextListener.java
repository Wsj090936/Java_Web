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
		//得到ServletContext域对象
		ServletContext application = sce.getServletContext();
		//创建一个集合用于存储所有Session、
		List<HttpSession> list = Collections.synchronizedList(new ArrayList<>());//该集合必须为线程安全的集合，否则会报错
		
		//将集合放在application域中
		application.setAttribute("sessions", list);
		
		//创建一个定时器
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000){//当超过5s就销毁
						session.invalidate();
//						list.remove(session);
						iterator.remove();
					}
				}
/*				for (HttpSession session : list) {
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000){//当超过5s就销毁
						session.invalidate();
						list.remove(session);
					}
				}*/
			}
		}, 2000, 5000);//延迟两秒后执行，每间隔5S执行一次
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}
