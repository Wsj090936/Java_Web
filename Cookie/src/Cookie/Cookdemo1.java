package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookdemo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//获取客户端最后的访问时间
		Cookie[] cookies = req.getCookies();//获取客户端所有cookie对象
		PrintWriter out = resp.getWriter();
		for (int i = 0;cookies != null && i < cookies.length; i++) {
			if("lastTime".equals(cookies[i].getName())){//判断当前cookie是否为想要的对象
				long time = Long.parseLong(cookies[i].getValue());
				out.write("你的最后访问时间为:"+ new Date(time).toLocaleString());
			}
		}
		out.print("<a href='"+req.getContextPath()+"/cookie/clear'>清除缓存</a>");//添加删除Cookie的标签
		//响应cookie
		Cookie ck = new Cookie("lastTime", System.currentTimeMillis()+"");
		ck.setPath("/");//设置存储路径
		ck.setMaxAge(60*10);//设置保存时间为10分钟
		resp.addCookie(ck);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
